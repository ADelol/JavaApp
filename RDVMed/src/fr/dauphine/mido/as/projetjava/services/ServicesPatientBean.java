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
			u.setUserEmail(p.getEmailPatient());
			u.setMdp(p.getMDPPatient());
			u.setUserEtat(p.getEtatP());
			u.setUserRole("Patient");
			daoU.ajouterUtilisateur(u);
			return true;
		}
		return false;

	}

}
