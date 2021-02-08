package fr.dauphine.mido.as.projetjava.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import fr.dauphine.mido.as.projetjava.dao.PatientDAO;
import fr.dauphine.mido.as.projetjava.dao.UtilisateurDAO;
import fr.dauphine.mido.as.projetjava.entityBeans.Patient;
import fr.dauphine.mido.as.projetjava.entityBeans.Utilisateur;

/**
 * Session Bean implementation class ServicesPatientBean
 */
@Stateless
@LocalBean
public class ServicesPatientBean {

	/**
	 * Default constructor.
	 */
	public ServicesPatientBean() {
		// TODO Auto-generated constructor stub
	}

	public boolean ajouterPatient(Patient p) {
		PatientDAO dao = new PatientDAO();
		UtilisateurDAO daoU = new UtilisateurDAO();
		if (dao.getPatient(p.getEmailPatient()).isEmpty()) {
			System.out.println("bug ?");
			dao.ajouterPatient(p);
			Utilisateur u = new Utilisateur();
			u.setUsername(p.getEmailPatient());
			u.setMdp(p.getMDPPatient());
			u.setUserEtat(p.getEtatP());
			u.setUserRole("Patient");
			daoU.ajouterUtilisateur(u);
			return true;
		}
		return false;

	}

	public Patient getPatient(String mail) {
		PatientDAO dao = new PatientDAO();
		return dao.getPatient(mail).get(0);
	}

	public Patient modifierPatient(Patient p, String ancienMail, String ancienMDP) {
		PatientDAO dao = new PatientDAO();
		UtilisateurDAO daoU = new UtilisateurDAO();
		Patient patientModif = dao.modifierPatient(p);
		if (patientModif != null) {
			Utilisateur u = daoU.getUtilisateur(ancienMail, ancienMDP).get(0);
			u.setUsername(patientModif.getEmailPatient());
			u.setMdp(patientModif.getMDPPatient());
			Utilisateur utilModif = daoU.modifierUtilisateur(u);
			System.out.println(utilModif.getUsername());
		}
		return patientModif;

	}

	public void supprimerPatient(Patient p, Utilisateur u) {
		PatientDAO dao = new PatientDAO();
		UtilisateurDAO daoU = new UtilisateurDAO();
		p.setEtatP("Supprime");
		u.setUserEtat("Supprime");
		dao.modifierPatient(p);
		daoU.modifierUtilisateur(u);
	}

}
