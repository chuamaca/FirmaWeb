package Data;

import Modelo.Cliente;
import Util.ConexionJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DCliente {

    public List<Cliente> ListCliente() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Cliente> clientes = new ArrayList<>();
        Cliente objCliente = null;

        try {
            conn = ConexionJDBC.getConexion();
            String sql = "SELECT IdCliente, Nombre FROM FIRMAFACIL.dbo.Cliente where Estado=1";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                objCliente = new Cliente();

                objCliente.setIdCliente(rs.getInt("IdCliente"));
                objCliente.setNombre(rs.getString("Nombre"));
                clientes.add(objCliente);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConexionJDBC.close(rs);
            ConexionJDBC.close(stmt);
            ConexionJDBC.close(conn);
        }

        return clientes;
    }

    public List<String> ListClienteString() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<String> clientes = new ArrayList<>();

        try {
            conn = ConexionJDBC.getConexion();
            String sql = "SELECT Nombre FROM FIRMAFACIL.dbo.Cliente where Estado=1";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String cliente = rs.getString("Nombre");
                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConexionJDBC.close(rs);
            ConexionJDBC.close(stmt);
            ConexionJDBC.close(conn);
        }

        return clientes;
    }

}
