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
import fr.dauphine.mido.as.projetjava.services.ServicesPatientBean;

/**
 * Servlet implementation class ServletCreationPatient
 */
@WebServlet("/ServletCreationPatient")
public class ServletCreationPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	ServicesPatientBean servicesPatientBean;

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
		String patientMail = request.getParameter("emailP");
		String patientNom = request.getParameter("patientnom");
		String patientPrenom = request.getParameter("patientprenom");
		String patientTel = request.getParameter("phoneP");
		String patientAdr = request.getParameter("adresseP");
		int patientYear = Integer.parseInt(request.getParameter("birthdayP"));
		String patientMDP = request.getParameter("patientPrenom");

		Patient p = new Patient();
		p.setEmailPatient(patientMail);
		p.setNOMPatient(patientNom);
		p.setPRENOMPatient(patientPrenom);
		p.setNumTelePatient(patientTel);
		p.setAddressHabitPatient(patientAdr);
		p.setANNEENaissance(patientYear);
		p.setMDPPatient(patientMDP);
		boolean patientCree = ServicesPatientBean.ajouterPatient(p);
		HttpSession session = request.getSession();
		
		if(patientCree) {
			// Envoyer mail
	        session.setAttribute("msg", "Compte créé");
	        getServletContext().getRequestDispatcher("/Accueil.jsp")
	        .forward(request, response);
		}
		else {
	        session.setAttribute("msg", "Compte déjà existant");
	        System.out.println("compte deja existant");
	        getServletContext().getRequestDispatcher("/Patient/Patient_registre.jsp").forward(request, response);
		}
		
		
        


	}

}
