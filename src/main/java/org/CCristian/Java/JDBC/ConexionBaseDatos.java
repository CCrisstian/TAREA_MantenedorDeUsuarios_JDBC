package org.CCristian.Java.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {

    private static String url = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=America/Argentina/Buenos_Aires";
    private static String user_name = "root";
    private static String password = "sasa";

    private static Connection connection;

    public static Connection getInstance() throws SQLException {
        return DriverManager.getConnection(url, user_name, password);
    }
}
