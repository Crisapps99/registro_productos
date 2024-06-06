package org.servlet.login.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.servlet.login.models.Producto;
import org.servlet.login.repositorio.productoRepositoriojdbcImplement;
import org.servlet.login.repositorio.repositorio;
import org.servlet.login.services.ProductoService;
import org.servlet.login.services.productoServicejdbcImplement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@WebServlet("/eliminarP")
public class EliminarP extends HttpServlet {
    private static final long serialVersionUID = 1L;

    //sobreescribimos el metodo
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //obtengo el parametro iD del request y le convierto a entero
        int id=Integer.parseInt(req.getParameter("id"));

        //devuelve el contexto sel servlet actual  y devuelve el valor un atributo por su nombre y se intenta llabar un atributo
        // de tipo DBConnection que eria un instancia valida de java,sql,Connection de tipo coneccion
        Connection conn = (Connection) req.getAttribute("conn");
        //declaro una variable llamada repo creo una nueva instancia de tipo productoRe obteniendo la conexion a la base de datos
        repositorio<Producto> respo= new productoRepositoriojdbcImplement(conn);

        try{
            //eliminito el producto utilizando el repositorio ue tiene el metodo eliminar
            respo.eliminar(id);
            // Obtener la lista actualizada de productos después de la eliminación
            List<Producto> productos = respo.listar();
            // Establecer la lista de productos como un atributo en el request
            req.setAttribute("productos", productos);
            //si el producto se elimina se dirije a la pagina de productos
            req.getRequestDispatcher("vistas/admin/productosadmin.jsp").forward(req,resp);
        }//en caso de que ocurra una excepcion sql intenta elimianr el producto
        //captura la exepcion para manejarla adecuadamente
        catch (SQLException e){
            throw  new ServletException(e);
        }

    }
}
