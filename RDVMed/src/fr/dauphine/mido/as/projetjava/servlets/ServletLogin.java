package fr.dauphine.mido.as.projetjava.servlets;

import java.io.IOException;

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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("erreurLogin", "");
		System.out.println("AAAAAAAAAAAAAAAAAA");
		String mail = request.getParameter("email");
		String mdp = request.getParameter("mdp");
		Utilisateur u = servicesUtilisateurBean.getUtilisateur(mail, mdp);

		if (u == null || u.getUserEtat().equals("Supprime")) {
			session.setAttribute("erreurLogin", "Les identifiants sont incorrects");
		} else {
			session.setAttribute("utilisateur", u);
			System.out.println(u.getUserRole() + "uuuuu");
			if (u.getUserRole().equals("\"Administrateur\"")) {
				Administrateur a = servicesAdministrateurBean.getAdministrateur(mail);
				System.out.println("admin???");
				session.setAttribute("administrateur", a);
				session.setAttribute("prenom", a.getPRENOMAdmin());
				session.setAttribute("nom", a.getNOMAdmin());
				response.sendRedirect("/Administrateur/Medecin_registre.jsp");
				getServletContext().getRequestDispatcher("/Administrateur/Medecin_registre.jsp").forward(request,
						response);
			} else if (u.getUserRole().equals("Patient")) {
				Patient a = servicesPatientBean.getPatient(mail);
				session.setAttribute("patient", a);
				session.setAttribute("prenom", a.getPRENOMPatient());
				session.setAttribute("nom", a.getNOMPatient());

				getServletContext().getRequestDispatcher("/Accueil.jsp").forward(request, response);
			} else if (u.getUserRole().equals("Medecin")) {
				Medecin a = servicesMedecinBean.getMedecin(mail);
				session.setAttribute("medecin", a);
				session.setAttribute("prenom", a.getPRENOM_Medecin());
				session.setAttribute("nom", a.getNOM_Medecin());
				getServletContext().getRequestDispatcher("/Accueil.jsp").forward(request, response);
			}

		}
	}

}
