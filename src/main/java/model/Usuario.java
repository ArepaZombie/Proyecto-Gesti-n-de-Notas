package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idusuario;

	private String password;

	private String rol;

	private String user;

	//bi-directional many-to-one association to Alumno
	@OneToMany(mappedBy="usuario")
	private List<Alumno> alumnos;

	//bi-directional many-to-one association to Profesor
	@OneToMany(mappedBy="usuario")
	private List<Profesor> profesors;

	public Usuario() {
	}

	public int getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return this.rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public List<Alumno> getAlumnos() {
		return this.alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public Alumno addAlumno(Alumno alumno) {
		getAlumnos().add(alumno);
		alumno.setUsuario(this);

		return alumno;
	}

	public Alumno removeAlumno(Alumno alumno) {
		getAlumnos().remove(alumno);
		alumno.setUsuario(null);

		return alumno;
	}

	public List<Profesor> getProfesors() {
		return this.profesors;
	}

	public void setProfesors(List<Profesor> profesors) {
		this.profesors = profesors;
	}

	public Profesor addProfesor(Profesor profesor) {
		getProfesors().add(profesor);
		profesor.setUsuario(this);

		return profesor;
	}

	public Profesor removeProfesor(Profesor profesor) {
		getProfesors().remove(profesor);
		profesor.setUsuario(null);

		return profesor;
	}

}