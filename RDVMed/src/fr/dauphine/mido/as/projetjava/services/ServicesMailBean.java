package fr.dauphine.mido.as.projetjava.services;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpSession;

/**
 * Session Bean implementation class ServicesMailBean
 */
@Stateless
@LocalBean
public class ServicesMailBean {

	final static String SOURCE = "localhost";
	final static String PORT = "25";
	final static String APPMAIL = "local@RDVMed.com";

	/**
	 * Default constructor.
	 */
	public ServicesMailBean() {
		// TODO Auto-generated constructor stub
	}

	public boolean envoiMail(String msg, String sujet, String dest, HttpSession session) {
		Properties properties = new Properties();
		properties.put("mail.smtp.host",SOURCE);
		properties.put("mail.smtp.port", PORT);
		Session sessionMail = Session.getInstance(properties);
		Message message = new MimeMessage(sessionMail);

		try {
			message.setFrom(new InternetAddress(APPMAIL));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(dest));
			try {
				message.setSubject(MimeUtility.encodeText("Création de compte RDVMed", "utf-8", "B"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			message.setContent(msg, "text/plain; charset=UTF-8");

			Transport.send(message);
			System.out.println("Message sent successfully");
			return true;
		} catch (AddressException e) {
			e.printStackTrace();
			return false;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
	}
}
