package fr.dauphine.mido.as.projetjava.controleursMetiers;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.transaction.Transactional;

import fr.dauphine.mido.as.projetjava.entityBeans.Patient;
import fr.dauphine.mido.as.projetjava.services.ServicesPatientBean;

/**
 * Session Bean implementation class ControleurPatient
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ControleurPatient {

	/**
	 * Default constructor.
	 */
	public ControleurPatient() {
		// TODO Auto-generated constructor stub
	}

	@EJB
	ServicesPatientBean services;

	@Transactional
	public boolean ajouterPatient(Patient p) throws Exception {
		return services.ajouterPatient(p);
	}

}
