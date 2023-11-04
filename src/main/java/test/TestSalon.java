package test;

import model.Salon;
import model.Alumno;
import model.Carrera;
import model.Curso;
import model.Profesor;

import java.util.List;

import dao.DaoAlumno;
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
		//dao.EliminarSalon(963);
		
		
		/*
		//Necesito crear salones para todos los alumnos entonces hice este codigo
		DaoAlumno daoalu = new DaoAlumno();
		List<Alumno> alumnos = daoalu.ListarAlumno(true);
		
		for (Alumno alumno:alumnos){
			Salon salon = new Salon();
			int ciclo = alumno.getCiclo();
			String turno = alumno.getTurno();
			Carrera carrera = alumno.getCarrera();
			
			salon.setTurno(turno);
			
			System.out.println("-" + ciclo + " " + turno + " " + carrera.getNombre());
			List<Curso> cursos = carrera.getCursos();
			for (Curso curso:cursos){
				if(curso.getCiclo()==ciclo){ 
					int numero = (int)(Math.random()*9+1);
					System.out.println("- "+curso.getNombre()+" ----"+numero);
					
					salon.setCurso(curso);
					
					Profesor profesor = new Profesor();
					profesor.setIdprofesor(numero);
					salon.setProfesor(profesor);
					
					dao.RegistrarSalon(salon);
					System.out.println("Salon creado!!");
				}
			}
			
			System.out.println("----------------------------------------");
			
			
		}
		
	*/
		
		dao.BuscarSalon(965);
		List<Salon> lista = dao.ListarSalon(true);
		
		for(Salon sal:lista){
			System.out.println(sal.getIdsalon()+"- "+sal.getCurso().getNombre()+" --- "+
		sal.getProfesor().getApellido());
		}

	}

}
