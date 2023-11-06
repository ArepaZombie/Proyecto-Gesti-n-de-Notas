<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>
<%@page import="model.Profesor" %>
<%@page import="model.Salon" %>
<%@page import="model.Usuario" %>

<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Gestión de Notas - Profesor</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<%Profesor p = (Profesor)request.getAttribute("profesor"); %>

<body class="bg-dark text-light"  align="center">


<body class="bg-dark text-light"  align="center">
<a href="index.jsp" class="btn btn-outline-light m-1 py-2 position-absolute top-0 end-0"
onclick="return confirm('¿Estás seguro de que deseas cerrar sesión?');">
<i class="fa-solid fa-right-from-bracket"></i></a>

<body class="bg-dark text-light"  align="center">
<a href="ControllerProfesor?value=Buscar&id=<%=p.getIdprofesor() %>" class="btn btn-outline-light m-1 py-2 position-absolute top-0 start-0">
<i class="fa-solid fa-pen-to-square"></i>	</a>

<h2 class="my-4" align="center">Bienvenido <%=p.getNombre() %> <%=p.getApellido() %></h2>
<h4 align="center">Tus Salones</h4>
<div class="container w-75 mx-auto text-center">
	<%
List<Salon> listado = p.getSalons();
if(listado!=null){
	for(Salon s:listado){
		%>
	<a class="btn btn-outline-light btn-lg w-100 my-2"
	href="ControllerProfesor?value=Notas&salon=<%=s.getIdsalon()%>&id=<%= p.getIdprofesor()%>">
	<%=s.getIdsalon() %> - <%=s.getCurso().getNombre() %> - <%=s.getTurno() %>
	</a>	
		<%} 
	} %>
	
</div>






</body>
</html>