/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class SQLConexionNoValido {

    //****** NO VALIDO*********
//    public static Connection getConexion() {
//        Connection con = null;
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            String url = "jdbc:sqlserver://firmaelectronica.mssql.somee.com;database=firmaelectronica;"
//                    + "encrypt=true;"
//                    + "trustServerCertificate=True;";
//            String usr = "chuamaca_SQLLogin_1";
//            String psw = "pdwarm2x6t";
//            con = DriverManager.getConnection(url, usr, psw);
//        } catch (ClassNotFoundException ex) {
//            System.out.println("No hay Driver!!");
//        } catch (SQLException ex) {
//            System.out.println("Error con la BD");
//        }
//        return con;
//    }
}
