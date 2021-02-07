package fr.dauphine.mido.as.projetjava.entityBeans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the administrateur database table.
 * 
 */
@Entity
@NamedQuery(name="Administrateur.findAll", query="SELECT a FROM Administrateur a")
public class Administrateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int numAdmin;

	private String EMAILAdmin;

	private String motDePasseAdmin;

	private String NOMAdmin;

	private String numTeleAdmin;

	private String PRENOMAdmin;

	public Administrateur() {
	}

	public int getNumAdmin() {
		return this.numAdmin;
	}

	public void setNumAdmin(int numAdmin) {
		this.numAdmin = numAdmin;
	}

	public String getEMAILAdmin() {
		return this.EMAILAdmin;
	}

	public void setEMAILAdmin(String EMAILAdmin) {
		this.EMAILAdmin = EMAILAdmin;
	}

	public String getMotDePasseAdmin() {
		return this.motDePasseAdmin;
	}

	public void setMotDePasseAdmin(String motDePasseAdmin) {
		this.motDePasseAdmin = motDePasseAdmin;
	}

	public String getNOMAdmin() {
		return this.NOMAdmin;
	}

	public void setNOMAdmin(String NOMAdmin) {
		this.NOMAdmin = NOMAdmin;
	}

	public String getNumTeleAdmin() {
		return this.numTeleAdmin;
	}

	public void setNumTeleAdmin(String numTeleAdmin) {
		this.numTeleAdmin = numTeleAdmin;
	}

	public String getPRENOMAdmin() {
		return this.PRENOMAdmin;
	}

	public void setPRENOMAdmin(String PRENOMAdmin) {
		this.PRENOMAdmin = PRENOMAdmin;
	}

}