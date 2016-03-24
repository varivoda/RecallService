package server;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * EJB предназначенный для отправки сообщения с темой и текстом
 * на зашитый адрес
*/

@Stateless
@LocalBean
public class EmailBean implements EmailBeanLocal {
	
	//Адрес получателя
	private static final String RECIPIENT_ADDRESS = "varivoda_ivan@mail.ru";
	
	//Сессия, которую настраивали в сервере
	@Resource(name="mail/gmail")
	private Session session;
	
    public EmailBean() {
    }
    
    // Отправка сообщения, выкидывает ошибку, которая обрабатывается дальше
    public void send(String subject, String text) throws MessagingException{
    	
    	Message msg = new MimeMessage(session);
	    msg.setSubject(subject);
	    msg.setText(text);
	    msg.setRecipients(RecipientType.TO, InternetAddress.parse(RECIPIENT_ADDRESS));
	    	
	    Transport.send(msg);
    }
}
