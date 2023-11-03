package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the curso database table.
 * 
 */
@Entity
@NamedQuery(name="Curso.findAll", query="SELECT c FROM Curso c")
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcurso;

	private int ciclo;

	private String nombre;

	//bi-directional many-to-one association to Carrera
	@ManyToOne
	@JoinColumn(name="IDCARRERA")
	private Carrera carrera;

	//bi-directional many-to-one association to Salon
	@OneToMany(mappedBy="curso")
	private List<Salon> salons;

	public Curso() {
	}

	public int getIdcurso() {
		return this.idcurso;
	}

	public void setIdcurso(int idcurso) {
		this.idcurso = idcurso;
	}

	public int getCiclo() {
		return this.ciclo;
	}

	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Carrera getCarrera() {
		return this.carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public List<Salon> getSalons() {
		return this.salons;
	}

	public void setSalons(List<Salon> salons) {
		this.salons = salons;
	}

	public Salon addSalon(Salon salon) {
		getSalons().add(salon);
		salon.setCurso(this);

		return salon;
	}

	public Salon removeSalon(Salon salon) {
		getSalons().remove(salon);
		salon.setCurso(null);

		return salon;
	}

}