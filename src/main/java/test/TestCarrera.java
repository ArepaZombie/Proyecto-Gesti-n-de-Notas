package test;

import model.Carrera;

import java.util.List;

import dao.DaoCarrera;

public class TestCarrera {
	public static void main(String[] args){
		Carrera c = new Carrera();
		DaoCarrera dao = new DaoCarrera();
		
		c.setNombre("Carrera de Prueba");
		
		//dao.RegistrarCarrera(c);
		//dao.EliminarCarrera(9);
		
		List<Carrera> lista = dao.ListarCarrera(true);
		
		for(Carrera car:lista){
			System.out.println(car.getIdcarrera()+"- "+car.getNombre());
		}
		
	}
}
