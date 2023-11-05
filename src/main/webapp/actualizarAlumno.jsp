<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="java.util.*" %>
<%@page import="model.Alumno" %>
<%@page import="model.Usuario" %>
<%@page import="model.Carrera" %>


<html>
<%Alumno a = (Alumno)request.getAttribute("alumno"); %>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sistema de Gestión - Alumno</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>


<body class="bg-dark text-light">

<a href="./indexAdmin.jsp" class="btn btn-outline-light m-1 py-2 position-absolute top-0 start-0">
<i class="fa-solid fa-house"></i></a>

<h2 class="mt-4 text-center">Registrar Nuevo Profesor</h2>

<div class="container ">
        <div class="row justify-content-center d-flex align-items-center">
            <div class="col-md-4">
                <form class="p-4 rounded-4 bg-primary bg-opacity-25" 
                method="post" action="ControllerAlumno"> 
                    <h3 class="text-center mb-4">Datos del Alumno</h3>
                    
                    <div class="form-group">
                        <label for="user">Usuario:</label>
                        <input type="text" class="form-control" id="username" name="user" placeholder="Usuario" required
                        value="<%=a.getUsuario().getUser() %>">
                    </div>
                    
                    <div class="form-group">
                        <label for="password">Contraseña:</label>
                        <input type="text" class="form-control" id="password" name="password" placeholder="Contraseña" required
                        value="<%=a.getUsuario().getPassword() %>">    
                    </div>
                    
                    <div class="form-group">
                        <label for="nombre">Nombre:</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre del Alumno" required
                        value="<%=a.getNombre() %>">
                    </div>
                    
                    <div class="form-group">
                        <label for="apellido">Apellido:</label>
                        <input type="text" class="form-control" id="apellido" name="apellido" placeholder="Apellido del Alumno" required
                        value="<%=a.getApellido() %>">
                    </div>
                    
                    <div class="form-group">
                        <label for="dni">Dni:</label>
                        <input type="text" class="form-control" id="dni" name="dni" placeholder="Dni del Profesor" required
                        value="<%=a.getDni() %>">
                    </div>
                    
                    <div class="form-group">
                        <label for="dni">Ciclo:</label>
                        <input type="number" class="form-control" id="ciclo" name="ciclo" placeholder="Ciclo" required
                        min="0" max="10" value="<%=a.getCiclo() %>">
                    </div>
                    
                    <div class="form-group">
                        <label for="carrera">Carrera</label>
                        <select class="form-control" id="carrera" name="carrera" required>
                        	
                        	<option value="" disabled selected>Elige una carrera</option>
                      	<%List<Carrera> carreras = (List<Carrera>)request.getAttribute("carreras");
                       		if(carreras!=null){	
                        		for(Carrera c:carreras){
                        	if(a.getCarrera().getIdcarrera()==c.getIdcarrera()){
                        	%>
                        		<option value="<%=c.getIdcarrera() %>" selected><%=c.getNombre() %></option>
                        	<%}else{ %>
                        		<option value="<%=c.getIdcarrera() %>"><%=c.getNombre() %></option>
                        	<% }
                        	} 
                        		}%>
                        	
                        </select>
                    </div>
                    
                    <div class="form-group">
                        <label for="carrera">Turno</label>
                        <select class="form-control" id="turno" name="turno" required>	
                        	<option value="<%=a.getTurno() %>" selected><%=a.getTurno() %></option>
                        	<option value="Mañana" >Mañana</option>
                        	<option value="Tarde" >Tarde</option>
                        	<option value="Noche" >Noche</option>
                      	
                        </select>
                    </div>
                                                            
                    <input type="hidden" name="idusuario" value="<%=a.getUsuario().getIdusuario() %>"> 
                    <input type="hidden" name="idalumno"  value="<%=a.getIdalumno() %>">
                    
                    <div class="text-center">
                    	<button type="submit" name="value" value="Actualizar" class="btn btn-success mt-3 mx-auto">Actualizar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
