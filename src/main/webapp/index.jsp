<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Iniciar sesión</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
</head>


<body class="bg-dark text-light"  align="center">

<h2 align="center">Sistema de Gestión de Notas</h2>

<h3 align="center">Por favor, inicie sesión</h3>


<div class="conteiner">
<form method="post" action="ControllerUsuario">

<table class="table-secondary pd-5 table-borderless rounded table text-center w-25 mx-auto" >

<tr>
	<td>Usuario:</td>
	<td><input type="text" name="user"> </td>
</tr>

<tr>
	<td>Password:</td>
	<td><input type="password" name="password"> </td>
</tr>

<tr>
	<td colspan="2" align="center"><input class="btn btn-success" type="submit" name="value" value="Validar"> </td>
</tr>

</table>
</form>
</div>

<% String mensaje = (String)request.getAttribute("mensaje"); 
if(mensaje!=null){%>
<h3 align="center"><%=mensaje %> </h3>
<%} %>

</body>
</html>