<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>
<%@page import="model.Alumno" %>
<%@page import="model.Nota" %>
<%@page import="model.Usuario" %>

<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Gestión de Notas - Alumno</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<%Alumno a = (Alumno)request.getAttribute("alumno"); %>

<body class="bg-dark text-light"  align="center">


<body class="bg-dark text-light"  align="center">
<a href="index.jsp" class="btn btn-outline-light m-1 py-2 position-absolute top-0 end-0"
onclick="return confirm('¿Estás seguro de que deseas cerrar sesión?');">
<i class="fa-solid fa-right-from-bracket"></i></a>


<% String mensaje = (String)request.getAttribute("mensaje"); 
if(mensaje!=null){%>
<p align="center" class="alert alert-success p-0 w-75 mx-auto"><%=mensaje %> </p>
<%} %>


<h2 class="my-1" align="center">Bienvenido</h2>
<h2  align="center"><%=a.getNombre() %> <%=a.getApellido() %></h2>
<h5 align="center"><%=a.getCarrera().getNombre() %> </h5>
<h5 align="center">Turno: <%=a.getTurno() %> - Ciclo: <%=a.getCiclo() %> </h5>

<h4 align="center">Tus Notas</h4>


<div class="container w-75 mx-auto text-center">
<table class="table table-striped table-dark table-hover table-bordered rounded align-middle">

	<tr>
		<th class="text-center">Codigo</th>
		<th>Curso</th>
		<th>Profesor</th>
		<th class="text-center">Nota 1</th>
		<th class="text-center">Nota 2</th>
		<th class="text-center">Nota 3</th>
		<th class="text-center">Promedio</th>
	</tr>
<%
List<Nota> listado = a.getNotas();
if(listado!=null){
	for(Nota n:listado){
		%>
		<tr>
			<td class="text-center"><%=n.getId().getIdsalon() %> </td>
			<td><%=n.getSalon().getCurso().getNombre() %> </td>
			<td><%=n.getSalon().getProfesor().getNombre() %> <%=n.getSalon().getProfesor().getApellido() %></td>
			<td class="text-center"><%=n.getNota1() %> </td>
			<td class="text-center"><%=n.getNota2() %> </td>
			<td class="text-center"><%=n.getNota3() %> </td>
			<td class="text-center"><%=n.getPromedio() %> </td>
		</tr>
		<% 
	}
}
%>
</table>

<a class="btn btn-success mx-auto my-1 text-center" align="center"
	href="ControllerAlumno?value=PreInscripcion&id=<%=a.getIdalumno() %>">
	<i class="fa-solid fa-circle-plus"></i>
	Matricularte en Curso
</a>
</div>



</body>
</html>