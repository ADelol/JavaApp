package fr.dauphine.mido.as.projetjava.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.dauphine.mido.as.projetjava.entityBeans.Medecin;

public class MedecinDAO {

	public void ajouterMedecin(Medecin m) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("RDVMed");
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			em.persist(m);
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Medecin> getMedecin(String mail) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("RDVMed");
			EntityManager em = emf.createEntityManager();
			List<Medecin> res = em.createQuery("SELECT m FROM Medecin m where m.EMAIL_Medecin = :mail")
					.setParameter("mail", mail).getResultList();
			em.close();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Medecin modifierMedecin(Medecin m) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("RDVMed");
			EntityManager em = emf.createEntityManager();
			Medecin merged = em.merge(m);
			em.close();
			return merged;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
