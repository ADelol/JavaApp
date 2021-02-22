package fr.dauphine.mido.as.projetjava.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import fr.dauphine.mido.as.projetjava.dao.CentreMedicalDAO;
import fr.dauphine.mido.as.projetjava.dao.MedecinDAO;
import fr.dauphine.mido.as.projetjava.dao.SpecialiteDAO;
import fr.dauphine.mido.as.projetjava.dao.UtilisateurDAO;
import fr.dauphine.mido.as.projetjava.entityBeans.CentreMedical;
import fr.dauphine.mido.as.projetjava.entityBeans.Medecin;
import fr.dauphine.mido.as.projetjava.entityBeans.Specialite;
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

	public boolean ajouterMedecin(Medecin m, List<Integer> specialitesIds, List<Integer> centresIds) {
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaa");
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

	public boolean ajouterMedecin2(Medecin m, List<Integer> specialitesIds, List<Integer> centresIds) {
		System.out.println("abbbbbbbbbaaaaaaaaaaaa");
		MedecinDAO dao = new MedecinDAO();
		UtilisateurDAO daoU = new UtilisateurDAO();
		SpecialiteDAO specialiteDao = new SpecialiteDAO();
		CentreMedicalDAO centreDao = new CentreMedicalDAO();
		if (!dao.getMedecin(m.getEMAIL_Medecin()).isEmpty()) {
			Medecin m2 = dao.getMedecin(m.getEMAIL_Medecin()).get(0);
			// Pour chaque centre/specialite, l'ajouter à ses spe/cen
			// Puis ajouter le medecin à ces cen/spe (get spe, add medecin, update spe, même
			// chsoe pour cen)
			for (int i = 0; i < specialitesIds.size(); i++) {
				Specialite s = specialiteDao.getSpecialite(specialitesIds.get(i));
				CentreMedical c = centreDao.getCentreMedical(centresIds.get(i));
				m2.getSpecialites().add(s);
				m2.getCentreMedicals().add(c);
				s.getCentreMedicals().add(c);
				s.getMedecins().add(m2);
				// specialiteDao.updateSpecialite(s);
				// centreDao.updateCentreMedical(c);
			}
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
