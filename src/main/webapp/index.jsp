<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Iniciar sesión</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
</head>


<body class="bg-dark text-light"  align="center">

<h2 class="my-4" align="center">Sistema de Gestión de Notas</h2>

<div class="container ">
        <div class="row justify-content-center d-flex align-items-center">
            <div class="col-md-4">
                <form class="p-4 rounded-4 bg-primary bg-opacity-25" method="post" action="ControllerUsuario"> 
                    <h3 class="text-center mb-4">Iniciar Sesión</h3>
                    <div class="form-group">
                        <label for="user">Usuario:</label>
                        <input type="text" class="form-control" id="username" name="user" placeholder="Nombre de usuario" required>
                    </div>
                    <div class="form-group">
                        <label for="password">Contraseña:</label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="Contraseña" required>
                        
                    </div>
                    <div class="text-center">
                    	<button type="submit" name="value" value="Validar" class="btn btn-secondary mt-3 mx-auto">Iniciar Sesión</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

<% String mensaje = (String)request.getAttribute("mensaje"); 
if(mensaje!=null){%>
<h4 align="center" class="alert alert-danger w-50 mx-auto"><%=mensaje %> </h4>
<%} %>

</body>
</html>