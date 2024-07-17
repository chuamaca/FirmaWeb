<%@page import="Modelo.ServicioDocumento, java.util.List, java.util.ArrayList"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<h2>Lista de Documentos</h2>

<%
    List<ServicioDocumento> listaDocumentos = (ArrayList<ServicioDocumento>) request.getAttribute("dato");
    String estadoFirma = "";
    String fechaServicio = "";
    Boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
%>

<div class="container">
    <div class="row">
        <div class="col-md-12 text-right">
            <div class="contacts-list user-panel">
                <form action="downloadServlet" method="post" enctype="multipart/form-data">
                    <button type="submit" class="btn btn-primary">
                        <i class="fas fa-download"></i> Descargar Informe
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>

<table class="table table-striped mt-4">
    <thead>
        <tr>
            <th>Empresa</th>
            <th>Tipo Firma</th>
            <th>Estado</th>
            <th>Fecha Servicio</th>
            <th>Acciones</th>
        </tr>
    </thead>
    <tbody>
    <%
        for (ServicioDocumento x : listaDocumentos) {
            if (x.getIdServicio() == 0) {
                estadoFirma = "Sin Firmado";
                fechaServicio = "";
            } else {
                estadoFirma = "Firmado";
                fechaServicio = x.getFechaServicio().toString();
            }
    %>
        <tr>
            <td><%= x.getEmpresa() %></td>
            <td><%= x.getCategoria() %></td>
            <td><%= estadoFirma %></td>
            <td><%= fechaServicio %></td>
            <td>
                <a href="downloadPdfServlet?IdDocumento=<%= x.getIdDocumento()%>" class="btn btn-primary">Ver Documento</a>
                <% if ("Firmado".equals(estadoFirma)) { %>
                    <% if (isAdmin != null && isAdmin) { %>
                        <a href="#" class="btn btn-success disabled-link">Firmar</a>
                    <% } %>
                    <a href="downloadPdfFirmadoServlet?IdServicio=<%= x.getIdServicio()%>" class="btn btn-info">Descargar</a>
                <% } else { %>
                    <% if (isAdmin != null && isAdmin) { %>
                        <a href="control?opc=11&IdDocumento=<%= x.getIdDocumento()%>" class="btn btn-success">Firmar</a>
                    <% } %>
                    <a href="#" class="btn btn-info disabled-link">Descargar</a>
                <% } %>
            </td>
        </tr>
    <%
        }
    %>
    </tbody>
</table>
<%@ include file="footer.jsp" %>

<style>
    .disabled-link {
        pointer-events: none;
        color: gray;
        cursor: default;
        text-decoration: none;
        position: relative;
    }

    .disabled-link:hover::after {
        content: "No disponible";
        position: absolute;
        top: 100%;
        left: 50%;
        transform: translateX(-50%);
        background-color: #f44336;
        color: white;
        padding: 4px 8px;
        border-radius: 4px;
        font-size: 12px;
        white-space: nowrap;
    }
</style>
