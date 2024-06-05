/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Modelo.Documento;
import Util.ConexionJDBC;
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
import Modelo.Cliente;
import Modelo.Categoria;

/**
 *
 * @author Cesar
 */
public class DDocumento {

    private static final String SQL_SELECT_BY_DOCUMENTO = "SELECT IdDocumento, TipoDocumento, NombreDocumento, ArchivoOrigen FROM FIRMAFACIL.dbo.Documento where IdDocumento =? and Estado=1";

    private static final String SQL_INSERT = "INSERT INTO FIRMAFACIL.dbo.Documento( IdCliente, IdCategoria, ArchivoOrigen, TipoDocumento, NombreDocumento, Estado, UsuarioCrea, FechaCrea)\n"
            + " VALUES( ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_SELECT_ID = "SELECT  ArchivoOrigen FROM FIRMAFACIL.dbo.Documento where IdDocumento =? and Estado=1";
    

    public int insertDocumento(Documento documento) { //, Cliente cli,Categoria cat
        System.out.println("InsertDocumento");

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
            stmt = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

            stmt.setInt(1, documento.getIdCliente());
            stmt.setInt(2, documento.getIdCategoria());
            stmt.setBytes(3, documento.getArchivoOrigen());
            stmt.setString(4, documento.getTipoDocumento());
            stmt.setString(5, documento.getNombreDocumento());
            stmt.setInt(6, 1);
            stmt.setInt(7, 1);
            stmt.setString(8, fechaCarga);

            System.out.println("ejecutando query:" + SQL_INSERT);
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

    public List<Documento> SelectByIdDocumento(Documento objDocumento) {

        System.out.println("SelectByIdDocumento: " + objDocumento);

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Documento mDocumento = null;
        List<Documento> listDocumento = new ArrayList<>();

        try {
            conn = ConexionJDBC.getConexion();
            stmt = conn.prepareStatement(SQL_SELECT_BY_DOCUMENTO);
            stmt.setInt(1, objDocumento.getIdDocumento());
            rs = stmt.executeQuery();
            System.out.println("stmt.executeQuery(): ");
            while (rs.next()) {

                int IdDocumento = rs.getInt("IdDocumento");
                String TipoDocumento = rs.getString("TipoDocumento");
                String NombreDocumento = rs.getString("NombreDocumento");
                byte[] archivopdf = rs.getBytes("ArchivoOrigen");

                mDocumento = new Documento();
                mDocumento.setIdDocumento(IdDocumento);
                mDocumento.setTipoDocumento(TipoDocumento);
                mDocumento.setNombreDocumento(NombreDocumento);
                mDocumento.setArchivoOrigen(archivopdf);

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

    public Documento SelectByIdDocumentoObject(Documento objDocumento) {

        System.out.println("SelectByNroExpediente: " + objDocumento);

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Documento mDocumento = null;

        try {
            conn = ConexionJDBC.getConexion();
            stmt = conn.prepareStatement(SQL_SELECT_BY_DOCUMENTO);
            stmt.setInt(1, objDocumento.getIdDocumento());
            rs = stmt.executeQuery();
            System.out.println("stmt.executeQuery(): ");
            while (rs.next()) {

                int IdDocumento = rs.getInt("IdDocumento");
                String TipoDocumento = rs.getString("TipoDocumento");
                String NombreDocumento = rs.getString("NombreDocumento");
                byte[] archivopdf = rs.getBytes("ArchivoOrigen");

                mDocumento = new Documento();
                mDocumento.setIdDocumento(IdDocumento);
                mDocumento.setTipoDocumento(TipoDocumento);
                mDocumento.setNombreDocumento(NombreDocumento);
                mDocumento.setArchivoOrigen(archivopdf);

            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConexionJDBC.close(rs);
            ConexionJDBC.close(stmt);
            ConexionJDBC.close(conn);
        }

        return mDocumento;
    }

    public void ejecutar_archivoPDF(int id) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        byte[] b = null;

        try {

            conn = ConexionJDBC.getConexion();
            stmt = conn.prepareStatement(SQL_SELECT_ID);
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

            OutputStream out = new FileOutputStream("new.pdf");
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
