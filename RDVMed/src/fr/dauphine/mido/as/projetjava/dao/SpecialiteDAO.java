package fr.dauphine.mido.as.projetjava.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.dauphine.mido.as.projetjava.entityBeans.Specialite;

public class SpecialiteDAO {

	public List<Specialite> getAllSpecialites() {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("RDVMed");
			EntityManager em = emf.createEntityManager();
			List<Specialite> res = em.createNamedQuery("Specialite.findAll").getResultList();
			em.close();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Specialite getSpecialite(Integer integer) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("RDVMed");
			EntityManager em = emf.createEntityManager();
			Specialite res = em.find(Specialite.class, integer);
			em.close();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Specialite updateSpecialite(Specialite s) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("RDVMed");
			EntityManager em = emf.createEntityManager();
			Specialite merged = em.merge(s);
			em.close();
			return merged;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
