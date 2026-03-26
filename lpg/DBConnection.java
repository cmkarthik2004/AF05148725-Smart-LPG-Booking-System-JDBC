package com.karthik.lpg;
import java.sql.*;

public class DBConnection {
    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/lpg_smart_db",
                "root",
                "9481566730"
            );
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
}