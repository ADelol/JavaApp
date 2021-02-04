package fr.dauphine.mido.as.projetjava.entityBeans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the specialite database table.
 * 
 */
@Entity
@NamedQuery(name="Specialite.findAll", query="SELECT s FROM Specialite s")
public class Specialite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int ID_Specialite;

	private String NOM_Specialite;

	public Specialite() {
	}

	public int getID_Specialite() {
		return this.ID_Specialite;
	}

	public void setID_Specialite(int ID_Specialite) {
		this.ID_Specialite = ID_Specialite;
	}

	public String getNOM_Specialite() {
		return this.NOM_Specialite;
	}

	public void setNOM_Specialite(String NOM_Specialite) {
		this.NOM_Specialite = NOM_Specialite;
	}

}