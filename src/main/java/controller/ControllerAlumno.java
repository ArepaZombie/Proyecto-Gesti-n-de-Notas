package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoAlumno;
import dao.DaoCarrera;
import model.Alumno;
import model.Carrera;
import model.Usuario;

/**
 * Servlet implementation class ControllerAlumno
 */
public class ControllerAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAlumno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = request.getParameter("value");
		
		switch(value){
			case "Listar": ListarAlumnos(request,response);break;
			case "Registrar": RegistrarAlumno(request,response);break;
			case "PreRegistrar": PreRegistrarAlumno(request,response);break;
			case "Buscar": BuscarAlumno(request,response);break;
			case "Actualizar": ActualizarAlumno(request,response);break;
			case "Borrar": BorrarAlumno(request,response);break;
			default:break;
		}
		//System.out.println(value);
	}

	private void PreRegistrarAlumno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoCarrera dao = new DaoCarrera();
		List<Carrera> carreras = dao.ListarCarrera(true);
		request.setAttribute("carreras", carreras);
		
		request.getRequestDispatcher("formularioAlumno.jsp").forward(request, response);    
	}
	
    private void BorrarAlumno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//instanciamos las clases
    	DaoAlumno dao = new DaoAlumno();

    	//Buscamos la info
    	int id = Integer.parseInt(request.getParameter("id"));
    	
    	//Eliminamos...
    	dao.EliminarAlumno(id);
    	
    	//Mandamos la data
		request.setAttribute("mensaje", "Alumno eliminado!");
		
		//Nos devolvemos al listado
		ListarAlumnos(request, response);
		
	}

	private void ActualizarAlumno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//instanciamos las clases
    	DaoAlumno dao = new DaoAlumno();
    	Alumno p = new Alumno();
    	Usuario u = new Usuario();
    	
    	//Recuperamos los daots
		String user = request.getParameter("user");
		u.setUser(user);
		
		String password = request.getParameter("password");
		u.setPassword(password);
		
		p.setNombre(request.getParameter("nombre"));
		p.setApellido(request.getParameter("apellido"));
		p.setDni(request.getParameter("dni"));
		p.setCiclo(Integer.parseInt(request.getParameter("ciclo")));
		p.setTurno(request.getParameter("turno"));
		
		Carrera carrera = new Carrera();
		carrera.setIdcarrera(Integer.parseInt(request.getParameter("carrera")));
		p.setCarrera(carrera);

		int idusuario = Integer.parseInt(request.getParameter("idusuario"));
		u.setIdusuario(idusuario);
		p.setUsuario(u);
		
		p.setIdalumno(Integer.parseInt(request.getParameter("idalumno")));
		
		//Mandamos la data
		dao.ActualizarAlumno(p);
		request.setAttribute("mensaje", "Alumno actualizado!");
		
		//Nos devolvemos al listado
		ListarAlumnos(request, response);
		
	}

	private void BuscarAlumno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//instanciamos las clases
    	DaoAlumno dao = new DaoAlumno();

    	//Buscamos la info
    	int id = Integer.parseInt(request.getParameter("id"));
    	Alumno p = dao.BuscarAlumno(id);
    	
    	//Enviamos la info
    	request.setAttribute("alumno", p);
		
    	//Buscamos la lista de carreras
    	DaoCarrera daoc = new DaoCarrera();
		List<Carrera> carreras = daoc.ListarCarrera(true);
		request.setAttribute("carreras", carreras);
    	
    	//Vamos al formulario
    	request.getRequestDispatcher("actualizarAlumno.jsp").forward(request, response);
	}

	private void RegistrarAlumno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//instanciamos las clases
    	DaoAlumno dao = new DaoAlumno();
    	Alumno p = new Alumno();
    	Usuario u = new Usuario();
    	
		//Recuperamos los daots
		String user = request.getParameter("user");
		u.setUser(user);
		
		String password = request.getParameter("password");
		u.setPassword(password);
		
		p.setUsuario(u);
		
		p.setNombre(request.getParameter("nombre"));
		p.setApellido(request.getParameter("apellido"));
		p.setDni(request.getParameter("dni"));
		p.setCiclo(Integer.parseInt(request.getParameter("ciclo")));
		p.setTurno(request.getParameter("turno"));
		
		Carrera carrera = new Carrera();
		carrera.setIdcarrera(Integer.parseInt(request.getParameter("carrera")));
		p.setCarrera(carrera);
		
		
		//Mandamos la data
		dao.RegistrarAlumno(p);
		request.setAttribute("mensaje", "Alumno registrado!");
		
		//Nos devolvemos al listado
		ListarAlumnos(request, response);
	}

	private void ListarAlumnos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//instanciamos el dao
    	DaoAlumno dao = new DaoAlumno();
		String trash = request.getParameter("trash");
		//request.setAttribute("mensaje", trash);
		
		Boolean activos = true;
    	if(trash!=null)  activos = false;
    	
    	//Obtenemos la data
    	List<Alumno> listado = dao.ListarAlumno(activos);

    	//La mandamos a la vista
    	request.setAttribute("listado", listado);
		request.getRequestDispatcher("listarAlumnos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}