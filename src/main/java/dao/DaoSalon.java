package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import interfaces.IeSalon;
import model.Salon;
import model.Profesor;
import model.Curso;

import dao.DaoProfesor;
import dao.DaoCurso;

public class DaoSalon implements IeSalon {

	@Override
	public void RegistrarSalon(Salon c) {
		//conexión con unidad de persistencia
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("ProyectoGestionNotas");
		//gestionamos la entidad
		EntityManager em=conex.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();

		//Buscamos la info de los profesores y la carrera
		DaoProfesor daoprofe = new DaoProfesor();
		DaoCurso daocurso = new DaoCurso();
		
		Profesor profe = daoprofe.BuscarProfesor(c.getProfesor().getIdprofesor());
		Curso curso = daocurso.BuscarCurso(c.getCurso().getIdcurso()) ;
		
		//Mandamos los objetos
		c.setActivo(true);
		em.persist(c);
		
		//Confirmamos 
		em.getTransaction().commit();
		//Cerramos
		em.close();

	}

	@Override
	public void EliminarSalon(int id) {
		//conexión con unidad de persistencia
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("ProyectoGestionNotas");
		//gestionamos la entidad
		EntityManager em=conex.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		
		//Buscamos la info
		Salon u = BuscarSalon(id);
		u.setActivo(!u.getActivo());
		//Actualizamos el objeto
		em.merge(u);
		
		//Confirmamos 
		em.getTransaction().commit();
		//Cerramos
		em.close();


	}

	@Override
	public void ActualizarSalon(Salon c) {
		//conexión con unidad de persistencia
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("ProyectoGestionNotas");
		//gestionamos la entidad
		EntityManager em=conex.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		
		//Actualizamos el objeto
		c.setActivo(true);
		em.merge(c);
		
		//Confirmamos 
		em.getTransaction().commit();
		//Cerramos
		em.close();
	}

	@Override
	public Salon BuscarSalon(int id) {
		//conexión con unidad de persistencia
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("ProyectoGestionNotas");
		//gestionamos la entidad
		EntityManager em=conex.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		
		//aplicamos JPQL
		Query consulta = em.createQuery("select p from Salon p "
				+ "where p.idsalon=:x",Salon.class);
		//pasamos los parametros
		consulta.setParameter("x", id);
		
		
		//String mensaje;
		Salon profe=null;
		//probamos 
		try{
			profe=(Salon) consulta.getSingleResult();
		}catch(Exception e){
			
		}
		//Cerramos
		em.close();
		return profe;
	}

	@Override
	public List<Salon> ListarSalon(Boolean activos) {
		//conexión con unidad de persistencia
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("ProyectoGestionNotas");
		//gestionamos la entidad
		EntityManager em=conex.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		
		//Solicitamos la busqueda
		Query consulta= em.createQuery("select u from Salon u where u.activo=:x",Salon.class);
		consulta.setParameter("x", activos);
		List<Salon> lista = consulta.getResultList();
		//Confirmamos 
		em.getTransaction().commit();
		//Cerramos
		em.close();
		
		//Retornamos
		return lista;
	}

	@Override
	public List<Salon> ListarSalonesDisponibles(String turno, int ciclo, int idcarrera) {
		//conexión con unidad de persistencia
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("ProyectoGestionNotas");
		//gestionamos la entidad
		EntityManager em=conex.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		
		//Solicitamos la busqueda
		Query consulta= em.createQuery("SELECT s " +
				"FROM Salon s " +
				"JOIN s.curso c " +
				"JOIN c.carrera carrera " +
				"WHERE c.ciclo = :y " +
				"AND carrera.idcarrera = :z "
				+ "AND s.turno=:x"
				,Salon.class);
		consulta.setParameter("x", turno);
		consulta.setParameter("y", ciclo);
		consulta.setParameter("z", idcarrera);
		List<Salon> lista = consulta.getResultList();
		//Confirmamos 
		em.getTransaction().commit();
		//Cerramos
		em.close();
		
		//Retornamos
		return lista;
	}


}