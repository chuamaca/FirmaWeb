
<%@page import="Modelo.ServicioDocumento, java.util.List, java.util.ArrayList"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<h2>Lista de Documentos</h2>


<%

    List<ServicioDocumento> listaDocumentos = (ArrayList<ServicioDocumento>) request.getAttribute("dato");
    String estadoFirma = "";
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
        <tr class="">
            <th>Empresa<th>Tipo Firma <th> Estado  <th>Acciones
    </thead>  
    <%
        for (ServicioDocumento x : listaDocumentos) {

            if (x.getIdServicio() == 0) {
                estadoFirma = "Sin Firmado";
            }
            if (x.getIdServicio() > 0) {
                estadoFirma = "Firmado";
            }
            out.print("<tr><td>" + x.getEmpresa() + "<td>" + x.getCategoria() + "<td>" + estadoFirma);
    %>

    <td>
        <button class="btn btn-primary btn-sm">Ver Documento</button>
        <button class="btn btn-primary btn-sm">Descargar</button>

        <%
            if ("Firmado".equals(estadoFirma)) {
        %>
        <a href="#" class="btn btn-success disabled-link">Firmar</a>
        <%
        } else {
        %>
        <a href="control?opc=11&IdDocumento=<%= x.getIdDocumento()%>" class="btn btn-success">Firmar</a>
        <%
            }
        %>


<!-- <a href="control?opc=11&IdDocumento=<%=x.getIdDocumento()%>" class="btn btn-success">Firmar</a>   <button class="btn btn-warning btn-sm">Firmar</button> -->
        <button class="btn btn-danger btn-sm">Anular Documento</button>
        <!-- <a href="control?opc=10&IdDocumento=<%=x.getIdDocumento()%>" class="btn btn-success">Firmar</a> -->
    </td>

    <%
        }
    %>
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
        background-color: #f44336; /* Color de fondo */
        color: white; /* Color del texto */
        padding: 4px 8px;
        border-radius: 4px;
        font-size: 12px;
        white-space: nowrap;
    }
</style>