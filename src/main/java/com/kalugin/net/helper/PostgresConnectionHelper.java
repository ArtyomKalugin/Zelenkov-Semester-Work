package com.kalugin.net.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class PostgresConnectionHelper {
    private static Connection connection;
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/semesterWork";
    private static final String USER = "artemkalugin";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException | SQLException e) {
                throw new IllegalArgumentException(e);
            }
        }

        return connection;
    }
}