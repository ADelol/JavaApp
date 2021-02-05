package fr.dauphine.mido.as.projetjava.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.ejb.EJB;
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

import fr.dauphine.mido.as.projetjava.entityBeans.Medecin;
import fr.dauphine.mido.as.projetjava.services.ServicesMedecinBean;
import fr.dauphine.mido.as.projetjava.services.ServicesMedecinBean;
import fr.dauphine.mido.as.projetjava.utils.Utilitaires;

/**
 * Servlet implementation class ServletCreationMedecin
 */
@WebServlet("/ServletCreationMedecin")
public class ServletCreationMedecin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	ServicesMedecinBean servicesMedecinBean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCreationMedecin() {
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

		String medecinMail = request.getParameter("emailP");
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
		String medecinTel = request.getParameter("phoneP");
		if (!Utilitaires.isTelNumber(medecinTel)) {
			messages.put("tel", "format tel incorrect");
			System.out.println("format tel incorrect");
		}
		String medecinAdr = request.getParameter("adresseP");

		String medecinMDP = request.getParameter("medecinPrenom");

		Medecin m = new Medecin();
		m.setEMAIL_Medecin(medecinMail);
		m.setNOM_Medecin(medecinNom);
		m.setPRENOM_Medecin(medecinPrenom);
		m.setNumTele_Medecin(medecinTel);
		m.setAddressHabit_Medecin(medecinAdr);
		m.setMDP_Medecin(medecinMDP);
		m.setEtatM("Actif");

		boolean medecinCree = false;
		if (messages.isEmpty()) {
			medecinCree = servicesMedecinBean.ajouterMedecin(m);

			if (medecinCree) {
				// Envoi mail à mettre dans une classe à part ?
				Properties properties = new Properties();
				properties.put("mail.smtp.host", "localhost");
				properties.put("mail.smtp.port", "25");
				String myAccountEmail = "local@RDVMed.com";
				Session sessionMail = Session.getInstance(properties);
				Message message = new MimeMessage(sessionMail);

				try {
					message.setFrom(new InternetAddress(myAccountEmail));
					message.setRecipient(Message.RecipientType.TO, new InternetAddress(medecinMail));
					message.setSubject(MimeUtility.encodeText("Création de compte médecin RDVMed", "utf-8", "B"));
					String msg = "Bonjour " + medecinPrenom + " , un compte médecin a été créé avec votre email : "
							+ medecinMail + ". Vous devez aller changer le mot de passe.";
					message.setContent(msg, "text/plain; charset=UTF-8");
					Transport.send(message);
					System.out.println("Message sent successfully");
				} catch (AddressException e) {
					e.printStackTrace();
				} catch (MessagingException e) {
					e.printStackTrace();
				}

				messages.put("info", "Compte créé");
				getServletContext().getRequestDispatcher("/Accueil.jsp").forward(request, response);
			} else {
				messages.put("existant", "Compte déjà existant");
				System.out.println("compte deja existant");
				getServletContext().getRequestDispatcher("/Medecin/Medecin_registre.jsp").forward(request, response);
			}
		} else {
			getServletContext().getRequestDispatcher("/Medecin/Medecin_registre.jsp").forward(request, response);
		}

	}

}
