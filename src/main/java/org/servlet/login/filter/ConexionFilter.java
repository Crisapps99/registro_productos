package org.servlet.login.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.servlet.login.util.conexion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import org.servlet.login.services.ServicejdbcException;
//webfilter con eso quiere decir que la aplicacion esta disponible par toda la aplicacion
@WebFilter("/*")
public class ConexionFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        //genero la conexion a mi base de datos
        try(Connection conn = conexion.getConnection()){
            if(conn.getAutoCommit()){
                //retornamos la conexion
                conn.setAutoCommit(false);
            }
            try {
                request.setAttribute("conn", conn);
                chain.doFilter(request,response);
                conn.commit();
            } catch (SQLException | ServicejdbcException e){
                //puntos de salvacion o restauracion
                conn.rollback();
                ((HttpServletResponse)response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
                e.printStackTrace();
            }
        }catch (SQLException throwables){

        }
    }

}
