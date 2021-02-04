package fr.dauphine.mido.as.projetjava.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import fr.dauphine.mido.as.projetjava.entityBeans.Patient;

public class PatientDAO {

	private EntityManagerFactory emf;

	public PatientDAO() {
		emf = Persistence.createEntityManagerFactory("RDVMed");
	}

	public void ajouterPatient(Patient p) {
		try {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Patient getPatient(String mail) {
		try {
			EntityManager em = emf.createEntityManager();
			return em.find(Patient.class, mail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
