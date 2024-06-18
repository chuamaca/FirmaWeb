/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Cesar
 */
public class ConexionJDBC {

    public static Connection getConexion() {

        String conexionServer = "jdbc:sqlserver://firmaelectronica.mssql.somee.com;"
                + "database=firmaelectronica;"
                + "user=chuamaca_SQLLogin_1;"
                + "password=pdwarm2x6t;"
                + "loginTimeout=30;"
                + "encrypt=true;"
                + "trustServerCertificate=True;";
        
         Connection con=null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(conexionServer);
        } catch (ClassNotFoundException ex) {
            
        } catch (SQLException ex) {

            System.out.println(ex.toString());
            return null;
        }
        
        return con;
    }

    public static void close(ResultSet rs) {

        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

    }

    public static void close(Statement smtn) {
        try {
            smtn.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

    }

    public static void close(PreparedStatement smtn) {
        try {
            smtn.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

    }

    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

    }
}
