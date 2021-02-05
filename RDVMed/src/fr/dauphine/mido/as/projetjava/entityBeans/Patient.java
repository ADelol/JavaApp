package fr.dauphine.mido.as.projetjava.entityBeans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the patient database table.
 * 
 */
@Entity
@NamedQuery(name="Patient.findAll", query="SELECT p FROM Patient p")
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String emailPatient;

	private String addressHabitPatient;

	private int ANNEENaissance;

	private String etatP;

	private String MDPPatient;

	private String NOMPatient;

	private String numTelePatient;

	private String PRENOMPatient;

	//bi-directional many-to-one association to RendezVous
	@OneToMany(mappedBy="patient")
	private List<RendezVous> rendezVouses;

	public Patient() {
	}

	public String getEmailPatient() {
		return this.emailPatient;
	}

	public void setEmailPatient(String emailPatient) {
		this.emailPatient = emailPatient;
	}

	public String getAddressHabitPatient() {
		return this.addressHabitPatient;
	}

	public void setAddressHabitPatient(String addressHabitPatient) {
		this.addressHabitPatient = addressHabitPatient;
	}

	public int getANNEENaissance() {
		return this.ANNEENaissance;
	}

	public void setANNEENaissance(int ANNEENaissance) {
		this.ANNEENaissance = ANNEENaissance;
	}

	public String getEtatP() {
		return this.etatP;
	}

	public void setEtatP(String etatP) {
		this.etatP = etatP;
	}

	public String getMDPPatient() {
		return this.MDPPatient;
	}

	public void setMDPPatient(String MDPPatient) {
		this.MDPPatient = MDPPatient;
	}

	public String getNOMPatient() {
		return this.NOMPatient;
	}

	public void setNOMPatient(String NOMPatient) {
		this.NOMPatient = NOMPatient;
	}

	public String getNumTelePatient() {
		return this.numTelePatient;
	}

	public void setNumTelePatient(String numTelePatient) {
		this.numTelePatient = numTelePatient;
	}

	public String getPRENOMPatient() {
		return this.PRENOMPatient;
	}

	public void setPRENOMPatient(String PRENOMPatient) {
		this.PRENOMPatient = PRENOMPatient;
	}

	public List<RendezVous> getRendezVouses() {
		return this.rendezVouses;
	}

	public void setRendezVouses(List<RendezVous> rendezVouses) {
		this.rendezVouses = rendezVouses;
	}

	public RendezVous addRendezVous(RendezVous rendezVous) {
		getRendezVouses().add(rendezVous);
		rendezVous.setPatient(this);

		return rendezVous;
	}

	public RendezVous removeRendezVous(RendezVous rendezVous) {
		getRendezVouses().remove(rendezVous);
		rendezVous.setPatient(null);

		return rendezVous;
	}

}