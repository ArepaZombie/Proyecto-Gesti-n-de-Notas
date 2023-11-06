<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="java.util.*" %>
<%@page import="model.Nota" %>
<%@page import="model.Salon" %>
<%@page import="model.Profesor" %>

<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sistema de Gestión - Notas</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>

<%Profesor p = (Profesor)request.getAttribute("profesor"); %>
<%Salon s = (Salon)request.getAttribute("salon"); %>

<body class="bg-dark text-light text-center">

<a href="ControllerProfesor?value=Sesion&id=<%=p.getIdprofesor() %>" class="btn btn-outline-light m-1 py-2 position-absolute top-0 start-0">
<i class="fa-solid fa-house"></i></a>

<% String mensaje = (String)request.getAttribute("mensaje"); 
if(mensaje!=null){%>
<p align="center" class="alert alert-success p-0 w-75 mx-auto"><%=mensaje %> </p>
<%} %>

<h2 class="mt-4"><%=s.getIdsalon() %> - <%=s.getCurso().getNombre() %> - <%=s.getTurno() %></h2>


<div class="container w-75automx-5">
<table class="table table-striped table-dark table-hover table-bordered rounded align-middle">

	<tr>
		<th style="width:55%">Alumno</th>
		<th class="text-center">Nota 1</th>
		<th class="text-center">Nota 2</th>
		<th class="text-center">Nota 3</th>
		<th class="text-center">Promedio</th>
		<th class="text-center">Actualizar</th>
	</tr>
<%
List<Nota> listado = s.getNotas();
if(listado!=null){
	for(Nota n:listado){
		%>
		<tr>	
		<form method="post" action="ControllerProfesor">
			<td><%=n.getAlumno().getNombre() %> <%=n.getAlumno().getApellido() %></td>
			<td class="align-center">
				<input type="number" class="form-control w-75 mx-auto" name="nota1"  
                        min="0" max="20" step="0.1" value="<%=n.getNota1() %>"
                        <%if(n.getNota1()>0) {%> readonly <%} %> >
			</td>
			
			<td class="align-center">
				<input type="number" class="form-control w-75 mx-auto" name="nota2"  
                        min="0" max="20" step="0.1" value="<%=n.getNota2() %>"
                        <%if(n.getNota2()>0) {%> readonly <%} %> >
			</td>
			
			<td class="align-center">
				<input type="number" class="form-control w-75 mx-auto" name="nota3"  
                        min="0" max="20" step="0.1" value="<%=n.getNota3() %>"
                        <%if(n.getNota3()>0) {%> readonly <%} %> >
			</td>			
				<td class="text-center"><%=n.getPromedio() %> 
	            <input type="hidden" name="idalumno"  value="<%=n.getId().getIdalumno() %>">
	            <input type="hidden" name="idsalon"  value="<%=n.getId().getIdsalon() %>">
	            <input type="hidden" name="idprofesor"  value="<%=p.getIdprofesor() %>">
			</td>
            
			<td class="text-center">
				<button type="submit" name="value" value="IngresarNota" class="btn btn-success btn-sm">
						<i class="fa-solid fa-square-check"></i>
				</button>		
			</td>
		</form>
		</tr>
		<% 
	}
}
%>
</table>
</div>

</body>
</html>