<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
    <h2>Subir Documento</h2>
    <form action="uploadServlet" method="post" enctype="multipart/form-data" class="mt-4">
        <div class="form-group">
            <label for="file">Seleccionar archivo:</label>
            <input type="file" id="file" name="file" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-primary btn-block">Subir</button>
    </form>
<%@ include file="footer.jsp" %>
