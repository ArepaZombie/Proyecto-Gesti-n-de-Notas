package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import interfaces.IeCurso;
import model.Curso;
import model.Carrera;

import dao.DaoCarrera;

public class DaoCurso implements IeCurso {

	@Override
	public void RegistrarCurso(Curso c) {
		//conexión con unidad de persistencia
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("ProyectoGestionNotas");
		//gestionamos la entidad
		EntityManager em=conex.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();

		//Buscamos la info de la carrera
		DaoCarrera dao= new DaoCarrera();
		c.setCarrera(dao.BuscarCarrera(c.getCarrera().getIdcarrera()));
		
		//Mandamos los objetos
		c.setActivo(true);
		em.persist(c);
		
		//Confirmamos 
		em.getTransaction().commit();
		//Cerramos
		em.close();

	}

	@Override
	public void EliminarCurso(int id) {
		//conexión con unidad de persistencia
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("ProyectoGestionNotas");
		//gestionamos la entidad
		EntityManager em=conex.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		
		//Buscamos la info
		Curso u = BuscarCurso(id);
		u.setActivo(!u.getActivo());
		//Actualizamos el objeto
		em.merge(u);
		
		//Confirmamos 
		em.getTransaction().commit();
		//Cerramos
		em.close();


	}

	@Override
	public void ActualizarCurso(Curso c) {
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
	public Curso BuscarCurso(int id) {
		//conexión con unidad de persistencia
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("ProyectoGestionNotas");
		//gestionamos la entidad
		EntityManager em=conex.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		
		//aplicamos JPQL
		Query consulta = em.createQuery("select p from Curso p "
				+ "where p.idcurso=:x",Curso.class);
		//pasamos los parametros
		consulta.setParameter("x", id);
		
		
		//String mensaje;
		Curso profe=null;
		//probamos 
		try{
			profe=(Curso) consulta.getSingleResult();
		}catch(Exception e){
			
		}
		//Cerramos
		em.close();
		return profe;
	}

	@Override
	public List<Curso> ListarCurso(Boolean activos) {
		//conexión con unidad de persistencia
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("ProyectoGestionNotas");
		//gestionamos la entidad
		EntityManager em=conex.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		
		//Solicitamos la busqueda
		Query consulta= em.createQuery("select u from Curso u where u.activo=:x",Curso.class);
		consulta.setParameter("x", activos);
		List<Curso> lista = consulta.getResultList();
		//Confirmamos 
		em.getTransaction().commit();
		//Cerramos
		em.close();
		
		//Retornamos
		return lista;
	}

	@Override
	public List<Curso> ListarCursoxCarrera(int idcarrera) {
		//conexión con unidad de persistencia
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("ProyectoGestionNotas");
		//gestionamos la entidad
		EntityManager em=conex.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		
		//Solicitamos la busqueda
		Query consulta= em.createQuery("select u from Curso u "
				+ "JOIN u.carrera c "
				+ "where u.activo=true "
				+ "and c.idcarrera=:x",Curso.class);
		consulta.setParameter("x", idcarrera);
		List<Curso> lista = consulta.getResultList();
		//Confirmamos 
		em.getTransaction().commit();
		//Cerramos
		em.close();
		
		//Retornamos
		return lista;
	}

}
