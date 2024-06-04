<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
    <h2>Lista de Documentos</h2>
    <table class="table table-striped mt-4">
        <thead>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Fecha</th>
            <th>Acciones</th>
        </tr>
        </thead>
        <tbody>
        <!-- Datos de muestra -->
        <tr>
            <td>1</td>
            <td>Documento1.pdf</td>
            <td>2024-05-01</td>
            <td>
                <button class="btn btn-primary btn-sm">Ver</button>
                <button class="btn btn-warning btn-sm">Editar</button>
                <button class="btn btn-danger btn-sm">Eliminar</button>
            </td>
        </tr>
        <tr>
            <td>2</td>
            <td>Documento2.pdf</td>
            <td>2024-05-03</td>
            <td>
                <button class="btn btn-primary btn-sm">Ver</button>
                <button class="btn btn-warning btn-sm">Editar</button>
                <button class="btn btn-danger btn-sm">Eliminar</button>
            </td>
        </tr>
        <tr>
            <td>3</td>
            <td>Documento3.pdf</td>
            <td>2024-05-05</td>
            <td>
                <button class="btn btn-primary btn-sm">Ver</button>
                <button class="btn btn-warning btn-sm">Editar</button>
                <button class="btn btn-danger btn-sm">Eliminar</button>
            </td>
        </tr>
        </tbody>
    </table>
<%@ include file="footer.jsp" %>
