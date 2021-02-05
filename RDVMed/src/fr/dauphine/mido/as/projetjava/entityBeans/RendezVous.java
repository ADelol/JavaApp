package fr.dauphine.mido.as.projetjava.entityBeans;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the rendez_vous database table.
 * 
 */
@Entity
@Table(name="rendez_vous")
@NamedQuery(name="RendezVous.findAll", query="SELECT r FROM RendezVous r")
public class RendezVous implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int num_RendezVous;

	@Temporal(TemporalType.DATE)
	private Date date_RendezVous;

	private String etatR;

	private Time HEURE_Debut;

	@Column(name="HEURE_FIN")
	private Time heureFin;

	//bi-directional many-to-one association to Medecin
	@ManyToOne
	@JoinColumn(name="ID_UserM")
	private Medecin medecin;

	//bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name="ID_UserP")
	private Patient patient;

	public RendezVous() {
	}

	public int getNum_RendezVous() {
		return this.num_RendezVous;
	}

	public void setNum_RendezVous(int num_RendezVous) {
		this.num_RendezVous = num_RendezVous;
	}

	public Date getDate_RendezVous() {
		return this.date_RendezVous;
	}

	public void setDate_RendezVous(Date date_RendezVous) {
		this.date_RendezVous = date_RendezVous;
	}

	public String getEtatR() {
		return this.etatR;
	}

	public void setEtatR(String etatR) {
		this.etatR = etatR;
	}

	public Time getHEURE_Debut() {
		return this.HEURE_Debut;
	}

	public void setHEURE_Debut(Time HEURE_Debut) {
		this.HEURE_Debut = HEURE_Debut;
	}

	public Time getHeureFin() {
		return this.heureFin;
	}

	public void setHeureFin(Time heureFin) {
		this.heureFin = heureFin;
	}

	public Medecin getMedecin() {
		return this.medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}