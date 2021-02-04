package fr.dauphine.mido.as.projetjava.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import fr.dauphine.mido.as.projetjava.entityBeans.Patient;


public class PatientDAO {

	//@PersistenceUnit(unitName="RDVMed")
	private EntityManagerFactory emf;
	
	public void ajouterPatient(Patient p) {
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
}