package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import interfaces.IeUsuario;
import model.Usuario;


public class DaoUsuario implements IeUsuario {

	@Override
	public Usuario ValidarUsuario(Usuario u) {
		//conexión con unidad de persistencia
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("ProyectoGestionNotas");
		//gestionamos la entidad
		EntityManager em=conex.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		
		//aplicamos JPQL
		Query consulta = em.createQuery("select u from Usuario u "
				+ "where u.user=:x and u.password=:y",Usuario.class);
		//pasamos los parametros
		consulta.setParameter("x", u.getUser());
		consulta.setParameter("y", u.getPassword());
		
		String mensaje;
		Usuario user=null;
		//probamos 
		try{
			user=(Usuario) consulta.getSingleResult();
		}catch(Exception e){
			
		}
		//Cerramos
		em.close();
		return user;
	}

	@Override
	public void RegistrarUsuario(Usuario u) {
		//conexión con unidad de persistencia
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("ProyectoGestionNotas");
		//gestionamos la entidad
		EntityManager em=conex.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		
		//Mandamos el objeto
		em.persist(u);
		
		//Confirmamos 
		em.getTransaction().commit();
		//Cerramos
		em.close();
	}

	@Override
	public void EliminarUsuario(int id) {
		//conexión con unidad de persistencia
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("ProyectoGestionNotas");
		//gestionamos la entidad
		EntityManager em=conex.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		
		//Buscamos la info
		Usuario u = BuscarUsuario(id);
		u.setActivo(!u.getActivo());
		//Actualizamos el objeto
		em.merge(u);
		
		//Confirmamos 
		em.getTransaction().commit();
		//Cerramos
		em.close();

	}

	@Override
	public void ActualizarUsuario(Usuario u) {
		//conexión con unidad de persistencia
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("ProyectoGestionNotas");
		//gestionamos la entidad
		EntityManager em=conex.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		
		//Actualizamos el objeto
		em.merge(u);
		
		//Confirmamos 
		em.getTransaction().commit();
		//Cerramos
		em.close();

	}

	@Override
	public Usuario BuscarUsuario(int id) {
		//conexión con unidad de persistencia
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("ProyectoGestionNotas");
		//gestionamos la entidad
		EntityManager em=conex.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		
		//aplicamos JPQL
		Query consulta = em.createQuery("select u from Usuario u "
				+ "where u.idusuario=:x",Usuario.class);
		//pasamos los parametros
		consulta.setParameter("x", id);
		
		
		//String mensaje;
		Usuario user=null;
		//probamos 
		try{
			user=(Usuario) consulta.getSingleResult();
		}catch(Exception e){
			
		}
		//Cerramos
		em.close();
		return user;
	}

	@Override
	public List<Usuario> ListarUsuarios(Boolean activos) {
		//conexión con unidad de persistencia
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("ProyectoGestionNotas");
		//gestionamos la entidad
		EntityManager em=conex.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		
		//Solicitamos la busqueda
		Query consulta= em.createQuery("select u from Usuario u where u.activo=:x",Usuario.class);
		consulta.setParameter("x", activos);
		List<Usuario> lista = consulta.getResultList();
		//Confirmamos 
		em.getTransaction().commit();
		//Cerramos
		em.close();
		
		//Retornamos
		return lista;
	}

}
