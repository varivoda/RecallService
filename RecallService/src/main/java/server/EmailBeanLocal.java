package server;

import javax.ejb.Local;
import javax.mail.MessagingException;

@Local
public interface EmailBeanLocal {
	
	public void send(String subject, String text) throws MessagingException;
}
