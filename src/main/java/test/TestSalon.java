package test;

import model.Salon;
import model.Curso;
import model.Profesor;

import java.util.List;

import dao.DaoSalon;

public class TestSalon {

	public static void main(String[] args) {
		Salon s = new Salon();
		s.setTurno("Tarde");
		
		Curso c = new Curso();
		c.setIdcurso(250);
		s.setCurso(c);
		
		Profesor p = new Profesor();
		p.setIdprofesor(9);
		s.setProfesor(p);
		
		DaoSalon dao = new DaoSalon();
		//dao.RegistrarSalon(s);
		//s.setIdsalon(964);
		//dao.ActualizarSalon(s);
		dao.EliminarSalon(963);
		
		List<Salon> lista = dao.ListarSalon(true);
		
		for(Salon sal:lista){
			System.out.println(sal.getIdsalon()+"- "+sal.getCurso().getNombre()+" --- "+
		sal.getProfesor().getApellido());
		}

	}

}
