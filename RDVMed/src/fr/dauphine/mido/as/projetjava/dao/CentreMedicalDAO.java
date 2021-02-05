package fr.dauphine.mido.as.projetjava.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.dauphine.mido.as.projetjava.entityBeans.CentreMedical;
import fr.dauphine.mido.as.projetjava.entityBeans.Specialite;

public class CentreMedicalDAO {

	
	public List<CentreMedical> getAllCentreMedical() {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("RDVMed");
			EntityManager em = emf.createEntityManager();
			return em.createNamedQuery("CentreMedical.findAll").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}


