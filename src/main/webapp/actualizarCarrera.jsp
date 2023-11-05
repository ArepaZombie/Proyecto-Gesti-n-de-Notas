<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="java.util.*" %>
<%@page import="model.Carrera" %>

<html>
<%Carrera p = (Carrera)request.getAttribute("carrera"); %>

<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sistema de Gestión - Carreras</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>


<body class="bg-dark text-light">

<a href="./indexAdmin.jsp" class="btn btn-outline-light m-1 py-2 position-absolute top-0 start-0">
<i class="fa-solid fa-house"></i></a>

<h2 class="mt-4 text-center">Actualizar Carrera</h2>

<div class="container ">
        <div class="row justify-content-center d-flex align-items-center">
            <div class="col-md-4">
                <form class="p-4 rounded-4 bg-primary bg-opacity-25" 
                method="post" action="ControllerCarrera"> 
                    <h3 class="text-center mb-4">Datos de la Carrera</h3>
                    
                    <div class="form-group">
                        <label for="nombre">Nombre de la Carrera:</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre de la Carrera" required
                        value="<%=p.getNombre() %>">
                    </div>
                    
                    <input type="hidden" name="idcarrera"  value="<%=p.getIdcarrera() %>">
                    
                    <div class="text-center">
                    	<button type="submit" name="value" value="Registrar" class="btn btn-success mt-3 mx-auto">Registrar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
