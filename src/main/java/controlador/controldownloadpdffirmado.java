/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import Data.DServicio;
import Modelo.Servicio;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet("/downloadPdfFirmadoServlet")
public class controldownloadpdffirmado extends HttpServlet {

    DServicio dServicio = new DServicio();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int IdServicio = Integer.parseInt(request.getParameter("IdServicio"));

        Servicio objServicio = new Servicio();
        objServicio.setIdServicio(IdServicio);
        List<Servicio> servicioList = dServicio.SelectServicioByIdServicio(objServicio);

        if (!servicioList.isEmpty()) {
            Servicio dataServicio = servicioList.get(0); // Asumimos que solo hay un resultado
            byte[] archivopdf = dataServicio.getContenidoDocumento();
            String filename = dataServicio.getNombreDocumento();

            // Configurar la respuesta HTTP
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=" + filename + "_" + IdServicio + ".pdf");
            response.setContentLength(archivopdf.length);

            // Escribir el archivo PDF en la respuesta
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(archivopdf);
            outputStream.flush();
            outputStream.close();


        } else {
            // Manejar el caso donde no se encontró el servicio
            response.setContentType("text/html");
            response.getWriter().write("No se encontró el servicio con el ID especificado.");
        }

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
        return "Short description";
    }// </editor-fold>

}
