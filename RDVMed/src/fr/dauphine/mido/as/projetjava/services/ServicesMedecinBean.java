package fr.dauphine.mido.as.projetjava.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import fr.dauphine.mido.as.projetjava.dao.MedecinDAO;
import fr.dauphine.mido.as.projetjava.dao.PatientDAO;
import fr.dauphine.mido.as.projetjava.dao.UtilisateurDAO;
import fr.dauphine.mido.as.projetjava.entityBeans.Medecin;
import fr.dauphine.mido.as.projetjava.entityBeans.Patient;
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
			u.setUserEmail(m.getEMAIL_Medecin());
			u.setMdp(m.getMDP_Medecin());
			u.setUserEtat(m.getEtatM());
			u.setUserRole("Medecin");
			daoU.ajouterUtilisateur(u);
			return true;
		}
		return false;

	}

}
