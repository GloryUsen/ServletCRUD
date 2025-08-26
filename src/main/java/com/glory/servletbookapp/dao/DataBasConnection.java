package com.glory.servletbookapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;


public class DataBasConnection {
    public static Connection getPostgresConnection() {
        Connection connect = null;
        try {
            Class.forName("org.postgresql.Driver");
            connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ServletBookApp",
                    "postgres", "Crunches02");

        } catch (Exception bookApp) {
            System.out.println(bookApp);
        }

        return connect;
    }

    }
