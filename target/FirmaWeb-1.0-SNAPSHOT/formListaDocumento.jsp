
<%@page import="Modelo.ServicioDocumento, java.util.List, java.util.ArrayList"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<h2>Lista de Documentos</h2>


<%

    List<ServicioDocumento> listaDocumentos = (ArrayList<ServicioDocumento>) request.getAttribute("dato");
    String estadoFirma = "";
%>


<table class="table table-striped mt-4">
    <thead>
        <tr class="">
            <th>Empresa<th>Tipo Firma <th> Estado  <th>Acciones
    </thead>  
    <%
        for (ServicioDocumento x : listaDocumentos) {

            if (x.getEstado() == 0) {
                estadoFirma = "Sin Firmado";
            } else if(x.getEstado()!=0) {
                estadoFirma = "Firmado";
            }
            out.print("<tr><td>" + x.getEmpresa() + "<td>" + x.getCategoria() + "<td>" + estadoFirma);
    %>

    <td>
        <button class="btn btn-primary btn-sm">Ver Documento</button>
        <button class="btn btn-primary btn-sm">Descargar</button>
        <a href="control?opc=11&IdDocumento=<%=x.getIdDocumento()%>" class="btn btn-success">Firmar</a>
        <button class="btn btn-warning btn-sm">Firmar</button>
        <button class="btn btn-danger btn-sm">Anular Documento</button>
        <!-- <a href="control?opc=10&IdDocumento=<%=x.getIdDocumento()%>" class="btn btn-success">Firmar</a> -->
    </td>

    <%
        }
    %>
</table> 
<%@ include file="footer.jsp" %>
