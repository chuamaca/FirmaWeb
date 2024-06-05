/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Modelo.Cliente;
import Modelo.Documento;
import Modelo.ServicioDocumento;
import Util.ConexionJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cesar
 */
public class DDocumentoFirmado {

    private String SQL_SELECT_BY_DOCFIRMADO = "select d.IdDocumento, d.NombreDocumento, c.Nombre as 'Empresa', ca.Nombre as 'Categoria' , d.ArchivoOrigen as 'Ruta' ,\n"
            + "s.FechaServicio as 'FechaFirma' ,s.FechaVigencia ,u.NombreUsuario \n"
            + "from Documento d inner join Servicio s \n"
            + "on d.IdDocumento =s.IdDocumento \n"
            + "inner join Cliente c on d.IdCliente =c.IdCliente\n"
            + "inner join Categoria ca on ca.IdCategoria =d.IdCategoria \n"
            + "left join Usuario u on u.IdUsuario =s.IdUsuario\n"
            + "where c.IdCliente = ?";

    public List<ServicioDocumento> SelectDocumentoByCliente(int IdCliente) {

        System.out.println("SelectByNroExpediente: " + IdCliente);

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ServicioDocumento mDocumento = null;
        List<ServicioDocumento> listDocumento = new ArrayList<>();

        try {
            conn = ConexionJDBC.getConexion();
            stmt = conn.prepareStatement(SQL_SELECT_BY_DOCFIRMADO);
            stmt.setInt(1, IdCliente);
            rs = stmt.executeQuery();
            System.out.println("stmt.executeQuery(): ");
            while (rs.next()) {

                int IdDocumento = rs.getInt("IdDocumento");
                String Nombre = rs.getString("NombreDocumento");
                String Empresa = rs.getString("Empresa");
                String Categoria = rs.getString("Categoria");
                byte[] archivopdf = rs.getBytes("Ruta");
                java.sql.Date FechaServicio = rs.getDate("FechaFirma");
                java.sql.Date FechaVigencia = rs.getDate("FechaVigencia");
                String NombreUsuario = rs.getString("NombreUsuario");

                mDocumento = new ServicioDocumento();
                mDocumento.setIdDocumento(IdDocumento);
                mDocumento.setNombreDocumento(Nombre);
                mDocumento.setEmpresa(Empresa);
                mDocumento.setCategoria(Categoria);
                mDocumento.setArchivoOrigen(archivopdf);
                mDocumento.setFechaServicio(FechaServicio);
                mDocumento.setFechaVigencia(FechaVigencia);
                mDocumento.setUsuarioFirma(NombreUsuario);

                listDocumento.add(mDocumento);
                System.out.println("listDocumento.add(mDocumento): " + listDocumento.toString());
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConexionJDBC.close(rs);
            ConexionJDBC.close(stmt);
            ConexionJDBC.close(conn);
        }

        return listDocumento;
    }

    public int obtenerCodigoClientePorNombre(String nombreCliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int codigoCliente = -1; // Valor por defecto en caso de que no se encuentre el cliente

        try {
            conn = ConexionJDBC.getConexion();
            stmt = conn.prepareStatement("SELECT IdCliente FROM Cliente WHERE Nombre = ?");
            stmt.setString(1, nombreCliente);
            rs = stmt.executeQuery();

            if (rs.next()) {
                codigoCliente = rs.getInt("IdCliente");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConexionJDBC.close(rs);
            ConexionJDBC.close(stmt);
            ConexionJDBC.close(conn);
        }

        return codigoCliente;
    }
}
