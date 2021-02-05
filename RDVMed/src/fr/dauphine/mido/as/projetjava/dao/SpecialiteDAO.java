package fr.dauphine.mido.as.projetjava.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.dauphine.mido.as.projetjava.entityBeans.Patient;
import fr.dauphine.mido.as.projetjava.entityBeans.Specialite;

public class SpecialiteDAO {

	public List<Specialite> getAllSpecialites() {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("RDVMed");
			EntityManager em = emf.createEntityManager();
			return em.createNamedQuery("Specialite.findAll").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
