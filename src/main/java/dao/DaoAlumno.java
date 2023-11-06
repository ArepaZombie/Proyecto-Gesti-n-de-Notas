package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import interfaces.IeAlumno;
import model.Alumno;

public class DaoAlumno implements IeAlumno {

	@Override
	public void RegistrarAlumno(Alumno p) {
		//conexión con unidad de persistencia
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("ProyectoGestionNotas");
		//gestionamos la entidad
		EntityManager em=conex.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		
		//Ponemos los valores por defecto
		p.setActivo(true);
		p.getUsuario().setActivo(true);
		p.getUsuario().setRol("Alumno");
		
		//Mandamos los objetos
		em.persist(p.getUsuario());
		em.persist(p);
		
		//Confirmamos 
		em.getTransaction().commit();
		//Cerramos
		em.close();

	}

	@Override
	public void EliminarAlumno(int id) {
		//conexión con unidad de persistencia
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("ProyectoGestionNotas");
		//gestionamos la entidad
		EntityManager em=conex.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		
		//Buscamos la info
		Alumno u = BuscarAlumno(id);
		u.setActivo(!u.getActivo());
		//Actualizamos el objeto
		em.merge(u);
		
		//Eliminamos el usuario tambien
		DaoUsuario dao = new DaoUsuario(); 
		dao.EliminarUsuario(u.getUsuario().getIdusuario());
		
		//Confirmamos 
		em.getTransaction().commit();
		//Cerramos
		em.close();


	}

	@Override
	public void ActualizarAlumno(Alumno p) {
		//conexión con unidad de persistencia
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("ProyectoGestionNotas");
		//gestionamos la entidad
		EntityManager em=conex.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		
		//Ponemos los valores por defecto
		p.setActivo(true);
		p.getUsuario().setActivo(true);
		p.getUsuario().setRol("Alumno");
		
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
	public Alumno BuscarAlumno(int id) {
		//conexión con unidad de persistencia
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("ProyectoGestionNotas");
		//gestionamos la entidad
		EntityManager em=conex.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		
		//aplicamos JPQL
		Query consulta = em.createQuery("select p from Alumno p "
				+ "where p.idalumno=:x",Alumno.class);
		//pasamos los parametros
		consulta.setParameter("x", id);
		
		
		//String mensaje;
		Alumno profe=null;
		//probamos 
		try{
			profe=(Alumno) consulta.getSingleResult();
		}catch(Exception e){
			
		}
		//Cerramos
		em.close();
		return profe;
	}

	@Override
	public List<Alumno> ListarAlumno(Boolean activos) {
		//conexión con unidad de persistencia
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("ProyectoGestionNotas");
		//gestionamos la entidad
		EntityManager em=conex.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		
		//Solicitamos la busqueda
		Query consulta= em.createQuery("select u from Alumno u where u.activo=:x",Alumno.class);
		consulta.setParameter("x", activos);
		List<Alumno> lista = consulta.getResultList();
		//Confirmamos 
		em.getTransaction().commit();
		//Cerramos
		em.close();
		
		//Retornamos
		return lista;
	}

	@Override
	public List<Alumno> ListarAlumnoxSalon(int idsalon) {
		//conexión con unidad de persistencia
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("ProyectoGestionNotas");
		//gestionamos la entidad
		EntityManager em=conex.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		
		//Solicitamos la busqueda
		Query consulta= em.createQuery("select u from Alumno u "
				+ "join u.notas n "
				+ "join n.salon s "
				+ "where u.activo=true "
				+ "and s.idsalon=:x",Alumno.class);
		consulta.setParameter("x", idsalon);
		List<Alumno> lista = consulta.getResultList();
		//Confirmamos 
		em.getTransaction().commit();
		//Cerramos
		em.close();
		
		//Retornamos
		return lista;
	}

}
