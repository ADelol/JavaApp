package fr.dauphine.mido.as.projetjava.dao;

import java.util.List;

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

	public List<Medecin> getMedecin(String mail) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("RDVMed");
			EntityManager em = emf.createEntityManager();
			return em.createQuery("SELECT m FROM Medecin m where m.EMAIL_Medecin = :mail")
                    .setParameter("mail", mail).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}