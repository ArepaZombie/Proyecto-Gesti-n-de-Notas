package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the salon database table.
 * 
 */
@Entity
@NamedQuery(name="Salon.findAll", query="SELECT s FROM Salon s")
public class Salon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idsalon;

	private Boolean activo;

	private String turno;

	//bi-directional many-to-one association to Nota
	@OneToMany(mappedBy="salon")
	private List<Nota> notas;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumn(name="IDCURSO")
	private Curso curso;

	//bi-directional many-to-one association to Profesor
	@ManyToOne
	@JoinColumn(name="IDPROFESOR")
	private Profesor profesor;

	public Salon() {
	}

	public int getIdsalon() {
		return this.idsalon;
	}

	public void setIdsalon(int idsalon) {
		this.idsalon = idsalon;
	}

	public Boolean getActivo() {
		return this.activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getTurno() {
		return this.turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public List<Nota> getNotas() {
		return this.notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	public Nota addNota(Nota nota) {
		getNotas().add(nota);
		nota.setSalon(this);

		return nota;
	}

	public Nota removeNota(Nota nota) {
		getNotas().remove(nota);
		nota.setSalon(null);

		return nota;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Profesor getProfesor() {
		return this.profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

}