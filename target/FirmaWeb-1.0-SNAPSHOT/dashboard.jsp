<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
    <h2>Dashboard</h2>
    <div class="row mt-4">
        <div class="col-md-4">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Nuevo Documento</h5>
                    <p class="card-text">Sube un nuevo documento para firmar.</p>
                    <a href="${pageContext.request.contextPath}/formDocumento.jsp" class="btn btn-primary">Subir Documento</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Lista de Documentos</h5>
                    <p class="card-text">Visualiza y gestiona tus documentos subidos.</p>
                    <a href="${pageContext.request.contextPath}/formListaDocumento.jsp" class="btn btn-primary">Ver Documentos</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">CRUD Plantillas</h5>
                    <p class="card-text">Gestiona las plantillas para firmas.</p>
                    <a href="${pageContext.request.contextPath}/plantillaCrud.jsp" class="btn btn-primary">Gestionar Plantillas</a>
                </div>
            </div>
        </div>
    </div>
<%@ include file="footer.jsp" %>
