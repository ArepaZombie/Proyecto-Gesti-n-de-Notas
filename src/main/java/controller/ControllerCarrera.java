package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoCarrera;
import model.Carrera;

/**
 * Servlet implementation class ControllerCarrera
 */
public class ControllerCarrera extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerCarrera() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = request.getParameter("value");
		
		switch(value){
			case "Listar": ListarCarreras(request,response);break;
			case "Registrar": RegistrarCarrera(request,response);break;
			case "Buscar": BuscarCarrera(request,response);break;
			case "Actualizar": ActualizarCarrera(request,response);break;
			case "Borrar": BorrarCarrera(request,response);break;
			default:break;
		}
		//System.out.println(value);
	}

    
    private void BorrarCarrera(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//instanciamos las clases
    	DaoCarrera dao = new DaoCarrera();

    	//Buscamos la info
    	int id = Integer.parseInt(request.getParameter("id"));
    	
    	//Eliminamos...
    	dao.EliminarCarrera(id);
    	
    	//Mandamos la data
		request.setAttribute("mensaje", "Carrera eliminado!");
		
		//Nos devolvemos al listado
		ListarCarreras(request, response);
		
	}

	private void ActualizarCarrera(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//instanciamos las clases
    	DaoCarrera dao = new DaoCarrera();
    	Carrera p = new Carrera();
    	
		p.setIdcarrera(Integer.parseInt(request.getParameter("idcarrera")));
		p.setNombre(request.getParameter("nombre"));
		
		//Mandamos la data
		dao.ActualizarCarrera(p);
		request.setAttribute("mensaje", "Carrera actualizada!");
		
		//Nos devolvemos al listado
		ListarCarreras(request, response);
		
	}

	private void BuscarCarrera(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//instanciamos las clases
    	DaoCarrera dao = new DaoCarrera();

    	//Buscamos la info
    	int id = Integer.parseInt(request.getParameter("id"));
    	Carrera p = dao.BuscarCarrera(id);
    	
    	//Enviamos la info
    	request.setAttribute("carrera", p);
		
    	//Vamos al formulario
    	request.getRequestDispatcher("actualizarCarrera.jsp").forward(request, response);
	}

	private void RegistrarCarrera(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//instanciamos las clases
    	DaoCarrera dao = new DaoCarrera();
    	Carrera p = new Carrera();
		
		p.setNombre(request.getParameter("nombre"));
		
		//Mandamos la data
		dao.RegistrarCarrera(p);
		request.setAttribute("mensaje", "Carrera registrada!");
		
		//Nos devolvemos al listado
		ListarCarreras(request, response);
	}

	private void ListarCarreras(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//instanciamos el dao
    	DaoCarrera dao = new DaoCarrera();
		String trash = request.getParameter("trash");
		//request.setAttribute("mensaje", trash);
		
		Boolean activos = true;
    	if(trash!=null)  activos = false;
    	
    	//Obtenemos la data
    	List<Carrera> listado = dao.ListarCarrera(activos);

    	//La mandamos a la vista
    	request.setAttribute("listado", listado);
		request.getRequestDispatcher("listarCarreras.jsp").forward(request, response);
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
