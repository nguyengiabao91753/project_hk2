package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBCon {
    private static String url = "jdbc:sqlserver://";
    private static String serverName = "MSI";
    private static String portNumber = "1433";
    private static String databaseName = "QLNV";
    private static String username = "sa";
    private static String password = "1234567890";

    public static String getUrl() {
        return url + serverName + ":" + portNumber + "; databaseName=" + databaseName + "; user=" + username + "; password=" + password;
    }

    public static Connection getConnection() {
        Connection c = null;

        try {
            c = DriverManager.getConnection(getUrl());
            System.out.println("Connected successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return c;
    }
    
 
    public static void main(String[] args) {
    	Connection connection = DBCon.getConnection();
    	System.out.println(connection);
    }
}

