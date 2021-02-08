package fr.dauphine.mido.as.projetjava.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import fr.dauphine.mido.as.projetjava.entityBeans.Patient;

public class PatientDAO {

	// @PersistenceUnit
	// private EntityManagerFactory emf;

	public void ajouterPatient(Patient p) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("RDVMed");
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(p);
			et.commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Patient> getPatient(String mail) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("RDVMed");
			EntityManager em = emf.createEntityManager();
			List<Patient> res = em.createQuery("SELECT p FROM Patient p where p.emailPatient = :mail")
					.setParameter("mail", mail).getResultList();
			em.close();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	public Patient modifierPatient(Patient p) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("RDVMed");
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			Patient merged = em.merge(p);
			et.commit();
			em.close();

			System.out.println("MERGED USER : " + merged.getEmailPatient());
			return merged;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
