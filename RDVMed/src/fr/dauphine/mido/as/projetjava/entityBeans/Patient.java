package fr.dauphine.mido.as.projetjava.entityBeans;

import java.io.Serializable;
import javax.persistence.*;


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

	private String MDPPatient;

	private String NOMPatient;

	private String numTelePatient;

	private String PRENOMPatient;

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

}