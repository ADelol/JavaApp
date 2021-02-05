package fr.dauphine.mido.as.projetjava.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.ejb.EJB;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.dauphine.mido.as.projetjava.entityBeans.Patient;
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
		String patientMDP = request.getParameter("patientPrenom");

		Patient p = new Patient();
		p.setEmailPatient(patientMail);
		p.setNOMPatient(patientNom);
		p.setPRENOMPatient(patientPrenom);
		p.setNumTelePatient(patientTel);
		p.setAddressHabitPatient(patientAdr);
		p.setANNEENaissance(patientYear);
		p.setMDPPatient(patientMDP);

		boolean patientCree = false;
		if (messages.isEmpty()) {
			patientCree = servicesPatientBean.ajouterPatient(p);

			if (patientCree) {
				// Envoi mail à mettre dans une classe à part ?
				Properties properties = new Properties();
				properties.put("mail.smtp.host", "localhost");
				properties.put("mail.smtp.port", "25");
				String myAccountEmail = "local@RDVMed.com";
				Session sessionMail = Session.getInstance(properties);
				Message message = new MimeMessage(sessionMail);

				try {
					message.setFrom(new InternetAddress(myAccountEmail));
					message.setRecipient(Message.RecipientType.TO, new InternetAddress(patientMail));
					message.setSubject(MimeUtility.encodeText("Création de compte RDVMed", "utf-8", "B"));
					String msg = "Bonjour " + patientPrenom + " , un compte a été créé avec votre email : " + patientMail;
					message.setContent(msg,"text/plain; charset=UTF-8");

					Transport.send(message);
					System.out.println("Message sent successfully");
				} catch (AddressException e) {
					e.printStackTrace();
				} catch (MessagingException e) {
					e.printStackTrace();
				}


				messages.put("creation", "Compte créé");
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
