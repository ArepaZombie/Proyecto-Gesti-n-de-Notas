<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="java.util.*" %>
<%@page import="model.Carrera" %>
<%@page import="model.Usuario" %>


<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sistema de Gesti�n - Carreras</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>


<body class="bg-dark text-light text-center">

<a href="./indexAdmin.jsp" class="btn btn-outline-light m-1 py-2 position-absolute top-0 start-0">
<i class="fa-solid fa-house"></i></a>

<a href="ControllerCarrera?value=Listar&trash=true" class="btn btn-outline-light m-1 py-2 position-absolute top-0 end-0">
<i class="fa-solid fa-trash-can"></i></a>


<% String mensaje = (String)request.getAttribute("mensaje"); 
if(mensaje!=null){%>
<p align="center" class="alert alert-success p-0 w-75 mx-auto"><%=mensaje %> </p>
<%} %>

<h2 class="mt-4">Lista de Carreras</h2>
<a class="btn btn-success mx-auto my-1" 
	href="ControllerCarrera?value=PreRegistrar">
	<i class="fa-solid fa-circle-plus"></i>
	Nueva Carrera
</a>

<div class="container mx-auto text-center">
<table class="table table-striped table-dark table-hover table-bordered rounded align-middle">

	<tr>
		<th>Nombre</th>
		<th>Cursos</th>
		<th>Acciones</th>
	</tr>
<%
List<Carrera> listado = (List<Carrera>)request.getAttribute("listado");
if(listado!=null){
	for(Carrera p:listado){
		%>
	<tr >
		<td><%=p.getNombre() %> </td>
		<td class="text-center">
			<a class="btn btn-outline-light btn-sm">
			<i class="fa-regular fa-file-lines"></i>
				Ver Notas
			</a>
		</td>
		<td class="text-center">		
			<a class="btn btn-primary btn-sm" href="ControllerCarrera?value=Buscar&id=<%=p.getIdcarrera()%>">
				<i class="fa-solid fa-pen-to-square"></i>			
			</a>
			<a class="btn btn-danger btn-sm" href="ControllerCarrera?value=Borrar&id=<%=p.getIdcarrera()%>"
			onclick="return confirm('�Est�s seguro de que deseas eliminar?');">
				<i class="fa-solid fa-trash-can"></i>			
			</a>
		</td>
	</tr>
		<% 
	}
}
%>
</table>
</div>

</body>
</html>