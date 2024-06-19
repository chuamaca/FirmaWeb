<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="Modelo.Documento, java.util.List, java.util.ArrayList"%>
<%@ include file="header.jsp" %>
<h3>Firmar Documentos</h3>

<%

    List<Documento> list = (ArrayList<Documento>) request.getAttribute("dato");

%>


<form action="crudServlet" method="post" class="mt-4">
    <div class="form-group">
        <label for="templateName">Nombre de la Plantilla:</label>
        <input type="text" id="templateName" name="templateName" class="form-control" required>
    </div>
    <button type="submit" class="btn btn-primary btn-block">Guardar</button>
</form>

<%        for (Documento x : list) {
        out.print("<label for='templateName'>" + x.getIdDocumento() + "</label> <br>");
        out.print("<label for='templateName'>" + x.getNombreDocumento() + "</label> <br>");
        out.print("<label for='templateName'>" + x.getTipoDocumento() + "</label><br>");
        out.print("<label for='templateName'>" + x.getArchivoOrigen() + "</label><br>");

    }


%>





<%@ include file="footer.jsp" %>
