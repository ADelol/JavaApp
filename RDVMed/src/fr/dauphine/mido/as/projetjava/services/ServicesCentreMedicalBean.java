package fr.dauphine.mido.as.projetjava.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import fr.dauphine.mido.as.projetjava.dao.CentreMedicalDAO;
import fr.dauphine.mido.as.projetjava.dao.SpecialiteDAO;
import fr.dauphine.mido.as.projetjava.entityBeans.CentreMedical;
import fr.dauphine.mido.as.projetjava.entityBeans.Patient;

/**
 * Session Bean implementation class ServicesCentreMedicalBean
 */
@Stateless
@LocalBean
public class ServicesCentreMedicalBean {

    /**
     * Default constructor. 
     */
    public ServicesCentreMedicalBean() {
        // TODO Auto-generated constructor stub
    }
	public List<CentreMedical> getAllCentreMedical() {
		CentreMedicalDAO dao = new CentreMedicalDAO();
		return dao.getAllCentreMedical();

	}
}
