package test;

import model.Nota;
import model.Salon;
import model.Alumno;

import java.util.List;

import dao.DaoNota;


public class TestNotas {

	public static void main(String[] args) {
		Nota n = new Nota();
		
		Salon s = new Salon();
		s.setIdsalon(966);
		
		Alumno a = new Alumno();
		a.setIdalumno(21);
		
		
		n.setAlumno(a);
		n.setSalon(s);
		n.setNota1(13);
		
		DaoNota dao = new DaoNota();
		//dao.RegistrarNota(n);
		//dao.BuscarNota(965,21);
		//dao.ActualizarNota(n);
		
		List<Nota> notas = dao.ListarNotas();
		
		for(Nota nota:notas){
			System.out.print("-");
		}
		
		
		
	}

}
