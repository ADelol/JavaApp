package fr.dauphine.mido.as.projetjava.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.dauphine.mido.as.projetjava.entityBeans.Patient;
import fr.dauphine.mido.as.projetjava.entityBeans.Utilisateur;
import fr.dauphine.mido.as.projetjava.services.ServicesMailBean;
import fr.dauphine.mido.as.projetjava.services.ServicesPatientBean;

/**
 * Servlet implementation class ServletCreationPatient
 */
@WebServlet("/ServletSuppressionPatient")
public class ServletSuppressionPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	ServicesPatientBean servicesPatientBean;

	@EJB
	ServicesMailBean servicesMailBean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletSuppressionPatient() {
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

		Patient p = (Patient) session.getAttribute("patient");
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur");
		servicesPatientBean.supprimerPatient(p, u);

		String sujet = "Supression de compte RDVMed";
		String msg = "Bonjour " + p.getPRENOMPatient() + " , votre compte RDVMed a bien été confirmée : "
				+ p.getEmailPatient();
		servicesMailBean.envoiMail(msg, sujet, p.getEmailPatient(), session);
		response.sendRedirect("/RDVMed/ServletLogout");

	}

}
