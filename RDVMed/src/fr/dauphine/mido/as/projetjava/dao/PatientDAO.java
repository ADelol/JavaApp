package fr.dauphine.mido.as.projetjava.dao;

import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import fr.dauphine.mido.as.projetjava.entityBeans.Patient;


public class PatientDAO {


	
	public  void ajouterPatient(Patient p) {

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("RDVMed");
			Map<String,Object> s = emf.getProperties();
			System.out.println(s);
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(p);
			et.commit();

	}

	public Patient getPatient(String mail) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("RDVMed");
			EntityManager em = emf.createEntityManager();
			return em.find(Patient.class, mail);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
