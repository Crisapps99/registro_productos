package org.servlet.login.services;

import jakarta.servlet.http.HttpServletRequest;
import org.servlet.login.models.Usuario;
import org.servlet.login.util.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class LoginServicesImplement implements LoginServices {
    Connection con;
    conexion cn = new conexion();
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public int loginServices(Usuario usuario) {
        String sql = "SELECT * FROM usuario WHERE usuario=? AND password=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getPassword());
            rs = ps.executeQuery();

            if (rs.next()) {
                // Usuario encontrado en la base de datos
                return 1; // Autenticación exitosa
            } else {
                // Usuario no encontrado en la base de datos
                return 0; // Autenticación fallida
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0; // Error durante la ejecución de la consulta
        } finally {
            // Asegúrate de cerrar los recursos de forma adecuada
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Optional<String> getUserName(HttpServletRequest req) {
        // Método opcional no implementado en esta solución específica
        return Optional.empty();
    }
}
