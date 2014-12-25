package extras;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Correo {

	
	
	String email="cristhianp00@gmail.com";
	String codSol="11";
	
	

	private void enviarMail(String mail, String codSol) {
		
		
		// Estos parametros los provee el servder de correos
		final String APIKey = "6fe2f8dbdb7dd77cf8d7754fe043ad12";
		final String SecretKey = "e2a079d19ac48643d298a4a1d3e236ec";
		
		// Aqui va el correo que se usara para enviar los correos
		// Se tiene que usar un correo diferente a los de gmail, yahoo, hotmail
		// Porque esos no tienen certificado para hacer envio de transacciones, que es lo que nosotros hacemos
		// Se usa un mail de dominio, con eso el correo automatico que enviemos no se enviara a la carpeta SPAM
		String From = "sedapar@sedapar.comze.com";
		
		// Aqui va el correo que ingreso el usuario.
		String To = mail;
 
		// El properties es basicamente un objeto en el que se puede almacenar diferentes tipos de datos
		// Aqui guardaremos todas las propiedades del servidor mail
		Properties props = new Properties ();
 
		props.put ("mail.smtp.host", "in.mailjet.com");
		props.put ("mail.smtp.socketFactory.port", "465");
		props.put ("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put ("mail.smtp.auth", "true");
		props.put ("mail.smtp.port", "465");
 
		// Se inicia la sesion del mail
		
		Session session = Session.getDefaultInstance (props,
			new javax.mail.Authenticator ()
			{
				protected PasswordAuthentication getPasswordAuthentication ()
				{
					return new PasswordAuthentication (APIKey, SecretKey);
				}
			});
 
		try
		{
 
		// 	El message es la clase que se encarga de darle el modelo al mail
		
			Message message = new MimeMessage (session);
			message.setFrom (new InternetAddress (From));
			// Aqui se establecen 2 cosas: el tipo de recipiente TO, y en el segundo parseamos  el String que declaramos arriba llamado tambien TO
			message.setRecipients (Message.RecipientType.TO, InternetAddress.parse(To));
			//Este es el titulo del correo
			message.setSubject ("Confirmacion de solicitud de compra de agua de Sedapar");
			//Este es el cuerpo del correo
			message.setText ("Muchas gracias por usar nuestros servicios. Su solicitud con numero "+codSol+"ha sido registrada correctamente. Pronto le estaremos la respuesta a su solicitud.");
 
			//Finalmente se envia  el mail
			Transport.send (message);
 
		}
		catch (MessagingException e)
		{
			throw new RuntimeException (e);
		}
		
	}
	
	
	
}