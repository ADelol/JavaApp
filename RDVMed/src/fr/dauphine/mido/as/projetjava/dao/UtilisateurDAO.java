package fr.dauphine.mido.as.projetjava.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.dauphine.mido.as.projetjava.entityBeans.Patient;
import fr.dauphine.mido.as.projetjava.entityBeans.Utilisateur;

public class UtilisateurDAO {

	
	public void ajouterUtilisateur(Utilisateur u) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("RDVMed");
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(u);
			et.commit();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
