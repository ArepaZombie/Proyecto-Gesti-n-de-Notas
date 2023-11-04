package test;

import model.Profesor;
import model.Salon;
import model.Usuario;

import java.util.List;

import dao.DaoProfesor;

public class TestProfesor {
	public static void main(String[] args){
		Profesor p = new Profesor();
		DaoProfesor dao = new DaoProfesor();
		
		p.setNombre("Sharon");
		p.setApellido("Rodriguez");
		p.setDni("12345678");
		
		//Para crear un profe es necesario crear un usuario
		Usuario u = new Usuario();
		//u.setIdusuario(41);
		u.setUser("shaome");
		u.setPassword("1234");
		//u.setRol("Profesor");
		
		p.setUsuario(u);
		
		//dao.RegistrarProfesor(p);
		//dao.EliminarProfesor(12);
		
		
		List<Profesor> lista = dao.ListarProfesor(true);
		
		for(Profesor pro:lista){
			List<Salon> salones = pro.getSalons();
			System.out.println("---"+pro.getApellido()+"---");
			for(Salon salon:salones){
				System.out.println(salon.getIdsalon()+" - "+salon.getCurso().getNombre());
			}
			System.out.println("----------------------");
		}
		
		
	}
}
