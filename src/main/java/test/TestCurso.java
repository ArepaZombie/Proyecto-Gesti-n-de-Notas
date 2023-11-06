package test;

import model.Curso;
import model.Carrera;

import java.util.List;

import dao.DaoCurso;

public class TestCurso {
	public static void main(String[] args){
		Curso c = new Curso();
		Carrera carr = new Carrera();
		DaoCurso dao = new DaoCurso();
		
		
		c.setNombre("Curso de Prueba Editado");
		c.setCiclo(5);
		
		carr.setIdcarrera(9);
		c.setCarrera(carr);
		
		//dao.RegistrarCurso(c);
		
		//dao.EliminarCurso(248);
		//dao.ActualizarCurso(c);
		
		//List<Curso> lista = dao.ListarCurso(true);
		List<Curso> lista = dao.ListarCursoxCarrera(1);
		for(Curso cur:lista){
			System.out.println(cur.getIdcurso()+"- "+cur.getNombre()+" de "+cur.getCarrera().getNombre());
		}
		
	}
}
