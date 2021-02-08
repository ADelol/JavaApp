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
import fr.dauphine.mido.as.projetjava.services.ServicesMailBean;
import fr.dauphine.mido.as.projetjava.services.ServicesPatientBean;
import fr.dauphine.mido.as.projetjava.utils.Utilitaires;

/**
 * Servlet implementation class ServletCreationPatient
 */
@WebServlet("/ServletCreationPatient")
public class ServletCreationPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	ServicesPatientBean servicesPatientBean;

	@EJB
	ServicesMailBean servicesMailBean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCreationPatient() {
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

		String patientMail = request.getParameter("emailP");
		if (!Utilitaires.isMail(patientMail)) {
			messages.put("mail", "Format mail incorrect");
			System.out.println("Format mail incorrect");
		}
		String patientNom = request.getParameter("patientnom");
		if (!Utilitaires.isAlpha(patientNom)) {
			messages.put("nom", "Nom non alpha");
			System.out.println("cnom non alpha");
		}
		String patientPrenom = request.getParameter("patientprenom");
		if (!Utilitaires.isAlpha(patientPrenom)) {
			messages.put("prenom", "Prenom non alpha");
			System.out.println("cprenom non alpha");
		}
		String patientTel = request.getParameter("phoneP");
		if (!Utilitaires.isTelNumber(patientTel)) {
			messages.put("tel", "format tel incorrect");
			System.out.println("format tel incorrect");
		}
		String patientAdr = request.getParameter("adresseP");
		int patientYear = Integer.parseInt(request.getParameter("annee"));
		if (!Utilitaires.isGoodDate(patientYear)) {
			messages.put("annee", "annee non correcte");
			System.out.println("annee non correcte");
		}
		String patientMDP = request.getParameter("mdpP");

		Patient p = new Patient();
		p.setEmailPatient(patientMail);
		p.setNOMPatient(patientNom);
		p.setPRENOMPatient(patientPrenom);
		p.setNumTelePatient(patientTel);
		p.setAddressHabitPatient(patientAdr);
		p.setANNEENaissance(patientYear);
		p.setMDPPatient(patientMDP);
		p.setEtatP("Actif");

		boolean patientCree = false;
		if (messages.isEmpty()) {
			patientCree = servicesPatientBean.ajouterPatient(p);

			if (patientCree) {
				// Envoi mail à mettre dans une classe à part ?

				String sujet = "Création de compte RDVMed";
				String msg = "Bonjour " + patientPrenom + " , un compte a été créé avec votre email : " + patientMail;
				servicesMailBean.envoiMail(msg, sujet, patientMail, session);
				messages.put("info", "Compte créé");
				getServletContext().getRequestDispatcher("/Accueil.jsp").forward(request, response);
			} else {
				messages.put("existant", "Compte déjà existant");
				System.out.println("compte deja existant");
				getServletContext().getRequestDispatcher("/Patient/Patient_registre.jsp").forward(request, response);
			}
		} else {
			getServletContext().getRequestDispatcher("/Patient/Patient_registre.jsp").forward(request, response);
		}

	}

}
