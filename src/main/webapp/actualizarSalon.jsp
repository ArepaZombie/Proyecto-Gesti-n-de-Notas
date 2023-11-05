<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="java.util.*" %>
<%@page import="model.Curso" %>
<%@page import="model.Profesor" %>
<%@page import="model.Salon" %>

<%Salon s = (Salon)request.getAttribute("salon"); %>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sistema de Gestión - Salon</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>


<body class="bg-dark text-light">

<a href="./indexAdmin.jsp" class="btn btn-outline-light m-1 py-2 position-absolute top-0 start-0">
<i class="fa-solid fa-house"></i></a>

<h2 class="mt-4 text-center">Actualizar Salón</h2>

<div class="container ">
        <div class="row justify-content-center d-flex align-items-center">
            <div class="col-md-4">
                <form class="p-4 rounded-4 bg-primary bg-opacity-25" 
                method="post" action="ControllerSalones"> 
                    <h3 class="text-center mb-4">Datos del Salón</h3>
                                        
                    <div class="form-group">
                        <label for="curso">Curso</label>
                        <select class="form-control" id="curso" name="curso" required>
                        	
                        	<option value="" disabled selected>Elige un curso</option>
                      	<%List<Curso> cursos = (List<Curso>)request.getAttribute("cursos");
                       		if(cursos!=null){	
                        		for(Curso c:cursos){
                        			if(s.getCurso().getIdcurso()==c.getIdcurso()){
                        	%>
                        		<option value="<%=c.getIdcurso() %>" selected><%=c.getNombre() %></option>
                        	<%}else{ %>
                        		<option value="<%=c.getIdcurso() %>"><%=c.getNombre() %></option>
                        	<%		} 
                        		}
                        	}%>
                        	
                        </select>
                    </div>

					<div class="form-group">
                        <label for="profesor">Profesor</label>
                        <select class="form-control" id="profesor" name="profesor" required>
                        	
                        	<option value="" disabled selected>Elige un profesor</option>
                      	<%List<Profesor> profesores = (List<Profesor>)request.getAttribute("profesores");
                       		if(profesores!=null){	
                        		for(Profesor c:profesores){
                        			if(s.getProfesor().getIdprofesor()==c.getIdprofesor()){
                        	%>
                        		<option value="<%=c.getIdprofesor() %>" selected><%=c.getNombre() %> <%=c.getApellido() %></option>
                        	<%}else{ %>
                        		<option value="<%=c.getIdprofesor() %>"><%=c.getNombre() %> <%=c.getApellido() %></option>
                        	<%} 
                        		}
                        		}%>
                        	
                        </select>
                    </div>
                    
                                        
                    <div class="form-group">
                        <label for="carrera">Turno</label>
                        <select class="form-control" id="turno" name="turno" required>	
                        	<option value="<%=s.getTurno() %>" selected><%=s.getTurno() %></option>
                        	<option value="Mañana" >Mañana</option>
                        	<option value="Tarde" >Tarde</option>
                        	<option value="Noche" >Noche</option>
                      	
                        </select>
                    </div>

					<input type="hidden" name="idsalon"  value="<%=s.getIdsalon() %>">                    

                    <div class="text-center">
                    	<button type="submit" name="value" value="Actualizar" class="btn btn-primary mt-3 mx-auto">Actualizar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
