package fr.dauphine.mido.as.projetjava.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.dauphine.mido.as.projetjava.entityBeans.Medecin;
import fr.dauphine.mido.as.projetjava.entityBeans.Utilisateur;
import fr.dauphine.mido.as.projetjava.services.ServicesMailBean;
import fr.dauphine.mido.as.projetjava.services.ServicesMedecinBean;

/**
 * Servlet implementation class ServletCreationPatient
 */
@WebServlet("/ServletSuppressionMedecin")
public class ServletSuppressionMedecin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	ServicesMedecinBean servicesMedecinBean;

	@EJB
	ServicesMailBean servicesMailBean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletSuppressionMedecin() {
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

		Medecin m = (Medecin) session.getAttribute("medecin");
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur");
		servicesMedecinBean.supprimerMedecin(m, u);

		String sujet = "Supression de compte RDVMed";
		String msg = "Bonjour " + m.getPRENOM_Medecin() + " , votre compte RDVMed a bien été supprimé.";
		servicesMailBean.envoiMail(msg, sujet, m.getEMAIL_Medecin(), session);
		response.sendRedirect("/RDVMed/ServletLogout");

	}

}
