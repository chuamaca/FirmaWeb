<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
    <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <style>
        body {
            background: url('fotos/background.jpg') no-repeat center center fixed;
            background-size: cover;
            font-family: 'Roboto', sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            overflow: hidden;
        }
        body::before {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            background: rgba(0, 0, 0, 0.5);
            z-index: -1;
        }
        .login-container {
            background: rgba(255, 255, 255, 0.9);
            padding: 40px 30px;
            border-radius: 15px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.3);
            width: 100%;
            max-width: 400px;
            color: #333;
            text-align: center;
            animation: slideIn 1s ease-out;
        }
        .login-container h1 {
            margin-bottom: 20px;
            font-size: 2rem;
            color: #007bff;
        }
        .logo {
            margin-bottom: 20px;
        }
        .form-control {
            background: none;
            border: none;
            border-bottom: 1px solid #ccc;
            border-radius: 0;
            color: #333;
            margin-bottom: 20px;
        }
        .form-control:focus {
            border-color: #007bff;
            box-shadow: none;
        }
        .btn-primary {
            background: #007bff;
            border: none;
            width: 100%;
            padding: 10px;
            font-size: 1.2rem;
            margin-top: 20px;
            transition: background 0.3s ease;
        }
        .btn-primary:hover {
            background: #0056b3;
        }
        .form-check-label {
            color: #333;
        }
        .forgot-password, .signup {
            color: #007bff;
            font-size: 0.9rem;
            display: block;
            margin-top: 10px;
        }
        .forgot-password:hover, .signup:hover {
            color: #0056b3;
            text-decoration: underline;
        }
        @keyframes slideIn {
            from { transform: translateY(-50px); opacity: 0; }
            to { transform: translateY(0); opacity: 1; }
        }
    </style>
</head>
<body>
    <div class="login-container">
        <div class="logo">
            <img src="fotos/logo.jpg" alt="Logo" width="100">
        </div>
        <h1>Bienvenido!</h1>
        <form method="post" action="login">
            <input type="text" id="usuario" name="usuario" class="form-control" placeholder="Usuario" required autofocus>
            <input type="password" id="password" name="clave" class="form-control" placeholder="Contraseña" required>
            <div class="form-check">
                <input type="checkbox" class="form-check-input" id="rememberMe">
                <label class="form-check-label" for="rememberMe">Recuerdame</label>
            </div>
            <a href="#" class="forgot-password">Olvidaste tu contraseña?</a>
            <button type="submit" class="btn btn-primary">Ingresar</button>
        </form>
        <c:if test="${not empty errorMessage}">
            <div class="alert alert-danger mt-3">${errorMessage}</div>
        </c:if>
        <a href="#" class="signup">Registrate</a>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
