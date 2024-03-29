package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBCon {
    private static String url = "jdbc:sqlserver://";
    private static String serverName = "LAPTOP-2V0L4U98";
    private static String portNumber = "1433";
    private static String databaseName = "QLNV";
    private static String username = "sa";
    private static String password = "1234567890";

    public static String getUrl() {
        return url + serverName + ":" + portNumber + "; databaseName=" + databaseName + "; user=" + username + "; password=" + password;
    }

    public static Connection getConnection() {
        Connection con = null;

        try {
        	con = DriverManager.getConnection(getUrl());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
    
 
    public static void main(String[] args) {
    	Connection connection = DBCon.getConnection();
    	System.out.println(connection);
    }
}

