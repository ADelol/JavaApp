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

import fr.dauphine.mido.as.projetjava.entityBeans.Patient;
import fr.dauphine.mido.as.projetjava.entityBeans.Utilisateur;
import fr.dauphine.mido.as.projetjava.services.ServicesPatientBean;
import fr.dauphine.mido.as.projetjava.utils.Utilitaires;

/**
 * Servlet implementation class ServletCreationPatient
 */
@WebServlet("/ServletGestionComptePatient")
public class ServletGestionComptePatient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	ServicesPatientBean servicesPatientBean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletGestionComptePatient() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		// Prepare messages.
		Map<String, String> messages = new HashMap<String, String>();
		request.setAttribute("messages", messages);

		String patientMail = request.getParameter("mail");
		if (!Utilitaires.isMail(patientMail)) {
			messages.put("mail", "Format mail incorrect");
			System.out.println("Format mail incorrect");
		}
		String patientNom = request.getParameter("nom");
		if (!Utilitaires.isAlpha(patientNom)) {
			messages.put("nom", "Nom non alpha");
			System.out.println("cnom non alpha");
		}
		String patientPrenom = request.getParameter("prenom");
		if (!Utilitaires.isAlpha(patientPrenom)) {
			messages.put("prenom", "Prenom non alpha");
			System.out.println("cprenom non alpha");
		}
		String patientTel = request.getParameter("tel");
		if (!Utilitaires.isTelNumber(patientTel)) {
			messages.put("tel", "format tel incorrect");
			System.out.println("format tel incorrect");
		}
		String patientAdr = request.getParameter("adresse");
		int patientYear = Integer.parseInt(request.getParameter("annee"));
		if (!Utilitaires.isGoodDate(patientYear)) {
			messages.put("annee", "annee non correcte");
			System.out.println("annee non correcte");
		}
		String patientMDP = request.getParameter("mdp");

		Patient p = (Patient) session.getAttribute("patient");
		p.setEmailPatient(patientMail);
		p.setNOMPatient(patientNom);
		p.setPRENOMPatient(patientPrenom);
		p.setNumTelePatient(patientTel);
		p.setAddressHabitPatient(patientAdr);
		p.setANNEENaissance(patientYear);
		p.setMDPPatient(patientMDP);
		System.out.println(p.getEmailPatient());

		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur");
		System.out.println(" umdp" + u.getMdp());
		System.out.println("userna" + u.getUsername());

		if (messages.isEmpty()) {
			Patient patientModif = servicesPatientBean.modifierPatient(p, u.getUsername(), u.getMdp());
			System.out.println("modif" + patientModif.getEmailPatient());
			session.setAttribute("patient", patientModif);
			session.setAttribute("prenom", patientModif.getPRENOMPatient());
			session.setAttribute("nom", patientModif.getNOMPatient());
			u.setUsername(patientModif.getEmailPatient());
			u.setMdp(patientModif.getMDPPatient());
			messages.put("info", "Compte modifié");
			getServletContext().getRequestDispatcher("/Accueil.jsp").forward(request, response);
		} else {
			getServletContext().getRequestDispatcher("/Patient/GestionCompte.jsp").forward(request, response);
		}
	}

}
