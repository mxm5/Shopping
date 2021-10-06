package com.shopping;

import com.shopping.services.pages.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

    private static Connection connection;




    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        new Main().run();
    }

    public static Connection getConnection() {
        return connection;
    }
}
