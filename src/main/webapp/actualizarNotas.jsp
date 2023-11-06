<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="java.util.*" %>
<%@page import="model.Salon" %>
<%@page import="model.Alumno" %>
<%@page import="model.Nota" %>


<html>
<%Nota n = (Nota)request.getAttribute("notas"); %>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sistema de Gestión - Notas</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>


<body class="bg-dark text-light">

<a href="./indexAdmin.jsp" class="btn btn-outline-light m-1 py-2 position-absolute top-0 start-0">
<i class="fa-solid fa-house"></i></a>

<h2 class="mt-4 text-center">Actualizar Notas</h2>

<div class="container ">
        <div class="row justify-content-center d-flex align-items-center">
            <div class="col-md-4">
                
                <form class="p-4 rounded-4 bg-primary bg-opacity-25" 
                method="post" action="ControllerNotas">  
                               
                    <h3 class="text-center mb-4">Registro de Notas</h3>                    
                    <h4 class="text-center">Alumno: <%=n.getAlumno().getNombre() %> <%=n.getAlumno().getApellido() %></h4>
                    <h4 class="text-center">Curso: <%=n.getSalon().getIdsalon() %> <%=n.getSalon().getCurso().getNombre() %></h4>
                    <h5 class="text-center">Profesor: <%=n.getSalon().getProfesor().getNombre() %> <%=n.getSalon().getProfesor().getApellido() %></h5>
                    <div class="row" >
                     <div class="form-group col">
                        <label for="nota1">Nota 1:</label>
                        <input type="number" class="form-control" id="nota1" name="nota1"  required
                        min="0" max="20" step="0.1" value="<%=n.getNota1() %>">
                    </div>
                    
                    <div class="form-group col">
                        <label for="nota2">Nota 2:</label>
                        <input type="number" class="form-control" id="nota2" name="nota2"  required
                        min="0" max="20" step="0.1" value="<%=n.getNota2() %>">
                    </div>
                    
                    <div class="form-group col">
                        <label for="nota3">Nota 3:</label>
                        <input type="number" class="form-control" id="nota3" name="nota3"  required
                        min="0" max="20" step="0.1" value="<%=n.getNota3() %>">
                    </div>
                    
                    <input type="hidden" name="idalumno"  value="<%=n.getId().getIdalumno() %>">
                    <input type="hidden" name="idsalon"  value="<%=n.getId().getIdsalon() %>">
                    </div>
                    
                    <div class="text-center">
                    	<button type="submit" name="value" value="Actualizar" class="btn btn-primary mt-3 mx-auto">Actualizar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
