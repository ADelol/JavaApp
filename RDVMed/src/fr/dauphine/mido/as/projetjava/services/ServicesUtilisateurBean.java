package fr.dauphine.mido.as.projetjava.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import fr.dauphine.mido.as.projetjava.dao.UtilisateurDAO;
import fr.dauphine.mido.as.projetjava.entityBeans.Utilisateur;

/**
 * Session Bean implementation class ServicesUtilisateurBean
 */
@Stateless
@LocalBean
public class ServicesUtilisateurBean {

	/**
	 * Default constructor.
	 */

	public ServicesUtilisateurBean() {
		// TODO Auto-generated constructor stub
	}

	@Transactional
	public Utilisateur getUtilisateur(String mail, String mdp) {
		UtilisateurDAO dao = new UtilisateurDAO();
		List<Utilisateur> listUtilisateurs = dao.getUtilisateur(mail, mdp);
		if (listUtilisateurs.isEmpty())
			return null;
		System.out.println(listUtilisateurs);
		return listUtilisateurs.get(0);
	}

}
