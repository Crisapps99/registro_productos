package org.servlet.login.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.servlet.login.models.Producto;
import org.servlet.login.models.categoria;
import org.servlet.login.repositorio.productoRepositoriojdbcImplement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@WebServlet("/formulario")
public class ProductoFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        productoRepositoriojdbcImplement service = new productoRepositoriojdbcImplement(conn);

        Integer idProducto;
        try {
            idProducto = Integer.parseInt(req.getParameter("idProducto"));
        } catch (NumberFormatException e) {
            idProducto = 0;
        }

        Producto producto = new Producto();
        producto.setCategoria(new categoria());
        if (idProducto > 0) {
            try {
                Optional<Producto> o = Optional.ofNullable(service.porId(idProducto));
                if (o.isPresent()) {
                    producto = o.get();
                }
            } catch (SQLException e) {
                throw new ServletException(e);
            }
        }

        req.setAttribute("categorias", service.ListarCategoria());
        req.setAttribute("producto", producto);
        getServletContext().getRequestDispatcher("/vistas/admin/ingresarcarrito.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        productoRepositoriojdbcImplement services = new productoRepositoriojdbcImplement(conn);

        String nombre = req.getParameter("nombre");
        String descripcion = req.getParameter("descripcion");
        String idCategoriaStr = req.getParameter("categoria");
        String precioStr = req.getParameter("precio");
        String condicionStr = req.getParameter("condicion");
        String stockStr = req.getParameter("stock");
        String idProductoStr = req.getParameter("id");

        int idCategoria = 0;
        double precio = 0;
        int condicion = 0;
        int stock = 0;
        int idProducto = 0;

        //control de errores
        Map<String, String> errores = new HashMap<>();

        if (idCategoriaStr != null && !idCategoriaStr.isEmpty()) {
            try {
                idCategoria = Integer.parseInt(idCategoriaStr);
            } catch (NumberFormatException e) {
                errores.put("categoria", "El valor de categoría no es válido");
            }
        }

        if (precioStr != null && !precioStr.isEmpty()) {
            try {
                precio = Double.parseDouble(precioStr);
            } catch (NumberFormatException e) {
                errores.put("precio", "El valor de precio no es válido");
            }
        }

        if (condicionStr != null && !condicionStr.isEmpty()) {
            try {
                condicion = Integer.parseInt(condicionStr);
            } catch (NumberFormatException e) {
                errores.put("condicion", "El valor de condición no es válido");
            }
        }

        if (stockStr != null && !stockStr.isEmpty()) {
            try {
                stock = Integer.parseInt(stockStr);
            } catch (NumberFormatException e) {
                errores.put("stock", "El valor de stock no es válido");
            }
        }

        if (idProductoStr != null && !idProductoStr.isEmpty()) {
            try {
                idProducto = Integer.parseInt(idProductoStr);
            } catch (NumberFormatException e) {
                errores.put("id", "El valor de ID no es válido");
            }
        }

        if (nombre == null || nombre.isBlank()) {
            errores.put("nombre", "El campo Nombre es Obligatorio");
        }

        if (precio <= 0) {
            errores.put("precio", "El precio debe ser mayor que cero");
        }
        if (idCategoria == 0) {
            errores.put("categoria", "Seleccione una categoría válida");
        }

        Producto producto = new Producto();
        producto.setIdProducto(idProducto);
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);
        producto.setCondicion(condicion);
        producto.setStock(stock);

        categoria cat = new categoria();
        cat.setIdcategoria(idCategoria);
        producto.setCategoria(cat);

        if (errores.isEmpty()) {
            try {
                services.guardar(producto);
                resp.sendRedirect(req.getContextPath() + "/productosadmin");
            } catch (SQLException e) {
                throw new ServletException(e);
            }
        } else {
            req.setAttribute("categorias", services.ListarCategoria());
            req.setAttribute("errores", errores);
            req.setAttribute("producto", producto);
            getServletContext().getRequestDispatcher("/vistas/admin/ingresarcarrito.jsp").forward(req, resp);
        }
    }
}
