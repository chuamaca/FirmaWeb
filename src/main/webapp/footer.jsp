<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>FirmaFacil</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminlte.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/sweetalert.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/sidebar.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap" rel="stylesheet">
    <style>
        body {
            background: url('${pageContext.request.contextPath}/fotos/background.jpg') no-repeat center center fixed;
            background-size: cover;
            font-family: 'Arial', sans-serif;
            overflow-y: auto;
            margin: 0;
            padding: 0;
        }
        body::before {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            background: rgba(255, 255, 255, 0.9);
            z-index: -1;
        }
        .navbar, .sidebar, footer {
            background: linear-gradient(135deg, #004d99, #001f3f);
        }
        .navbar-brand {
            color: white !important;
            font-family: 'Montserrat', sans-serif;
            font-weight: 700;
            font-size: 1.8em;
            text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.2);
            padding: 0 20px;
        }
        .sidebar {
            height: 100vh;
            position: fixed;
            top: 0;
            left: 0;
            width: 250px;
            padding-top: 70px;
            transition: transform 0.3s ease;
            z-index: 1000;
            overflow-y: auto;
        }
        .sidebar .nav-link {
            color: white !important;
            margin: 10px 0;
            display: flex;
            align-items: center;
            padding: 10px 20px;
            transition: background-color 0.3s ease;
        }
        .sidebar .nav-link i {
            margin-right: 10px;
        }
        .sidebar .nav-link:hover {
            background-color: rgba(0, 0, 0, 0.2) !important;
            color: white !important;
        }
        .sidebar .navbar-brand {
            color: white !important;
            font-size: 1.5rem;
            margin-bottom: 20px;
            text-align: center;
        }
        .container-custom {
            margin-left: 270px;
            padding: 20px;
            transition: margin-left 0.3s ease;
        }
        .navbar-toggler.sidebar-toggler {
            border-color: white;
            color: white;
            position: absolute;
            left: 10px;
            z-index: 1100;
            display: block;
        }
        .sidebar.collapsed {
            transform: translateX(-250px);
        }
        .container-custom.collapsed {
            margin-left: 20px;
        }
        .navbar {
            z-index: 1100;
            background: linear-gradient(135deg, #004d99, #001f3f);
            color: white;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .navbar-brand {
            color: white !important;
            margin-left: 80px; /* Moved to the right */
        }
        .logout-button {
            background: none;
            border: none;
            color: white;
            padding: 10px 20px;
            cursor: pointer;
            font-size: 1em;
            line-height: 1.5;
            text-align: center;
            transition: background-color 0.3s ease;
        }
        .logout-button:hover {
            background-color: rgba(255, 255, 255, 0.2);
        }
        footer {
            background: linear-gradient(135deg, #004d99, #001f3f);
            color: white;
            text-align: center;
            padding: 10px 0;
            width: 100%;
            position: fixed;
            bottom: 0;
            left: 0;
            z-index: 1050;
        }
    </style>
</head>
<body>
    <footer>
        <p>&copy; 2023 FirmaFacil. All rights reserved.</p>
    </footer>
</body>
</html>
