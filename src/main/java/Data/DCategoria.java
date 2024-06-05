package Data;

import Modelo.Categoria;
import Util.ConexionJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DCategoria {

    // private static final String SQL_SELECT = "SELECT IdCategoria, Nombre, Descripcion FROM FIRMAFACIL.dbo.Categoria where Estado=1";
    public List<Categoria> ListCategoria() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Categoria> categorias = new ArrayList<>();
        Categoria objCat = null;

        try {
            conn = ConexionJDBC.getConexion();
            String sql = "SELECT IdCategoria, Nombre FROM FIRMAFACIL.dbo.Categoria where Estado=1";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                objCat = new Categoria();
                objCat.setIdCategoria(rs.getInt("IdCategoria"));
                objCat.setNombre(rs.getString("Nombre"));
                categorias.add(objCat);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConexionJDBC.close(rs);
            ConexionJDBC.close(stmt);
            ConexionJDBC.close(conn);
        }

        return categorias;
    }

}
