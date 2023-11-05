package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoCurso;
import dao.DaoCarrera;
import model.Curso;
import model.Carrera;

/**
 * Servlet implementation class ControllerCurso
 */
public class ControllerCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerCurso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = request.getParameter("value");
		
		switch(value){
			case "Listar": ListarCursos(request,response);break;
			case "Registrar": RegistrarCurso(request,response);break;
			case "PreRegistrar": PreRegistrarCurso(request,response);break;
			case "Buscar": BuscarCurso(request,response);break;
			case "Actualizar": ActualizarCurso(request,response);break;
			case "Borrar": BorrarCurso(request,response);break;
			default:break;
		}
		//System.out.println(value);
	}

	private void PreRegistrarCurso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoCarrera dao = new DaoCarrera();
		List<Carrera> carreras = dao.ListarCarrera(true);
		request.setAttribute("carreras", carreras);
		
		request.getRequestDispatcher("formularioCurso.jsp").forward(request, response);    
	}
	
    private void BorrarCurso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//instanciamos las clases
    	DaoCurso dao = new DaoCurso();

    	//Buscamos la info
    	int id = Integer.parseInt(request.getParameter("id"));
    	
    	//Eliminamos...
    	dao.EliminarCurso(id);
    	
    	//Mandamos la data
		request.setAttribute("mensaje", "Curso eliminado!");
		
		//Nos devolvemos al listado
		ListarCursos(request, response);
		
	}

	private void ActualizarCurso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//instanciamos las clases
    	DaoCurso dao = new DaoCurso();
    	Curso p = new Curso();
    	
    	//Recuperamos los daots
		p.setNombre(request.getParameter("nombre"));
		p.setCiclo(Integer.parseInt(request.getParameter("ciclo")));
		
		
		Carrera carrera = new Carrera();
		carrera.setIdcarrera(Integer.parseInt(request.getParameter("carrera")));
		p.setCarrera(carrera);
		
		p.setIdcurso(Integer.parseInt(request.getParameter("idCurso")));
		
		//Mandamos la data
		dao.ActualizarCurso(p);
		request.setAttribute("mensaje", "Curso actualizado!");
		
		//Nos devolvemos al listado
		ListarCursos(request, response);
	}

	private void BuscarCurso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//instanciamos las clases
    	DaoCurso dao = new DaoCurso();

    	//Buscamos la info
    	int id = Integer.parseInt(request.getParameter("id"));
    	Curso p = dao.BuscarCurso(id);
    	
    	//Enviamos la info
    	request.setAttribute("Curso", p);
		
    	//Buscamos la lista de carreras
    	DaoCarrera daoc = new DaoCarrera();
		List<Carrera> carreras = daoc.ListarCarrera(true);
		request.setAttribute("carreras", carreras);
    	
    	//Vamos al formulario
    	request.getRequestDispatcher("actualizarCurso.jsp").forward(request, response);
	}

	private void RegistrarCurso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//instanciamos las clases
    	DaoCurso dao = new DaoCurso();
    	Curso p = new Curso();
    	
		//Recuperamos los daots
		p.setNombre(request.getParameter("nombre"));
		p.setCiclo(Integer.parseInt(request.getParameter("ciclo")));
		
		Carrera carrera = new Carrera();
		carrera.setIdcarrera(Integer.parseInt(request.getParameter("carrera")));
		p.setCarrera(carrera);
		
		//Mandamos la data
		dao.RegistrarCurso(p);
		request.setAttribute("mensaje", "Curso registrado!");
		
		//Nos devolvemos al listado
		ListarCursos(request, response);
	}

	private void ListarCursos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//instanciamos el dao
    	DaoCurso dao = new DaoCurso();
		String trash = request.getParameter("trash");
		//request.setAttribute("mensaje", trash);
		
		Boolean activos = true;
    	if(trash!=null)  activos = false;
    	
    	//Obtenemos la data
    	List<Curso> listado = dao.ListarCurso(activos);

    	//La mandamos a la vista
    	request.setAttribute("listado", listado);
		request.getRequestDispatcher("listarCursos.jsp").forward(request, response);
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