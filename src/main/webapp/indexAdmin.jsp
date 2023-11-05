<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sistema de Gestión</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>


<body class="bg-dark text-light"  align="center">

<h2 class="my-4" align="center">Bienvenido Admin!</h2>

<div class="container w-75 mx-auto">
	<div class="row">
		<a class="btn btn-success col m-1 btn-lg" href="ControllerProfesor?value=Listar">
			<i class="fa-solid fa-chalkboard-user"></i>
			Profesores
		</a>
		<a class="btn btn-danger  col m-1 btn-lg" href="ControllerAlumno?value=Listar">
			<i class="fa-solid fa-user"></i>
			Alumnos
		</a>
	</div>
	<div class="row">
		<a class="btn btn-outline-success col m-1 btn-lg" href="ControllerCarrera?value=Listar">
			<i class="fa-solid fa-graduation-cap"></i>
			Carreras
		</a>
		<a class="btn btn-outline-primary col m-1 btn-lg" href="ControllerCurso?value=Listar">
			<i class="fa-solid fa-book"></i>
			Cursos
		</a>
		<a class="btn btn-outline-danger  col m-1 btn-lg" href="ControllerSalon?value=Listar">
			<i class="fa-solid fa-chalkboard"></i>
			Salones
		</a>
	</div>
</div>


</body>
</html>