package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoSalon;
import dao.DaoCarrera;
import model.Salon;
import model.Carrera;
import model.Curso;
import model.Profesor;

/**
 * Servlet implementation class ControllerSalon
 */
public class ControllerSalon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerSalon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = request.getParameter("value");
		
		switch(value){
			case "Listar": ListarSalones(request,response);break;
			case "Registrar": RegistrarSalon(request,response);break;
			case "PreRegistrar": PreRegistrarSalon(request,response);break;
			case "Buscar": BuscarSalon(request,response);break;
			case "Actualizar": ActualizarSalon(request,response);break;
			case "Borrar": BorrarSalon(request,response);break;
			default:break;
		}
		//System.out.println(value);
	}

	private void PreRegistrarSalon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoCarrera dao = new DaoCarrera();
		List<Carrera> carreras = dao.ListarCarrera(true);
		request.setAttribute("carreras", carreras);
		
		request.getRequestDispatcher("formularioSalon.jsp").forward(request, response);    
	}
	
    private void BorrarSalon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//instanciamos las clases
    	DaoSalon dao = new DaoSalon();

    	//Buscamos la info
    	int id = Integer.parseInt(request.getParameter("id"));
    	
    	//Eliminamos...
    	dao.EliminarSalon(id);
    	
    	//Mandamos la data
		request.setAttribute("mensaje", "Salon eliminado!");
		
		//Nos devolvemos al listado
		ListarSalones(request, response);
		
	}

	private void ActualizarSalon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//instanciamos las clases
    	DaoSalon dao = new DaoSalon();
    	Salon p = new Salon();
    	
    	//Recuperamos los daots
		p.setTurno(request.getParameter("turno"));
		
		Curso curso = new Curso();
		curso.setIdcurso(Integer.parseInt(request.getParameter("curso")));
		p.setCurso(curso);
		
		Profesor profesor = new Profesor();
		profesor.setIdprofesor(Integer.parseInt(request.getParameter("profesor")));
		p.setProfesor(profesor);
		
		p.setIdsalon(Integer.parseInt(request.getParameter("idsalon")));
		
		//Mandamos la data
		dao.ActualizarSalon(p);
		request.setAttribute("mensaje", "Salon actualizado!");
		
		//Nos devolvemos al listado
		ListarSalones(request, response);
	}

	private void BuscarSalon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//instanciamos las clases
    	DaoSalon dao = new DaoSalon();

    	//Buscamos la info
    	int id = Integer.parseInt(request.getParameter("id"));
    	Salon p = dao.BuscarSalon(id);
    	
    	//Enviamos la info
    	request.setAttribute("Salon", p);
		
    	//Buscamos la lista de carreras
    	DaoCarrera daoc = new DaoCarrera();
		List<Carrera> carreras = daoc.ListarCarrera(true);
		request.setAttribute("carreras", carreras);
    	
    	//Vamos al formulario
    	request.getRequestDispatcher("actualizarSalon.jsp").forward(request, response);
	}

	private void RegistrarSalon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//instanciamos las clases
    	DaoSalon dao = new DaoSalon();
    	Salon p = new Salon();
    	
    	//Recuperamos los daots
		p.setTurno(request.getParameter("turno"));
		
		Curso curso = new Curso();
		curso.setIdcurso(Integer.parseInt(request.getParameter("curso")));
		p.setCurso(curso);
		
		Profesor profesor = new Profesor();
		profesor.setIdprofesor(Integer.parseInt(request.getParameter("profesor")));
		p.setProfesor(profesor);
		
		//Mandamos la data
		dao.RegistrarSalon(p);
		request.setAttribute("mensaje", "Salon registrado!");
		
		//Nos devolvemos al listado
		ListarSalones(request, response);
	}

	private void ListarSalones(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//instanciamos el dao
    	DaoSalon dao = new DaoSalon();
		String trash = request.getParameter("trash");
		//request.setAttribute("mensaje", trash);
		
		Boolean activos = true;
    	if(trash!=null)  activos = false;
    	
    	//Obtenemos la data
    	List<Salon> listado = dao.ListarSalon(activos);

    	//La mandamos a la vista
    	request.setAttribute("listado", listado);
		request.getRequestDispatcher("listarSalones.jsp").forward(request, response);
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
