package org.servlet.login.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.servlet.login.models.Producto;
import org.servlet.login.models.Usuario;
import org.servlet.login.services.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@WebServlet({"/login", "/Servletlogin"})
public class Servlet_login extends HttpServlet {

    private final LoginServices loginServices = new LoginServicesImplement();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");

        if ("Ingresar".equals(accion)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            Usuario usuario = new Usuario();
            usuario.setUsuario(username);
            usuario.setPassword(password);

            int resultadoLogin = loginServices.loginServices(usuario);

            // Después de autenticar al usuario con éxito
            if (resultadoLogin == 1) {
                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuario.getUsuario());

                String rol = obtenerRol(usuario, request);
                if ("admin".equals(rol)) {
                    // Redirigir a admin.jsp para administradores
                    response.sendRedirect(request.getContextPath() + "/vistas/admin/admin.jsp");
                } else if ("user".equals(rol)) {
                    // Redirigir a user.jsp para usuarios normales
                    response.sendRedirect(request.getContextPath() + "/vistas/user/user.jsp");
                } else {
                    // Si el rol no es reconocido, redirigir a una página de error o login
                    response.sendRedirect(request.getContextPath() + "/login.jsp");
                }
                return; // Importante para evitar redirecciones adicionales
            }
        }

        // Si no se especifica 'accion' o la autenticación falla, redirigir a login.jsp
        response.sendRedirect(request.getContextPath() + "/login.jsp");

    }

    // Método para obtener el rol del usuario desde la base de datos
    private String obtenerRol(Usuario usuario, HttpServletRequest request) {
        String rol = "user"; // Rol por defecto

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = (Connection) request.getAttribute("conn");

            // Consulta SQL para obtener el rol del usuario por nombre de usuario
            String sql = "SELECT rol FROM usuario WHERE usuario = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, usuario.getUsuario());
            rs = pstmt.executeQuery();

            if (rs.next()) {
                rol = rs.getString("rol");
            }
        } catch (SQLException e) {
            // Manejo de excepciones
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return rol;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
