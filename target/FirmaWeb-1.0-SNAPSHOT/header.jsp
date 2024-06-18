<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>FirmaFacil</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminlte.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
            margin: 0;
        }
        .navbar {
            background-color: #007bff;
            color: white;
        }
        .navbar a {
            color: white;
        }
        .navbar .navbar-nav .nav-link {
            color: white;
            border-radius: 5px;
        }
        .navbar .navbar-nav .nav-link:hover {
            background-color: #0056b3;
        }
        footer {
            background-color: #007bff;
            color: white;
            padding: 10px 0;
            text-align: center;
            width: 100%;
            margin-top: auto;
        }
        .container {
            flex: 1;
            padding-top: 20px;
        }
        h2 {
            color: #fff;
            background-color: #007bff;
            padding: 10px;
            border-radius: 5px;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light">
        <a class="navbar-brand" href="#">FirmaFacil</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/dashboard.jsp">Dashboard</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/formDocumento.jsp">Nuevo Documento</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="control?opc=1">Lista de Documentos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/plantillaCrud.jsp">CRUD Plantillas</a>
                </li>
            </ul>
        </div>
    </nav>
    <div class="container">
