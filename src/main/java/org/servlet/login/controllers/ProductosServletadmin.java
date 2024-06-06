package org.servlet.login.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.servlet.login.models.Producto;
import org.servlet.login.services.LoginServices;
import org.servlet.login.services.LoginServicesImplement;
import org.servlet.login.services.ProductoService;
import org.servlet.login.services.productoServicejdbcImplement;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;
@WebServlet({"/ProductoServletadmin","/productosadmin"})
public class ProductosServletadmin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        Connection conn= (Connection) req.getAttribute("conn");
        ProductoService service = new productoServicejdbcImplement(conn);

        //aqui enlisto lso productsos guradadis
        List<Producto> productos=service.Listar();
        //traemos el nombre del usuariomediante LoginsErvices
        LoginServices auth= new LoginServicesImplement();
        //con esto traemos los datos del usuario validando que exista
        Optional<String> usernameOptional=auth.getUserName(req);
        //se agrega uun atributo al objeto
        req.setAttribute("productos", productos);
        //si el atributo esta o no rpesente
        req.setAttribute("usernameOptional", usernameOptional);

        req.getRequestDispatcher("vistas/admin/productosadmin.jsp").forward(req,resp);


    }
}
