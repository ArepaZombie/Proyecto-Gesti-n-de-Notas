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
		
		return user;
	}

	@Override
	public void RegistrarUsuario(Usuario u) {
		// TODO Auto-generated method stub

	}

	@Override
	public void EliminarUsuario(Usuario u) {
		// TODO Auto-generated method stub

	}

	@Override
	public void ActualizarUsuario(Usuario u) {
		// TODO Auto-generated method stub

	}

	@Override
	public Usuario BuscarUsuario(Usuario u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> ListarUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

}
