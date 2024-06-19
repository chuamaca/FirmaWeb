/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import Data.DDocumento;
import Modelo.Documento;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author User
 */
@WebServlet("/uploadServlet")
@MultipartConfig(maxFileSize = 16177215)
public class controlfile extends HttpServlet {

    DDocumento dDocumento = new DDocumento();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    private byte[] convertInputStreamToByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[16384];
        while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }
        buffer.flush();
        return buffer.toByteArray();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        int idCategoria = Integer.parseInt(request.getParameter("idcategoria"));
        int idCliente = Integer.parseInt(request.getParameter("idcliente"));
        int estado = 1; // Estado fijo
        int usuarioCrea = 1; // ID fijo del usuario que crea

        Part filePart = request.getPart("file");
        InputStream fileContent = filePart.getInputStream();
        byte[] archivoOrigen = convertInputStreamToByteArray(fileContent);
        
        
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String fileType = Files.probeContentType(Paths.get(fileName));

        if (fileType == null || fileType.isEmpty() || fileName == null || fileName.isEmpty()) {
            request.setAttribute("message", "Todos los campos son obligatorios.");
            request.getRequestDispatcher("formDocumento.jsp").forward(request, response);
            return;
        }

        String filePath = getServletContext().getRealPath("/") + "uploads/" + fileName;
        File uploads = new File(getServletContext().getRealPath("/") + "uploads");
        if (!uploads.exists()) {
            uploads.mkdirs();
        }
        filePart.write(filePath);

    
        Documento obj = new Documento();

        obj.setNombreDocumento(fileName);
        obj.setIdCliente(idCliente);
        obj.setIdCategoria(idCategoria);
        obj.setArchivoOrigen(archivoOrigen);
        int insert = dDocumento.insertDocumento(obj);
        String pag = "principal.jsp";
        request.getRequestDispatcher(pag).forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet para subir archivos";
    }

}
