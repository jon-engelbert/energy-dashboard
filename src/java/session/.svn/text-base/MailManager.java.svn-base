/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import java.util.Date;
import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author thien
 */
@Stateless
@LocalBean
public class MailManager {

    @PersistenceContext(unitName = "EnergyDashboardPU")

    private EntityManager em;

  @Resource(name = "mail/[email-account-name]")
  private Session mailSession;

  public void sendMessage(String from, String to, String subject, String msg) throws MessagingException {

     // Create the message object
     Message message = new MimeMessage(mailSession);

     // Adjust the recipients. Here we have only one
     // recipient. The recipient's address must be
     // an object of the InternetAddress class.
     message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to, false));

     // Set the message's subject
     message.setSubject(subject);

     // Insert the message's body
     message.setText(msg);

     // This is not mandatory, however, it is a good
     // practice to indicate the software which
     // constructed the message.
     message.setHeader("X-Mailer", "My Mailer");

     // Adjust the date of sending the message
     Date timeStamp = new Date();
     message.setSentDate(timeStamp);

     // Use the 'send' static method of the Transport
     // class to send the message
     Transport.send(message);
  }    
}
