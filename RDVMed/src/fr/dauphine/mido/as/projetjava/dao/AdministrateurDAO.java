package fr.dauphine.mido.as.projetjava.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.dauphine.mido.as.projetjava.entityBeans.Administrateur;
import fr.dauphine.mido.as.projetjava.entityBeans.Medecin;
import fr.dauphine.mido.as.projetjava.entityBeans.Patient;

public class AdministrateurDAO {

	public void ajouterAdministrateur(Administrateur a) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("RDVMed");
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(a);
			et.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Administrateur> getAdministrateur(String mail) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("RDVMed");
			EntityManager em = emf.createEntityManager();
			return em.createQuery("SELECT a FROM Administrateur a where a.EMAILAdmin = :mail")
                    .setParameter("mail", mail).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
