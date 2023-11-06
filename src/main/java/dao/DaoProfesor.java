package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import interfaces.IeProfesor;
import model.Profesor;

public class DaoProfesor implements IeProfesor {

	@Override
	public void RegistrarProfesor(Profesor p) {
		//conexión con unidad de persistencia
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("ProyectoGestionNotas");
		//gestionamos la entidad
		EntityManager em=conex.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		
		//Ponemos los valores por defecto
		p.setActivo(true);
		p.getUsuario().setActivo(true);
		p.getUsuario().setRol("Profesor");
		
		//Mandamos los objetos
		em.persist(p.getUsuario());
		em.persist(p);
		
		//Confirmamos 
		em.getTransaction().commit();
		//Cerramos
		em.close();

	}

	@Override
	public void EliminarProfesor(int id) {
		//conexión con unidad de persistencia
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("ProyectoGestionNotas");
		//gestionamos la entidad
		EntityManager em=conex.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		
		//Buscamos la info
		Profesor u = BuscarProfesor(id);
		u.setActivo(!u.getActivo());
		
		//Eliminamos el usuario tambien
		DaoUsuario dao = new DaoUsuario(); 
		dao.EliminarUsuario(u.getUsuario().getIdusuario());
		
		//Actualizamos el objeto
		em.merge(u);
		
		//Confirmamos 
		em.getTransaction().commit();
		//Cerramos
		em.close();


	}

	@Override
	public void ActualizarProfesor(Profesor p) {
		//conexión con unidad de persistencia
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("ProyectoGestionNotas");
		//gestionamos la entidad
		EntityManager em=conex.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		
		//Ponemos los valores por defecto
		p.setActivo(true);
		p.getUsuario().setActivo(true);
		p.getUsuario().setRol("Profesor");
		
		//Actualizamos el usuario
		DaoUsuario dao = new DaoUsuario();
		dao.ActualizarUsuario(p.getUsuario());
		
		//Actualizamos el objeto
		p.setActivo(true);
		em.merge(p);
		
		//Confirmamos 
		em.getTransaction().commit();
		//Cerramos
		em.close();
	}

	@Override
	public Profesor BuscarProfesor(int id) {
		//conexión con unidad de persistencia
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("ProyectoGestionNotas");
		//gestionamos la entidad
		EntityManager em=conex.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		
		//aplicamos JPQL
		Query consulta = em.createQuery("select p from Profesor p "
				+ "where p.idprofesor=:x",Profesor.class);
		//pasamos los parametros
		consulta.setParameter("x", id);
		
		
		//String mensaje;
		Profesor profe=null;
		//probamos 
		try{
			profe=(Profesor) consulta.getSingleResult();
		}catch(Exception e){
			
		}
		//Cerramos
		em.close();
		return profe;
	}

	@Override
	public List<Profesor> ListarProfesor(Boolean activos) {
		//conexión con unidad de persistencia
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("ProyectoGestionNotas");
		//gestionamos la entidad
		EntityManager em=conex.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		
		//Solicitamos la busqueda
		Query consulta= em.createQuery("select u from Profesor u where u.activo=:x",Profesor.class);
		consulta.setParameter("x", activos);
		List<Profesor> lista = consulta.getResultList();
		//Confirmamos 
		em.getTransaction().commit();
		//Cerramos
		em.close();
		
		//Retornamos
		return lista;
	}

}
