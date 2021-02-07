package fr.dauphine.mido.as.projetjava.dao;

import java.util.List;

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

	public List<Utilisateur> getUtilisateur(String mail, String mdp) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("RDVMed");
			EntityManager em = emf.createEntityManager();
			return em.createQuery("SELECT u FROM Utilisateur u where u.username = :mail AND u.mdp = :mdp")
                    .setParameter("mail", mail).setParameter("mdp", mdp).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
