package fr.dauphine.mido.as.projetjava.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import fr.dauphine.mido.as.projetjava.dao.AdministrateurDAO;
import fr.dauphine.mido.as.projetjava.dao.PatientDAO;
import fr.dauphine.mido.as.projetjava.entityBeans.Administrateur;
import fr.dauphine.mido.as.projetjava.entityBeans.Patient;

/**
 * Session Bean implementation class ServicesAdministrateurBean
 */
@Stateless
@LocalBean
public class ServicesAdministrateurBean {

    /**
     * Default constructor. 
     */
    public ServicesAdministrateurBean() {
        // TODO Auto-generated constructor stub
    }

    
	public Administrateur getAdministrateur(String mail) {
		AdministrateurDAO dao = new AdministrateurDAO();
		return dao.getAdministrateur(mail).get(0);
	}
}
