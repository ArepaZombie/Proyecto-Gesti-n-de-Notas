package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoSalon;
import dao.DaoNota;
import dao.DaoAlumno;
import model.Salon;
import model.Alumno;
import model.Nota;
import model.NotaPK;

/**
 * Servlet implementation class ControllerNota
 */
public class ControllerNotas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerNotas() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = request.getParameter("value");
		
		switch(value){
			case "Listar": ListarNotas(request,response);break;
			case "Alumno": ListarNotasxAlumno(request,response);break;
			case "Registrar": RegistrarNota(request,response);break;
			case "PreRegistrar": PreRegistrarNota(request,response);break;
			case "Buscar": BuscarNota(request,response);break;
			case "Actualizar": ActualizarNota(request,response);break;
			default:break;
		}
		//System.out.println(value);
	}

	private void ListarNotasxAlumno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//instanciamos el dao
    	DaoNota dao = new DaoNota();
    	int idalumno = Integer.parseInt(request.getParameter("id"));
    	
    	//Obtenemos la data
    	List<Nota> listado = dao.ListarNotasxAlumno(idalumno);

    	//La mandamos a la vista
    	request.setAttribute("listado", listado);
		request.getRequestDispatcher("listarNotas.jsp").forward(request, response);
	}


	private void PreRegistrarNota(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoSalon dao = new DaoSalon();
		List<Salon> salons = dao.ListarSalon(true);
		request.setAttribute("salones", salons);
		
		DaoAlumno daop = new DaoAlumno();
		List<Alumno> alumnoes = daop.ListarAlumno(true);
		request.setAttribute("alumnos", alumnoes);
		
		request.getRequestDispatcher("formularioNotas.jsp").forward(request, response);    
	}
	

	private void ActualizarNota(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//instanciamos las clases
    	DaoNota dao = new DaoNota();
    	Nota n = new Nota();
    	
    	//Recuperamos los datos
		NotaPK id = new NotaPK();
		id.setIdalumno(Integer.parseInt(request.getParameter("idalumno")));
		id.setIdsalon(Integer.parseInt(request.getParameter("idsalon")));
		n.setId(id);
		
		n.setNota1(Double.parseDouble(request.getParameter("nota1")));
		n.setNota2(Double.parseDouble(request.getParameter("nota2")));
		n.setNota3(Double.parseDouble(request.getParameter("nota3")));
		
		//Mandamos la data
		dao.ActualizarNota(n);
		request.setAttribute("mensaje", "Nota actualizado!");
		
		//Nos devolvemos al listado
    	request.getRequestDispatcher("ControllerNotas?value=Alumno&id="+id.getIdalumno()).forward(request, response);
	}

	private void BuscarNota(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//instanciamos las clases
    	DaoNota dao = new DaoNota();

    	//Buscamos la info
    	int idsalon = Integer.parseInt(request.getParameter("idsalon"));
    	int idalumno = Integer.parseInt(request.getParameter("idalumno"));
    	Nota p = dao.BuscarNota(idsalon,idalumno);
    	
    	//Enviamos la info
    	request.setAttribute("notas", p);
		
    	//Listas para los combos
    	DaoSalon daoc = new DaoSalon();
		List<Salon> salons = daoc.ListarSalon(true);
		request.setAttribute("salones", salons);
		
		DaoAlumno daop = new DaoAlumno();
		List<Alumno> alumnoes = daop.ListarAlumno(true);
		request.setAttribute("alumnos", alumnoes);
    	
    	//Vamos al formulario
    	request.getRequestDispatcher("actualizarNotas.jsp").forward(request, response);
	}

	private void RegistrarNota(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//instanciamos las clases
    	DaoNota dao = new DaoNota();
    	Nota p = new Nota();
    	NotaPK id = new NotaPK();
    	
    	//Recuperamos los daots
		id.setIdsalon(Integer.parseInt(request.getParameter("salon")));
		id.setIdalumno(Integer.parseInt(request.getParameter("alumno")));
		p.setId(id);
		
		//Mandamos la data
		String r = dao.RegistrarNota(p);
		String mensaje;
		
		if(r=="inscrito") mensaje="Alumno inscrito";
		else mensaje="El alumno ya estaba inscrito";
		
		request.setAttribute("mensaje", mensaje);
		
		//Nos devolvemos al listado
		ListarNotas(request, response);
	}

	private void ListarNotas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//instanciamos el dao
    	DaoNota dao = new DaoNota();

    	//Obtenemos la data
    	List<Nota> listado = dao.ListarNotas();

    	//La mandamos a la vista
    	request.setAttribute("listado", listado);
		request.getRequestDispatcher("listarNotas.jsp").forward(request, response);
	}


    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
