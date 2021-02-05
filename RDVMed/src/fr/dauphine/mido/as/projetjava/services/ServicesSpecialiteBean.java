package fr.dauphine.mido.as.projetjava.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import fr.dauphine.mido.as.projetjava.dao.PatientDAO;
import fr.dauphine.mido.as.projetjava.dao.SpecialiteDAO;
import fr.dauphine.mido.as.projetjava.entityBeans.Patient;
import fr.dauphine.mido.as.projetjava.entityBeans.Specialite;

/**
 * Session Bean implementation class ServicesSpecialiteBean
 */
@Stateless
@LocalBean
public class ServicesSpecialiteBean {

    /**
     * Default constructor. 
     */
    public ServicesSpecialiteBean() {
        // TODO Auto-generated constructor stub
    }

    
	public List<Specialite> getAllSpecialites() {
		SpecialiteDAO dao = new SpecialiteDAO();
		return dao.getAllSpecialites();

	}

}
