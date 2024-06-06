package org.servlet.login.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.servlet.login.models.Producto;
import org.servlet.login.repositorio.productoRepositoriojdbcImplement;
import org.servlet.login.services.LoginServices;
import org.servlet.login.services.LoginServicesImplement;

import java.util.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/actualizar")
public class ActualizarP extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtener el ID del producto a editar desde los parámetros de la URL
        String idProductoStr = req.getParameter("id");

        if (idProductoStr != null && !idProductoStr.isEmpty()) {
            try {
                // Convertir el ID del producto a entero
                int idProducto = Integer.parseInt(idProductoStr);

                // Obtener el producto desde el repositorio
                Connection conn = (Connection) req.getAttribute("conn");
                productoRepositoriojdbcImplement repository = new productoRepositoriojdbcImplement(conn);
                Producto producto = repository.porId(idProducto);

                // Establecer el producto como atributo de solicitud para que esté disponible en el JSP
                req.setAttribute("producto", producto);

                // Redirigir a la página de edición (editar.jsp)
                req.getRequestDispatcher("/vistas/admin/editarP.jsp").forward(req, resp);

            } catch (NumberFormatException | SQLException e) {
                // Manejar errores de conversión de número o SQL
                e.printStackTrace(); // Considera utilizar un logger para un manejo más adecuado de registros
                resp.sendRedirect(req.getContextPath() + "/error.html");
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/error.html");
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        productoRepositoriojdbcImplement repository = new productoRepositoriojdbcImplement(conn);

        // Obtener los parámetros del formulario
        String idProductoStr = req.getParameter("id");
        String codigoStr = req.getParameter("codigo");
        String nombre = req.getParameter("nombre");
        String stockStr = req.getParameter("stock");
        String descripcion = req.getParameter("descripcion");
        String imagen = req.getParameter("imagen");
        String condicionStr = req.getParameter("condicion");
        String precioStr = req.getParameter("precio");


            // Convertir los parámetros a tipos numéricos
            int idProducto = Integer.parseInt(idProductoStr);
            int codigo = Integer.parseInt(codigoStr);
            int stock = Integer.parseInt(stockStr);
            int condicion = Integer.parseInt(condicionStr);
            double precio = Double.parseDouble(precioStr);

            // Crear un objeto Producto con los datos recibidos
            Producto producto = new Producto();
            producto.setIdProducto(idProducto);
            producto.setCodigo(codigo);
            producto.setNombre(nombre);
            producto.setStock(stock);
            producto.setDescripcion(descripcion);
            producto.setImagen(imagen);
            producto.setCondicion(condicion);
            producto.setPrecio(precio);

        // Redirigir al usuario a la página de administración de productos
        resp.sendRedirect(req.getContextPath() + "/productosadmin");
        try {
            repository.actualizar(producto);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }
}
