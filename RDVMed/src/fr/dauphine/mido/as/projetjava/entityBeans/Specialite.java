package fr.dauphine.mido.as.projetjava.entityBeans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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

	//bi-directional many-to-many association to CentreMedical
	@ManyToMany
	@JoinTable(
		name="tab_specentremed"
		, joinColumns={
			@JoinColumn(name="ID_Specialite")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_CentreMedecin")
			}
		)
	private List<CentreMedical> centreMedicals;

	//bi-directional many-to-many association to Medecin
	@ManyToMany
	@JoinTable(
		name="tab_specialitemed"
		, joinColumns={
			@JoinColumn(name="ID_Specialite")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_Medecin")
			}
		)
	private List<Medecin> medecins;

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

	public List<CentreMedical> getCentreMedicals() {
		return this.centreMedicals;
	}

	public void setCentreMedicals(List<CentreMedical> centreMedicals) {
		this.centreMedicals = centreMedicals;
	}

	public List<Medecin> getMedecins() {
		return this.medecins;
	}

	public void setMedecins(List<Medecin> medecins) {
		this.medecins = medecins;
	}

}