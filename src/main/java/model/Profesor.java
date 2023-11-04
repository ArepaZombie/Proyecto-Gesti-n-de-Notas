package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the profesor database table.
 * 
 */
@Entity
@NamedQuery(name="Profesor.findAll", query="SELECT p FROM Profesor p")
public class Profesor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idprofesor;

	private Boolean activo;

	private String apellido;

	private String dni;

	private String nombre;

	//bi-directional one-to-one association to Usuario
	@OneToOne
	@JoinColumn(name="IDUSUARIO")
	private Usuario usuario;

	//bi-directional many-to-one association to Salon
	@OneToMany(mappedBy="profesor")
	private List<Salon> salons;

	public Profesor() {
	}

	public int getIdprofesor() {
		return this.idprofesor;
	}

	public void setIdprofesor(int idprofesor) {
		this.idprofesor = idprofesor;
	}

	public Boolean getActivo() {
		return this.activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Salon> getSalons() {
		return this.salons;
	}

	public void setSalons(List<Salon> salons) {
		this.salons = salons;
	}

	public Salon addSalon(Salon salon) {
		getSalons().add(salon);
		salon.setProfesor(this);

		return salon;
	}

	public Salon removeSalon(Salon salon) {
		getSalons().remove(salon);
		salon.setProfesor(null);

		return salon;
	}

}