package fr.dauphine.mido.as.projetjava.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.dauphine.mido.as.projetjava.entityBeans.Medecin;
import fr.dauphine.mido.as.projetjava.entityBeans.Patient;

public class MedecinDAO {

	public void ajouterMedecin(Medecin m) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("RDVMed");
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(m);
			et.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Medecin getMedecin(String mail) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("RDVMed");
			EntityManager em = emf.createEntityManager();
			return em.find(Medecin.class, mail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
