package fr.dauphine.mido.as.projetjava.entityBeans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the medecin database table.
 * 
 */
@Entity
@NamedQuery(name="Medecin.findAll", query="SELECT m FROM Medecin m")
public class Medecin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int ID_Medecin;

	private String addressHabit_Medecin;

	private String EMAIL_Medecin;

	private String etatM;

	private String MDP_Medecin;

	private String NOM_Medecin;

	private String numTele_Medecin;

	private String PRENOM_Medecin;

	//bi-directional many-to-one association to RendezVous
	@OneToMany(mappedBy="medecin")
	private List<RendezVous> rendezVouses;

	//bi-directional many-to-many association to CentreMedical
	@ManyToMany
	@JoinTable(
		name="tab_medcentre"
		, joinColumns={
			@JoinColumn(name="id_medecin")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_centreMedecin")
			}
		)
	private List<CentreMedical> centreMedicals;

	//bi-directional many-to-many association to Specialite
	@ManyToMany(mappedBy="medecins")
	private List<Specialite> specialites;

	public Medecin() {
	}

	public int getID_Medecin() {
		return this.ID_Medecin;
	}

	public void setID_Medecin(int ID_Medecin) {
		this.ID_Medecin = ID_Medecin;
	}

	public String getAddressHabit_Medecin() {
		return this.addressHabit_Medecin;
	}

	public void setAddressHabit_Medecin(String addressHabit_Medecin) {
		this.addressHabit_Medecin = addressHabit_Medecin;
	}

	public String getEMAIL_Medecin() {
		return this.EMAIL_Medecin;
	}

	public void setEMAIL_Medecin(String EMAIL_Medecin) {
		this.EMAIL_Medecin = EMAIL_Medecin;
	}

	public String getEtatM() {
		return this.etatM;
	}

	public void setEtatM(String etatM) {
		this.etatM = etatM;
	}

	public String getMDP_Medecin() {
		return this.MDP_Medecin;
	}

	public void setMDP_Medecin(String MDP_Medecin) {
		this.MDP_Medecin = MDP_Medecin;
	}

	public String getNOM_Medecin() {
		return this.NOM_Medecin;
	}

	public void setNOM_Medecin(String NOM_Medecin) {
		this.NOM_Medecin = NOM_Medecin;
	}

	public String getNumTele_Medecin() {
		return this.numTele_Medecin;
	}

	public void setNumTele_Medecin(String numTele_Medecin) {
		this.numTele_Medecin = numTele_Medecin;
	}

	public String getPRENOM_Medecin() {
		return this.PRENOM_Medecin;
	}

	public void setPRENOM_Medecin(String PRENOM_Medecin) {
		this.PRENOM_Medecin = PRENOM_Medecin;
	}

	public List<RendezVous> getRendezVouses() {
		return this.rendezVouses;
	}

	public void setRendezVouses(List<RendezVous> rendezVouses) {
		this.rendezVouses = rendezVouses;
	}

	public RendezVous addRendezVous(RendezVous rendezVous) {
		getRendezVouses().add(rendezVous);
		rendezVous.setMedecin(this);

		return rendezVous;
	}

	public RendezVous removeRendezVous(RendezVous rendezVous) {
		getRendezVouses().remove(rendezVous);
		rendezVous.setMedecin(null);

		return rendezVous;
	}

	public List<CentreMedical> getCentreMedicals() {
		return this.centreMedicals;
	}

	public void setCentreMedicals(List<CentreMedical> centreMedicals) {
		this.centreMedicals = centreMedicals;
	}

	public List<Specialite> getSpecialites() {
		return this.specialites;
	}

	public void setSpecialites(List<Specialite> specialites) {
		this.specialites = specialites;
	}

}