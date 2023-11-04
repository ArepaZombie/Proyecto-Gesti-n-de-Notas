package test;

import model.Alumno;
import model.Salon;
import model.Usuario;

import java.util.List;

import dao.DaoAlumno;
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
		
		
		List<Alumno> lista = dao.ListarAlumno(true);
		DaoSalon daosalon = new DaoSalon();
		
		for(Alumno pro:lista){
			System.out.println(pro.getIdalumno()+"- "+pro.getApellido()+" "+pro.getNombre());
			List<Salon> salones = daosalon.ListarSalonesDisponibles(pro.getTurno(), pro.getCiclo(), pro.getCarrera().getIdcarrera());
			if(salones!=null){
				for(Salon sal:salones){
					System.out.println(sal.getIdsalon()+" - "+sal.getCurso().getNombre());
				}
			}
		}
		
		
		
		
		
	}
}
