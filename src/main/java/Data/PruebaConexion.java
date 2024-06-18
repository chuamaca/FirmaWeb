/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Data;

import Util.ConexionJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Cesar
 */
public class PruebaConexion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        

        System.out.println("Prueba de Conexion");

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        conn = ConexionJDBC.getConexion();
        System.out.println(conn);
        String sql = "SELECT IdCategoria, Nombre FROM Categoria where Estado=1";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        while (rs.next()) {

            int Id = rs.getInt("IdCategoria");
            String nombre = rs.getString("Nombre");
            System.out.println("Id: " + Id + " nombre: " + nombre);
        }

        
    }

}
