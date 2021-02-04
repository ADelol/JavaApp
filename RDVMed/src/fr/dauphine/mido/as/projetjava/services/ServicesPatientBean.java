package fr.dauphine.mido.as.projetjava.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import fr.dauphine.mido.as.projetjava.dao.PatientDAO;
import fr.dauphine.mido.as.projetjava.entityBeans.Patient;

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

	public static boolean ajouterPatient(Patient p) {
		PatientDAO dao = new PatientDAO();
		if (dao.getPatient(p.getEmailPatient()) == null) {
			dao.ajouterPatient(p);
			return true;
		}
		return false;

	}

}
