package test;

import model.Alumno;
import model.Nota;
import model.Salon;
import model.Usuario;

import java.util.List;

import dao.DaoAlumno;
import dao.DaoNota;
import dao.DaoSalon;

public class TestAlumno {
	public static void main(String[] args){
		Alumno p = new Alumno();
		DaoAlumno dao = new DaoAlumno();
		
		p.setNombre("Chapulin");
		p.setApellido("Colorado");
		p.setDni("789345");
		
		//Para crear un profe es necesario crear un usuario
		Usuario u = new Usuario();
		//u.setIdusuario(41);
		u.setUser("chanfle");
		u.setPassword("chanfle");
		//u.setRol("Alumno");
		
		p.setUsuario(u);
		
		//dao.RegistrarAlumno(p);
		//dao.EliminarAlumno(10);
		
		List<Alumno> lista = dao.ListarAlumnoxSalon(1006);
		
		for(Alumno a:lista){
			System.out.print("-");
		}
		
		/*
		//Inscribiendo a todos los alumnos
		List<Alumno> lista = dao.ListarAlumno(true);
		DaoSalon daosalon = new DaoSalon();
		DaoNota daonota = new DaoNota();
		
		for(Alumno pro:lista){
			System.out.println(pro.getIdalumno()+"- "+pro.getApellido()+" "+pro.getNombre());
			List<Salon> salones = daosalon.ListarSalonesDisponibles(pro.getTurno(), pro.getCiclo(), pro.getCarrera().getIdcarrera());
			if(salones!=null){
				for(Salon sal:salones){
					System.out.println(sal.getIdsalon()+" - "+sal.getCurso().getNombre());
					Nota nota = new Nota();
					
					nota.setAlumno(pro);
					nota.setSalon(sal);
					
					daonota.RegistrarNota(nota);
					
					System.out.println("Registrado");
				}
			}
		}
		
		
		*/
		
		
	}
}
