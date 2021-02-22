package fr.dauphine.mido.as.projetjava.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.dauphine.mido.as.projetjava.entityBeans.Utilisateur;

public class UtilisateurDAO {

	public void ajouterUtilisateur(Utilisateur u) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("RDVMed");
			EntityManager em = emf.createEntityManager();
			em.persist(u);
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Utilisateur> getUtilisateur(String mail, String mdp) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("RDVMed");
			EntityManager em = emf.createEntityManager();
			List<Utilisateur> res = em
					.createQuery("SELECT u FROM Utilisateur u where u.username = :mail AND u.mdp = :mdp")
					.setParameter("mail", mail).setParameter("mdp", mdp).getResultList();
			em.close();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Utilisateur modifierUtilisateur(Utilisateur u) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("RDVMed");
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			Utilisateur merged = em.merge(u);
			em.close();
			System.out.println("MERGED USER : " + merged.getUsername());
			return merged;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
