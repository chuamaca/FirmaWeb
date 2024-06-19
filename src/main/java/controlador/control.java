/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import Data.DDocumento;
import Data.DServicio;
import Modelo.Documento;
import Modelo.Servicio;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Cesar
 */
public class control extends HttpServlet {

    DServicio dServicio = new DServicio();
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int opc = Integer.parseInt(request.getParameter("opc"));

        if (opc == 1) {
            ListaDocumentosCargadosYFirmados(request, response);
        }

        if (opc == 10) {
            ListaDocumentoByIdDocumento(request, response);
        }

        if (opc == 11) {
            FirmarDocumento(request, response);
        }

    }

    //SelectDocumentoByCliente
    protected void ListaDocumentosCargadosYFirmados(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        String cod = request.getParameter("id"); List<ServicioDocumento> serviciodocumentoList = servicio.SelectDocumentoByCliente(1);
        request.setAttribute("dato", dServicio.SelectDocumentoByCliente(1));
        String pag = "formListaDocumento.jsp";
        request.getRequestDispatcher(pag).forward(request, response);

    }

    protected void ListaDocumentoByIdDocumento(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idDocumento = Integer.parseInt(request.getParameter("IdDocumento"));
        Documento doc = new Documento();
        doc.setIdDocumento(idDocumento);
        request.setAttribute("dato", dDocumento.SelectByIdDocumento(doc));
        String pag = "formFirma.jsp";
        request.getRequestDispatcher(pag).forward(request, response);

    }

    protected void FirmarDocumento(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idDocumento = Integer.parseInt(request.getParameter("IdDocumento"));
        Documento documento = new Documento();
        documento.setIdDocumento(idDocumento);

        Gson gson = new Gson();
        Documento documentoParaFirmar = new Documento();
        documentoParaFirmar = dDocumento.SelectByIdDocumentoObject(documento);

        try {

            Informacion data = new Informacion();
            data.setNombre(documentoParaFirmar.getNombreDocumento());
            String base64String = Base64.getEncoder().encodeToString(documentoParaFirmar.getArchivoOrigen());
            data.setData(base64String);

            String json = gson.toJson(data);
            System.out.println("json: " + json);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/pki/firma"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            System.out.println("request: " + httpRequest);
            HttpResponse<String> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            ApiResponse apiResponse = gson.fromJson(httpResponse.body(), ApiResponse.class);

            System.out.println("apiResponse:" + apiResponse.data);
            if ("OK".equals(apiResponse.estado)) {

                byte[] pdfData = Base64.getDecoder().decode(apiResponse.data);

//                Path path = Path.of("D:\\ArchivoFirmado_" + documentoParaFirmar.getIdDocumento() + ".pdf");
//                System.out.println("Patch::  " + path);
//                Files.write(path, pdfData);
                if (pdfData != null) {
                    System.out.println("archivoDestinoPdf Null:   " + pdfData);
                    Servicio objServicio = new Servicio();

                    objServicio.setIdDocumento(documentoParaFirmar.getIdDocumento());
                    objServicio.setContenidoDocumento(pdfData);
                    objServicio.setTipoDocumento("PDF");
                    objServicio.setNombreDocumento(documentoParaFirmar.getNombreDocumento());
//                    objServicio.setLugar(txtLugar.getText());

                    DServicio dServicio = new DServicio();
                    int inserkey = dServicio.insertServicio(objServicio);

                    if (inserkey > 0) {
                        System.out.println("Servicio Insertado para Ver: " + inserkey);

                    }
                }

                // 7. Guardar el PDF
            } else {
                System.out.println("Estado no es OK, no se guardará el archivo.");
            }

        } catch (IOException ex) {

        } catch (InterruptedException ex) {

        }

        String pag = "principal.jsp";
        request.getRequestDispatcher(pag).forward(request, response);

    }

    private static class ApiResponse {

        String estado;
        String data;
    }

    public class Informacion {

        private String data;
        private String nombre;

        public Informacion(String data, String nombre) {
            this.data = data;
            this.nombre = nombre;
        }

        public Informacion() {
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
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
