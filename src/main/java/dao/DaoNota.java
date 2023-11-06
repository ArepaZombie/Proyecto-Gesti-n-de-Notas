package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import interfaces.IeNotas;
import model.Alumno;
import model.Nota;
import model.Salon;

public class DaoNota implements IeNotas {

	@Override
	public void RegistrarNota(Nota c) {
		//conexión con unidad de persistencia
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("ProyectoGestionNotas");
		//gestionamos la entidad
		EntityManager em=conex.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();

		//Buscamos la info del salon y el alumno
		DaoSalon dao= new DaoSalon();
		DaoAlumno daoa= new DaoAlumno();
		Salon salon = dao.BuscarSalon(c.getId().getIdsalon());
		Alumno alumno = daoa.BuscarAlumno(c.getId().getIdalumno());
		
		c.setSalon(salon);
		c.setAlumno(alumno);
		
		/*
		c.setNota1(0);
		c.setNota2(0);
		c.setNota3(0);
		 */
		
		//Mandamos los objetos
		em.persist(c);
		
		//Confirmamos 
		em.getTransaction().commit();
		//Cerramos
		em.close();

	}


	@Override
	public void ActualizarNota(Nota c) {
		//conexión con unidad de persistencia
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("ProyectoGestionNotas");
		//gestionamos la entidad
		EntityManager em=conex.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		
		//Buscamos la info del salon y el alumno
		DaoSalon dao= new DaoSalon();
		DaoAlumno daoa= new DaoAlumno();
		c.setSalon(dao.BuscarSalon(c.getId().getIdsalon()));
		c.setAlumno(daoa.BuscarAlumno(c.getId().getIdalumno()));
		
		//Actualizamos el objeto
		em.merge(c);
		
		//Confirmamos 
		em.getTransaction().commit();
		//Cerramos
		em.close();
	}

	@Override
	public Nota BuscarNota(int idsalon,int idalumno) {
		//conexión con unidad de persistencia
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("ProyectoGestionNotas");
		//gestionamos la entidad
		EntityManager em=conex.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		
		//aplicamos JPQL
		Query consulta = em.createQuery("select p from Nota p "
				+ "join p.salon s "
				+ "join p.alumno a  "
				+ "where s.idsalon=:x and a.idalumno=:y",Nota.class);
		//pasamos los parametros
		consulta.setParameter("x", idsalon);
		consulta.setParameter("y", idalumno);
		
		
		//String mensaje;
		Nota nota=null;
		//probamos 
		try{
			nota=(Nota) consulta.getSingleResult();
		}catch(Exception e){
			
		}
		//Cerramos
		em.close();
		return nota;
	}

	@Override
	public List<Nota> ListarNotas() {
		//conexión con unidad de persistencia
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("ProyectoGestionNotas");
		//gestionamos la entidad
		EntityManager em=conex.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		
		//Solicitamos la busqueda
		Query consulta= em.createQuery("select u from Nota u",Nota.class);
		List<Nota> lista = consulta.getResultList();
		//Confirmamos 
		em.getTransaction().commit();
		//Cerramos
		em.close();
		
		//Retornamos
		return lista;
	}


	@Override
	public List<Nota> ListarNotasxAlumno(int idalumno) {
		//conexión con unidad de persistencia
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("ProyectoGestionNotas");
		//gestionamos la entidad
		EntityManager em=conex.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		
		//aplicamos JPQL
		Query consulta = em.createQuery("select p from Nota p "
				+ "join p.alumno a  "
				+ "where a.idalumno=:y",Nota.class);
		//pasamos los parametros
		consulta.setParameter("y", idalumno);
		
		
		//String mensaje;
		List<Nota> lista=null;
		//probamos 
		try{
			lista=(List<Nota>) consulta.getResultList();
		}catch(Exception e){
			
		}
		//Cerramos
		em.close();
		return lista;
	}

}
