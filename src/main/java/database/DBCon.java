package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBCon {
    private static String url = "jdbc:sqlserver://";
    private static String serverName = "DESKTOP-V4SS9V4\\SQLEXPRESS";
    private static String portNumber = "1433";
    private static String databaseName = "QLNV";
    private static String username = "sa";
    private static String password = "123456789";

    public static String getUrl() {
        return url + serverName + ":" + portNumber + "; databaseName=" + databaseName + "; user=" + username + "; password=" + password;
    }

    public static Connection getConnection() {
        Connection con = null;

        try {
        	con = DriverManager.getConnection(getUrl());
            System.out.println("Connected successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
    
 
//    public static void main(String[] args) {
//    	Connection connection = DBCon.getConnection();
//    	System.out.println(connection);
//    }
}

