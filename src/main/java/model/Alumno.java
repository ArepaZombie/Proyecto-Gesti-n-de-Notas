package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the alumno database table.
 * 
 */
@Entity
@NamedQuery(name="Alumno.findAll", query="SELECT a FROM Alumno a")
public class Alumno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idalumno;

	private String apellido;

	private int ciclo;

	private String dni;

	private String nombre;

	private String turno;

	//bi-directional many-to-one association to Carrera
	@ManyToOne
	@JoinColumn(name="IDCARRERA")
	private Carrera carrera;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="IDUSUARIO")
	private Usuario usuario;

	//bi-directional many-to-one association to Nota
	@OneToMany(mappedBy="alumno")
	private List<Nota> notas;

	public Alumno() {
	}

	public int getIdalumno() {
		return this.idalumno;
	}

	public void setIdalumno(int idalumno) {
		this.idalumno = idalumno;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getCiclo() {
		return this.ciclo;
	}

	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTurno() {
		return this.turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public Carrera getCarrera() {
		return this.carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Nota> getNotas() {
		return this.notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	public Nota addNota(Nota nota) {
		getNotas().add(nota);
		nota.setAlumno(this);

		return nota;
	}

	public Nota removeNota(Nota nota) {
		getNotas().remove(nota);
		nota.setAlumno(null);

		return nota;
	}

}