/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import Data.DServicio;
import Modelo.ServicioDocumento;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataConsolidateFunction;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author User
 */
@WebServlet("/downloadServlet")
public class downloadfile extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

        List<ServicioDocumento> listaServicioDocumento = dServicio.SelectDocumentoByCliente(1);

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Listado De Documentos");

        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        // Definir una fuente en negrita para el encabezado
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerStyle.setFont(headerFont);
        
        // Crear el encabezado
        String[] header = {"IdDocumento", "Empresa", "Tipo Firma", "Archivo", "Estado Firma", "Fecha Firma", "Fecha Vigencia", "Usuario Firma"};
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < header.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(header[i]);
            cell.setCellStyle(headerStyle);
        }
        
        int rowNum = 1;
        String estadoFirma="";
        for (ServicioDocumento x : listaServicioDocumento) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(x.getIdDocumento());
            row.createCell(1).setCellValue(x.getEmpresa());
            row.createCell(2).setCellValue(x.getCategoria());
            row.createCell(3).setCellValue("Archivo");
            if (x.getIdServicio()==0) {
                estadoFirma="Pendiente";
            }
             if (x.getIdServicio()>0) {
                estadoFirma="Firmado";
            }
            row.createCell(4).setCellValue(estadoFirma);
            row.createCell(5).setCellValue(x.getFechaServicio());
            row.createCell(6).setCellValue(x.getFechaVigencia());
            row.createCell(7).setCellValue(x.getUsuarioFirma());
        }

        // Ajustar el tamaño de las columnas
        for (int i = 0; i < header.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Configurar la respuesta HTTP
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=ListadoDocumentos.xlsx");

        // Escribir el archivo Excel en la respuesta
        workbook.write(response.getOutputStream());
        workbook.close();

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
