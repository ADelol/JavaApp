package fr.dauphine.mido.as.projetjava.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import fr.dauphine.mido.as.projetjava.dao.MedecinDAO;
import fr.dauphine.mido.as.projetjava.dao.PatientDAO;
import fr.dauphine.mido.as.projetjava.entityBeans.Medecin;
import fr.dauphine.mido.as.projetjava.entityBeans.Patient;

/**
 * Session Bean implementation class ServicesMedecinBean
 */
@Stateless
@LocalBean
public class ServicesMedecinBean {

    /**
     * Default constructor. 
     */
    public ServicesMedecinBean() {
        // TODO Auto-generated constructor stub
    }

	public boolean ajouterMedecin(Medecin m) {
		MedecinDAO dao = new MedecinDAO();
		if (dao.getMedecin(m.getEMAIL_Medecin()) == null) {
			dao.ajouterMedecin(m);
			return true;
		}
		return false;

	}

}
