/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Modelo.Cliente;
import Modelo.Documento;
import Modelo.Servicio;
import Modelo.ServicioDocumento;
import Util.ConexionJDBC;
import Util.SQLConexionNoValido;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cesar
 */
public class DServicio {

    private String SQL_SELECT_BY_CLIENTE = "select d.IdDocumento, c.Nombre as 'Empresa', c2.Nombre as 'Categoria' , d.ArchivoOrigen, COALESCE(s.IdServicio , 0) as 'Firmado', \n"
            + "s.FechaServicio ,s.FechaVigencia ,u.NombreUsuario \n"
            + "from Documento d left join Servicio s \n"
            + "on d.IdDocumento =s.IdDocumento \n"
            + "inner join Cliente c on d.IdCliente =c.IdCliente \n"
            + "inner join Categoria c2 on c2.IdCategoria =d.IdCategoria \n"
            + "left join Usuario u on u.IdUsuario =s.IdUsuario\n";
    // + "where c.IdCliente =?";

    private static final String SQL_SELECT_SERVICIO_ID = "SELECT ContenidoDocumento  FROM FIRMAFACIL.dbo.Servicio where IdServicio =? and Estado =1";

    private static final String SQL_SERVICIO_SELECT_BY_DOCUMENTO = "SELECT IdServicio , TipoDocumento , NombreDocumento , ContenidoDocumento FROM FIRMAFACIL.dbo.Servicio WHERE IdServicio =? AND Estado =1";

    private static final String SQL_SERVICIO_INSERT = "INSERT INTO FIRMAFACIL.dbo.Servicio ( IdUsuario, IdDocumento, ContenidoDocumento, TipoDocumento, NombreDocumento, Lugar, FechaServicio, FechaVigencia, Estado, UsuarioCrea, FechaCrea) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public List<ServicioDocumento> SelectDocumentoByCliente(int IdCliente) {

        System.out.println("SelectByNroExpediente: " + IdCliente);

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ServicioDocumento mDocumento = null;
        List<ServicioDocumento> listDocumento = new ArrayList<>();

        try {
            conn = ConexionJDBC.getConexion();
            System.out.println(conn);
            stmt = conn.prepareStatement(SQL_SELECT_BY_CLIENTE);
//            stmt.setInt(1, IdCliente);
            rs = stmt.executeQuery();
            System.out.println("stmt.executeQuery(): ");
            while (rs.next()) {

                int IdDocumento = rs.getInt("IdDocumento");
                String Empresa = rs.getString("Empresa");
                String Categoria = rs.getString("Categoria");
                byte[] archivopdf = rs.getBytes("ArchivoOrigen");
                int Firmado = rs.getInt("Firmado");
                java.sql.Date FechaServicio = rs.getDate("FechaServicio");
                java.sql.Date FechaVigencia = rs.getDate("FechaVigencia");
                String NombreUsuario = rs.getString("NombreUsuario");

                mDocumento = new ServicioDocumento();
                mDocumento.setIdDocumento(IdDocumento);
                mDocumento.setEmpresa(Empresa);
                mDocumento.setCategoria(Categoria);
                mDocumento.setArchivoOrigen(archivopdf);
                mDocumento.setIdServicio(Firmado);
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

    public List<Servicio> SelectServicioByIdServicio(Servicio objServicio) {

        System.out.println("SelectServicioByIdDocumento: " + objServicio);

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Servicio mServicio = null;
        List<Servicio> listServicio = new ArrayList<>();

        try {
            conn = ConexionJDBC.getConexion();
            stmt = conn.prepareStatement(SQL_SERVICIO_SELECT_BY_DOCUMENTO);
            stmt.setInt(1, objServicio.getIdServicio());
            rs = stmt.executeQuery();
            System.out.println("stmt.executeQuery(): ");
            while (rs.next()) {

                int IdServicio = rs.getInt("IdServicio");
                String TipoDocumento = rs.getString("TipoDocumento");
                String NombreDocumento = rs.getString("NombreDocumento");
                byte[] archivopdf = rs.getBytes("ContenidoDocumento");

                mServicio = new Servicio();
                mServicio.setIdServicio(IdServicio);
                mServicio.setTipoDocumento(TipoDocumento);
                mServicio.setNombreDocumento(NombreDocumento);
                mServicio.setContenidoDocumento(archivopdf);

                listServicio.add(mServicio);
                System.out.println("listServicio.add(mServicio): " + listServicio.toString());
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConexionJDBC.close(rs);
            ConexionJDBC.close(stmt);
            ConexionJDBC.close(conn);
        }

        return listServicio;
    }

    public int insertServicio(Servicio servicio) {
        System.out.println("insertServicio");

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        ResultSet rs = null;
        int generatedKey = 0;

        java.util.Date fechaActual = new java.util.Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String fechaCarga = formato.format(fechaActual);

        try {
            conn = ConexionJDBC.getConexion();
            stmt = conn.prepareStatement(SQL_SERVICIO_INSERT, Statement.RETURN_GENERATED_KEYS);

            /*
            INSERT INTO FIRMAFACIL.dbo.Servicio 
            ( IdUsuario, IdDocumento, ContenidoDocumento, TipoDocumento, NombreDocumento, Lugar, FechaServicio,
            FechaVigencia, Estado, UsuarioCrea, FechaCrea) 
            VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
             */
            stmt.setInt(1, 1);
            stmt.setInt(2, servicio.getIdDocumento());
            stmt.setBytes(3, servicio.getContenidoDocumento());
            stmt.setString(4, servicio.getTipoDocumento());
            stmt.setString(5, servicio.getNombreDocumento());
            stmt.setString(6, "Lima");
            stmt.setString(7, fechaCarga);
            stmt.setString(8, fechaCarga);
            stmt.setInt(9, 1);
            stmt.setInt(10, 1);
            stmt.setString(11, fechaCarga);

            System.out.println("ejecutando query:" + SQL_SERVICIO_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);

            if (rows > 0) {
                rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    generatedKey = rs.getInt(1);
                    System.out.println("Clave primaria generada: " + generatedKey);
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            //  ConexionJDBC.close(rs);
            ConexionJDBC.close(stmt);
            ConexionJDBC.close(conn);
        }

        return generatedKey;
    }

    public void ejecutar_archivoPDFServicio(int id) {
        System.out.println("Abriendo ejecutar_archivoPDFServicio: " + id);
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        byte[] b = null;

        try {

            conn = ConexionJDBC.getConexion();
            stmt = conn.prepareStatement(SQL_SELECT_SERVICIO_ID);
            stmt.setInt(1, id);
            System.out.println("ejecutar_archivoPDF: " + id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                b = rs.getBytes(1);
            }
            InputStream bos = new ByteArrayInputStream(b);

            int tamanoInput = bos.available();
            byte[] datosPDF = new byte[tamanoInput];
            bos.read(datosPDF, 0, tamanoInput);

            OutputStream out = new FileOutputStream("newDocumentoFirmado.pdf");
            out.write(datosPDF);

            //abrir archivo
            out.close();
            bos.close();

        } catch (IOException | NumberFormatException | SQLException ex) {
            System.out.println("Error al abrir archivo PDF " + ex.getMessage());
        } finally {
            ConexionJDBC.close(rs);
            ConexionJDBC.close(stmt);
            ConexionJDBC.close(conn);
        }
    }

}
