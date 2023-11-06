package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoUsuario;
import model.Usuario;

/**
 * Servlet implementation class ControllerUsuario
 */
public class ControllerUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = request.getParameter("value");
		
		switch(value){
		case "Validar": ValidarUsuario(request,response);break;
		default:break;
		}
		//System.out.println(value);
	}

	private void ValidarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Instanciamos
		Usuario u = new Usuario();
		DaoUsuario dao = new DaoUsuario();
		
		//Recuperamos los daots
		String user = request.getParameter("user");
		u.setUser(user);
		
		String password = request.getParameter("password");
		u.setPassword(password);
		
		
		//Los mandamos
		Usuario respuesta = dao.ValidarUsuario(u);
		String next = "/index.jsp"; 
		
		//Revisamos
		if(respuesta!=null & respuesta.getRol()!=null){
			switch(respuesta.getRol()){
				case "Admin":next = "/indexAdmin.jsp";break;
				case "Profesor":next = "ControllerProfesor?value=Sesion&id="+respuesta.getProfesor().getIdprofesor();break;
				case "Alumno":next = "ControllerAlumno?value=Sesion&id="+respuesta.getAlumno().getIdalumno();break;
				default:break;
			}
			
		}
		else request.setAttribute("mensaje", "Datos incorrectos");
		
		request.setAttribute("usuario", u);
		request.getRequestDispatcher(next).forward(request, response);
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
