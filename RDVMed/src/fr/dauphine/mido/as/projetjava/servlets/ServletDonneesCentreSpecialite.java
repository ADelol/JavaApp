package fr.dauphine.mido.as.projetjava.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dauphine.mido.as.projetjava.entityBeans.CentreMedical;
import fr.dauphine.mido.as.projetjava.entityBeans.Specialite;
import fr.dauphine.mido.as.projetjava.services.ServicesCentreMedicalBean;
import fr.dauphine.mido.as.projetjava.services.ServicesSpecialiteBean;

/**
 * Servlet implementation class ServletDonneesCentreSpecialite
 */
@WebServlet("/ServletDonneesCentreSpecialite")
public class ServletDonneesCentreSpecialite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	ServicesSpecialiteBean servicesSpecialiteBean;

	@EJB
	ServicesCentreMedicalBean servicesCentreMedicalBean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletDonneesCentreSpecialite() {
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

		List<CentreMedical> centres = servicesCentreMedicalBean.getAllCentreMedical();
		List<Specialite> specialites = servicesSpecialiteBean.getAllSpecialites();
		request.setAttribute("centres", centres);
		request.setAttribute("specialites", specialites);
		request.setAttribute("test", "test");
		System.out.println(centres);
		getServletContext().getRequestDispatcher("/Administrateur/Medecin_registre.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
