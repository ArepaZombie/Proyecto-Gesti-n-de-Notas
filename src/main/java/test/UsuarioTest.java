package test;

import dao.DaoUsuario;
import model.Usuario;

public class UsuarioTest {
	public static void main(String[] args){
		Usuario usuario = new Usuario();
		DaoUsuario crud = new DaoUsuario();
		
		//asignamos valores
		usuario.setUser("profesor1");
		usuario.setPassword("password2");
		
		//validamos al usuario
		Usuario respuesta = crud.ValidarUsuario(usuario);
		
		if(respuesta != null){
			System.out.println("- " + respuesta.getIdusuario());
			System.out.println("- " + respuesta.getRol());
		}
		else System.out.println(":c");
		
		
	}
}
