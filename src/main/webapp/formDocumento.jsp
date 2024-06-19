<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<h2>Subir Documento</h2>
<form action="uploadServlet" method="post" enctype="multipart/form-data">
    

    <div class="form-group">
        <label for="file">Archivo:</label>
        <input type="file" id="file" name="file" class="form-control-file" onchange="displayFileInfo()" required>
    </div>

    <div class="form-group">
        <label for="fileName">Nombre del Archivo:</label>
        <input type="text" id="fileName" name="fileName" class="form-control" readonly>
    </div>

    <div class="form-group">
        <label for="fileType">Tipo de Archivo:</label>
        <input type="text" id="fileType" name="fileType" class="form-control" readonly>
    </div>

    <div class="form-group">
        <label for="idcliente">Cliente:</label>
        <select id="idcliente" name="idcliente" class="form-control" required>
            <option value="1">Clinica Anglo Americana</option>
            <option value="2">Adeco</option>
            <option value="3">Empresa 3</option>
        </select>
    </div>

    <div class="form-group">
        <label for="idcategoria">Tipo de Firma:</label>
        <select id="idcategoria" name="idcategoria" class="form-control" required>
            <option value="1">Firma Simple</option>
            <option value="2">Firma Avanzada</option>
        </select>
    </div>

 
    <input class="btn btn-success" type="submit">
</form>

<script>
function displayFileInfo() {
    const fileInput = document.getElementById('file');
    const fileName = document.getElementById('fileName');
    const fileType = document.getElementById('fileType');
    const file = fileInput.files[0];

    if (file) {
        fileName.value = file.name;
        fileType.value = file.type || getFileExtension(file.name);
    } else {
        fileName.value = '';
        fileType.value = '';
    }
}

function getFileExtension(fileName) {
    const parts = fileName.split('.');
    return parts.length > 1 ? parts.pop() : 'Desconocido';
}
</script>
<%@ include file="footer.jsp" %>