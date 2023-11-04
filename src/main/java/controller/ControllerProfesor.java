package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoProfesor;
import model.Profesor;
import model.Usuario;

/**
 * Servlet implementation class ControllerProfesor
 */
public class ControllerProfesor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerProfesor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = request.getParameter("value");
		
		switch(value){
		case "Listar": ListarProfesores(request,response);break;
		case "Registrar": RegistrarProfesor(request,response);break;
		case "Buscar": BuscarProfesor(request,response);break;
		case "Actualizar": ActualizarProfesor(request,response);break;
		case "Borrar": BorrarProfesor(request,response);break;
		default:break;
		}
		//System.out.println(value);
	}

    
    private void BorrarProfesor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//instanciamos las clases
    	DaoProfesor dao = new DaoProfesor();

    	//Buscamos la info
    	int id = Integer.parseInt(request.getParameter("id"));
    	
    	//Eliminamos...
    	dao.EliminarProfesor(id);
    	
    	//Mandamos la data
		request.setAttribute("mensaje", "Profesor eliminado!");
		
		//Nos devolvemos al listado
		ListarProfesores(request, response);
		
	}

	private void ActualizarProfesor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//instanciamos las clases
    	DaoProfesor dao = new DaoProfesor();
    	Profesor p = new Profesor();
    	Usuario u = new Usuario();
    	
		//Recuperamos los daots
		String user = request.getParameter("user");
		u.setUser(user);
		
		String password = request.getParameter("password");
		u.setPassword(password);
		
		int idusuario = Integer.parseInt(request.getParameter("idusuario"));
		u.setIdusuario(idusuario);
		p.setUsuario(u);
		
		p.setIdprofesor(Integer.parseInt(request.getParameter("idprofesor")));
		p.setNombre(request.getParameter("nombre"));
		p.setApellido(request.getParameter("apellido"));
		p.setDni(request.getParameter("dni"));
		
		
		//Mandamos la data
		dao.ActualizarProfesor(p);
		request.setAttribute("mensaje", "Profesor actualizado!");
		
		//Nos devolvemos al listado
		ListarProfesores(request, response);
		
	}

	private void BuscarProfesor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//instanciamos las clases
    	DaoProfesor dao = new DaoProfesor();

    	//Buscamos la info
    	int id = Integer.parseInt(request.getParameter("id"));
    	Profesor p = dao.BuscarProfesor(id);
    	
    	//Enviamos la info
    	request.setAttribute("profesor", p);
		
    	//Vamos al formulario
    	request.getRequestDispatcher("actualizarProfesor.jsp").forward(request, response);
	}

	private void RegistrarProfesor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//instanciamos las clases
    	DaoProfesor dao = new DaoProfesor();
    	Profesor p = new Profesor();
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
		
		
		//Mandamos la data
		dao.RegistrarProfesor(p);
		request.setAttribute("mensaje", "Profesor registrado!");
		
		//Nos devolvemos al listado
		ListarProfesores(request, response);
	}

	private void ListarProfesores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//instanciamos el dao
    	DaoProfesor dao = new DaoProfesor();
		String trash = request.getParameter("trash");
		//request.setAttribute("mensaje", trash);
		
		Boolean activos = true;
    	if(trash!=null)  activos = false;
    	
    	//Obtenemos la data
    	List<Profesor> listado = dao.ListarProfesor(activos);

    	//La mandamos a la vista
    	request.setAttribute("listado", listado);
		request.getRequestDispatcher("listarProfesores.jsp").forward(request, response);
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
