<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>TomatTree - Resultado</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light p-5">
    <div class="container col-md-6 card shadow p-4">
        <h2 class="text-success">Respuesta del Servidor</h2>
        <div class="alert alert-info mt-3">
            <%= request.getAttribute("mensaje") != null ? request.getAttribute("mensaje") : "Proceso exitoso en TomatTree" %>
        </div>
        <a href="index.html" class="btn btn-dark mt-3">Volver al inicio</a>
    </div>
</body>
</html>