package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the notas database table.
 * 
 */
@Entity
@Table(name="notas")
@NamedQuery(name="Nota.findAll", query="SELECT n FROM Nota n")
public class Nota implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private NotaPK id;

	private double nota1;

	private double nota2;

	private double nota3;

	//bi-directional many-to-one association to Alumno
	@ManyToOne
	@JoinColumn(name="IDALUMNO")
	private Alumno alumno;

	//bi-directional many-to-one association to Salon
	@ManyToOne
	@JoinColumn(name="IDSALON")
	private Salon salon;

	public Nota() {
	}

	public NotaPK getId() {
		return this.id;
	}

	public void setId(NotaPK id) {
		this.id = id;
	}

	public double getNota1() {
		return this.nota1;
	}

	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}

	public double getNota2() {
		return this.nota2;
	}

	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}

	public double getNota3() {
		return this.nota3;
	}

	public void setNota3(double nota3) {
		this.nota3 = nota3;
	}

	public Alumno getAlumno() {
		return this.alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Salon getSalon() {
		return this.salon;
	}

	public void setSalon(Salon salon) {
		this.salon = salon;
	}

}