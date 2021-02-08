package fr.dauphine.mido.as.projetjava.entityBeans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the utilisateur database table.
 * 
 */
@Entity
@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u")
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int userId;

	private int ID_Medecin;

	private int ID_patient;

	private String mdp;

	private String userEtat;

	private String username;

	private String userRole;

	public Utilisateur() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getID_Medecin() {
		return this.ID_Medecin;
	}

	public void setID_Medecin(int ID_Medecin) {
		this.ID_Medecin = ID_Medecin;
	}

	public int getID_patient() {
		return this.ID_patient;
	}

	public void setID_patient(int ID_patient) {
		this.ID_patient = ID_patient;
	}

	public String getMdp() {
		return this.mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getUserEtat() {
		return this.userEtat;
	}

	public void setUserEtat(String userEtat) {
		this.userEtat = userEtat;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserRole() {
		return this.userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

}