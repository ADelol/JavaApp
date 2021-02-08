package fr.dauphine.mido.as.projetjava.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.dauphine.mido.as.projetjava.entityBeans.Administrateur;

public class AdministrateurDAO {

	public void ajouterAdministrateur(Administrateur a) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("RDVMed");
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(a);
			et.commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Administrateur> getAdministrateur(String mail) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("RDVMed");
			EntityManager em = emf.createEntityManager();
			List<Administrateur> res = em.createQuery("SELECT a FROM Administrateur a where a.EMAILAdmin = :mail")
					.setParameter("mail", mail).getResultList();
			em.close();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
