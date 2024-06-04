<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
    <h2>CRUD de Plantillas</h2>
    <form action="crudServlet" method="post" class="mt-4">
        <div class="form-group">
            <label for="templateName">Nombre de la Plantilla:</label>
            <input type="text" id="templateName" name="templateName" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-primary btn-block">Guardar</button>
    </form>
<%@ include file="footer.jsp" %>
