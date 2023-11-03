package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the carrera database table.
 * 
 */
@Entity
@NamedQuery(name="Carrera.findAll", query="SELECT c FROM Carrera c")
public class Carrera implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcarrera;

	private String nombre;

	//bi-directional many-to-one association to Alumno
	@OneToMany(mappedBy="carrera")
	private List<Alumno> alumnos;

	//bi-directional many-to-one association to Curso
	@OneToMany(mappedBy="carrera")
	private List<Curso> cursos;

	public Carrera() {
	}

	public int getIdcarrera() {
		return this.idcarrera;
	}

	public void setIdcarrera(int idcarrera) {
		this.idcarrera = idcarrera;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Alumno> getAlumnos() {
		return this.alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public Alumno addAlumno(Alumno alumno) {
		getAlumnos().add(alumno);
		alumno.setCarrera(this);

		return alumno;
	}

	public Alumno removeAlumno(Alumno alumno) {
		getAlumnos().remove(alumno);
		alumno.setCarrera(null);

		return alumno;
	}

	public List<Curso> getCursos() {
		return this.cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Curso addCurso(Curso curso) {
		getCursos().add(curso);
		curso.setCarrera(this);

		return curso;
	}

	public Curso removeCurso(Curso curso) {
		getCursos().remove(curso);
		curso.setCarrera(null);

		return curso;
	}

}