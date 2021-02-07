package fr.dauphine.mido.as.projetjava.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.dauphine.mido.as.projetjava.entityBeans.Administrateur;
import fr.dauphine.mido.as.projetjava.entityBeans.Medecin;
import fr.dauphine.mido.as.projetjava.entityBeans.Patient;
import fr.dauphine.mido.as.projetjava.entityBeans.Utilisateur;
import fr.dauphine.mido.as.projetjava.services.ServicesAdministrateurBean;
import fr.dauphine.mido.as.projetjava.services.ServicesMedecinBean;
import fr.dauphine.mido.as.projetjava.services.ServicesPatientBean;
import fr.dauphine.mido.as.projetjava.services.ServicesUtilisateurBean;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	ServicesUtilisateurBean servicesUtilisateurBean;
	
	@EJB
	ServicesAdministrateurBean servicesAdministrateurBean;
	
	@EJB
	ServicesPatientBean servicesPatientBean;
	
	@EJB
	ServicesMedecinBean servicesMedecinBean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("erreurLogin", "");
		
		String mail = request.getParameter("email");
		String mdp = request.getParameter("mdp");
		System.out.println("aaaaaa");
		System.out.println(mail);
		System.out.println(mdp);
		Utilisateur u = servicesUtilisateurBean.getUtilisateur(mail,mdp);

		if(u == null || u.getUserEtat().equals("Inactif")) {
			session.setAttribute("erreurLogin", "Les identifiants sont incorrects");
			response.sendRedirect("/RDVMed/Login.jsp");
		}
		else {
			session.setAttribute("utilisateur", u);
			if(u.getUserRole().equals("Administrateur")) {
				Administrateur a = servicesAdministrateurBean.getAdministrateur(mail);
				session.setAttribute("prenom", a.getPRENOMAdmin());
				session.setAttribute("nom", a.getNOMAdmin());
			}
			else if(u.getUserRole().equals("Patient")){
				Patient a = servicesPatientBean.getPatient(mail);
				session.setAttribute("prenom", a.getPRENOMPatient());
				session.setAttribute("nom", a.getNOMPatient());
			} 
			else if(u.getUserRole().equals("Medecin")) {
				Medecin a = servicesMedecinBean.getMedecin(mail);
				session.setAttribute("prenom", a.getPRENOM_Medecin());
				session.setAttribute("nom", a.getNOM_Medecin());
			}
			getServletContext().getRequestDispatcher("/Accueil.jsp").forward(request, response);
		}
	}

}
