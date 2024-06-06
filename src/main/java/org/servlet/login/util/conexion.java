package org.servlet.login.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.Class.forName;

public class conexion {
    //creamos un metodo para obtener la conexion
    //mediante el pool de conexiones
    // guardar en url la base de datos mediante el link de puerto 3306
    private static String url= "jdbc:mysql://localhost:3306/mydb";
    private static String username="root";
    private static String password="";
    public static Connection getConnection() throws SQLException {
        System.out.println("Intentando conectar a la base de datos...");
        Connection connection = DriverManager.getConnection(url, username, password);
        if (connection != null) {
            System.out.println("Conexión establecida correctamente.");
        } else {
            System.out.println("No se pudo establecer conexión.");
        }
        return connection;
    }
}
