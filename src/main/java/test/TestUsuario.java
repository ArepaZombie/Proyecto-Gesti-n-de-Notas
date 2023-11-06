package test;

import java.util.List;

import dao.DaoUsuario;
import model.Usuario;

public class TestUsuario {
	public static void main(String[] args){
		Usuario usuario = new Usuario();
		DaoUsuario crud = new DaoUsuario();
		
		//asignamos valores
		usuario.setUser("raven");
		usuario.setPassword("nevermore");
		
		//Profesor profesor = new Profesor();
		//usuario.setProfesor(profesor);
		
		
		//validamos al usuario
		Usuario respuesta = crud.ValidarUsuario(usuario);
		
		if(respuesta != null){
			System.out.println("- " + respuesta.getIdusuario());
			System.out.println("- " + respuesta.getRol());
		}
		else System.out.println(":c");
		
		
		//Registro de usuario
		//crud.RegistrarUsuario(usuario);
		
		
		//Editar usuario
		usuario.setIdusuario(41);
		usuario.setRol("Admin");
		//usuario.setActivo(true);
		//crud.ActualizarUsuario(usuario);
		
		//Borrar usuario
		//crud.EliminarUsuario(10);
		
		//Usuario u = crud.BuscarUsuario(10);
		
		List<Usuario> lista = crud.ListarUsuarios(true);
		
		System.out.println("----------------------------------------------------------------");
		for(Usuario u:lista){
			//System.out.println("- "+u.getRol());
			if(u.getProfesor()!=null)
				System.out.println("- "+u.getRol()+": "+u.getProfesor().getNombre()+" "+u.getProfesor().getApellido());
			else if(u.getAlumno()!=null)
				System.out.println("- "+u.getRol()+": "+u.getAlumno().getNombre()+" "+u.getAlumno().getApellido());
		};
		
		
	}
}
