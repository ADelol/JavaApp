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

import fr.dauphine.mido.as.projetjava.entityBeans.Medecin;
import fr.dauphine.mido.as.projetjava.entityBeans.Utilisateur;
import fr.dauphine.mido.as.projetjava.services.ServicesMedecinBean;
import fr.dauphine.mido.as.projetjava.utils.Utilitaires;

/**
 * Servlet implementation class ServletCreationPatient
 */
@WebServlet("/ServletGestionCompteMedecin")
public class ServletGestionCompteMedecin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	ServicesMedecinBean servicesMedecinBean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletGestionCompteMedecin() {
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

		String medecinMail = request.getParameter("email");
		if (!Utilitaires.isMail(medecinMail)) {
			messages.put("mail", "Format mail incorrect");
			System.out.println("Format mail incorrect");
		}
		String medecinNom = request.getParameter("medecinnom");
		if (!Utilitaires.isAlpha(medecinNom)) {
			messages.put("nom", "Nom non alpha");
			System.out.println("cnom non alpha");
		}
		String medecinPrenom = request.getParameter("medecinprenom");
		if (!Utilitaires.isAlpha(medecinPrenom)) {
			messages.put("prenom", "Prenom non alpha");
			System.out.println("cprenom non alpha");
		}
		String medecinTel = request.getParameter("phone");
		if (!Utilitaires.isTelNumber(medecinTel)) {
			messages.put("tel", "format tel incorrect");
			System.out.println("format tel incorrect");
		}
		String medecinAdr = request.getParameter("adresse");

		String medecinMDP = request.getParameter("mdp");
		Medecin m = (Medecin) session.getAttribute("medecin");
		m.setEMAIL_Medecin(medecinMail);
		m.setNOM_Medecin(medecinNom);
		m.setPRENOM_Medecin(medecinPrenom);
		m.setNumTele_Medecin(medecinTel);
		m.setAddressHabit_Medecin(medecinAdr);
		m.setMDP_Medecin(medecinMDP);

		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur");
		System.out.println(" umdp" + u.getMdp());
		System.out.println("userna" + u.getUsername());

		if (messages.isEmpty()) {
			Medecin medecinModif = servicesMedecinBean.modifierMedecin(m, u.getUsername(), u.getMdp());
			session.setAttribute("medecin", medecinModif);
			session.setAttribute("prenom", medecinModif.getPRENOM_Medecin());
			session.setAttribute("nom", medecinModif.getNOM_Medecin());
			u.setUsername(medecinModif.getEMAIL_Medecin());
			u.setMdp(medecinModif.getMDP_Medecin());
			messages.put("info", "Compte modifié");
			getServletContext().getRequestDispatcher("/Accueil.jsp").forward(request, response);
		} else {
			getServletContext().getRequestDispatcher("/Medecin/GestionCompte.jsp").forward(request, response);
		}
	}

}
