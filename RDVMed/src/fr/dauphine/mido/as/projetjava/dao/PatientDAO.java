package fr.dauphine.mido.as.projetjava.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import fr.dauphine.mido.as.projetjava.entityBeans.Patient;


public class PatientDAO {

	//@PersistenceUnit
	//private EntityManagerFactory emf;
	
	public  void ajouterPatient(Patient p) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("RDVMed");
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(p);
			et.commit();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public List<Patient> getPatient(String mail) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("RDVMed");
			EntityManager em = emf.createEntityManager();
			return em.createQuery("SELECT p FROM Patient p where p.emailPatient = :mail")
                    .setParameter("mail", mail).getResultList();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
