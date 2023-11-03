package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the notas database table.
 * 
 */
@Embeddable
public class NotaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idsalon;

	@Column(insertable=false, updatable=false)
	private int idalumno;

	public NotaPK() {
	}
	public int getIdsalon() {
		return this.idsalon;
	}
	public void setIdsalon(int idsalon) {
		this.idsalon = idsalon;
	}
	public int getIdalumno() {
		return this.idalumno;
	}
	public void setIdalumno(int idalumno) {
		this.idalumno = idalumno;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof NotaPK)) {
			return false;
		}
		NotaPK castOther = (NotaPK)other;
		return 
			(this.idsalon == castOther.idsalon)
			&& (this.idalumno == castOther.idalumno);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idsalon;
		hash = hash * prime + this.idalumno;
		
		return hash;
	}
}