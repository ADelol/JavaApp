package fr.dauphine.mido.as.projetjava.entityBeans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the centre_medical database table.
 * 
 */
@Entity
@Table(name="centre_medical")
@NamedQuery(name="CentreMedical.findAll", query="SELECT c FROM CentreMedical c")
public class CentreMedical implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int ID_CentreMedecin;

	private String addressCentreMedecin;

	private String emailContacter;

	private String nomCentreMedecin;

	private String teleContacter;

	public CentreMedical() {
	}

	public int getID_CentreMedecin() {
		return this.ID_CentreMedecin;
	}

	public void setID_CentreMedecin(int ID_CentreMedecin) {
		this.ID_CentreMedecin = ID_CentreMedecin;
	}

	public String getAddressCentreMedecin() {
		return this.addressCentreMedecin;
	}

	public void setAddressCentreMedecin(String addressCentreMedecin) {
		this.addressCentreMedecin = addressCentreMedecin;
	}

	public String getEmailContacter() {
		return this.emailContacter;
	}

	public void setEmailContacter(String emailContacter) {
		this.emailContacter = emailContacter;
	}

	public String getNomCentreMedecin() {
		return this.nomCentreMedecin;
	}

	public void setNomCentreMedecin(String nomCentreMedecin) {
		this.nomCentreMedecin = nomCentreMedecin;
	}

	public String getTeleContacter() {
		return this.teleContacter;
	}

	public void setTeleContacter(String teleContacter) {
		this.teleContacter = teleContacter;
	}

}