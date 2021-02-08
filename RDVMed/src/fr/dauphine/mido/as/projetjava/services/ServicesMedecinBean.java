package fr.dauphine.mido.as.projetjava.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import fr.dauphine.mido.as.projetjava.dao.MedecinDAO;
import fr.dauphine.mido.as.projetjava.dao.UtilisateurDAO;
import fr.dauphine.mido.as.projetjava.entityBeans.Medecin;
import fr.dauphine.mido.as.projetjava.entityBeans.Utilisateur;

/**
 * Session Bean implementation class ServicesMedecinBean
 */
@Stateless
@LocalBean
public class ServicesMedecinBean {

	/**
	 * Default constructor.
	 */
	public ServicesMedecinBean() {
		// TODO Auto-generated constructor stub
	}

	public boolean ajouterMedecin(Medecin m) {
		MedecinDAO dao = new MedecinDAO();
		UtilisateurDAO daoU = new UtilisateurDAO();
		if (dao.getMedecin(m.getEMAIL_Medecin()).isEmpty()) {
			dao.ajouterMedecin(m);
			Utilisateur u = new Utilisateur();
			u.setUsername(m.getEMAIL_Medecin());
			u.setMdp(m.getMDP_Medecin());
			u.setUserEtat(m.getEtatM());
			u.setUserRole("Medecin");
			daoU.ajouterUtilisateur(u);
			return true;
		}
		return false;

	}

	public Medecin getMedecin(String mail) {
		MedecinDAO dao = new MedecinDAO();
		return dao.getMedecin(mail).get(0);
	}

	public void supprimerMedecin(Medecin m, Utilisateur u) {
		MedecinDAO dao = new MedecinDAO();
		UtilisateurDAO daoU = new UtilisateurDAO();
		m.setEtatM("Supprime");
		u.setUserEtat("Supprime");
		dao.modifierMedecin(m);
		daoU.modifierUtilisateur(u);
	}

	public Medecin modifierMedecin(Medecin m, String username, String mdp) {
		MedecinDAO dao = new MedecinDAO();
		UtilisateurDAO daoU = new UtilisateurDAO();
		Medecin medecinModif = dao.modifierMedecin(m);
		if (medecinModif != null) {
			Utilisateur u = daoU.getUtilisateur(username, mdp).get(0);
			u.setUsername(medecinModif.getEMAIL_Medecin());
			u.setMdp(medecinModif.getMDP_Medecin());
			Utilisateur utilModif = daoU.modifierUtilisateur(u);
			System.out.println(utilModif.getUsername());
		}
		return medecinModif;
	}
}
