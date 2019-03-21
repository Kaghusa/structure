/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author olivier
 */
public class notification 

{
    public boolean sendmail(String recipient, String Link)
    
        {
     
            try
        
        
            {

                    Properties props = new Properties();
                    props.put("mail.smtp.host", "mail.terapreneur.com"); // for gmail use smtp.gmail.com
                    props.put("mail.smtp.auth", "true");
                    props.put("mail.debug", "true"); 
                    props.put("mail.smtp.starttls.enable", "false");
                    props.put("mail.smtp.port", "8025");
                    props.put("mail.smtp.socketFactory.port", "465");
                    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                    props.put("mail.smtp.socketFactory.fallback", "true");

                    Session mailSession = Session.getInstance(props, new javax.mail.Authenticator() {

                        protected PasswordAuthentication getPasswordAuthentication() 
                            {
                                return new PasswordAuthentication("erp@terapreneur.com", "Erp@terapreneur123");
                            }
                    });

                    mailSession.setDebug(true); // Enable the debug mode

                    Message msg = new MimeMessage( mailSession );

                    //--[ Set the FROM, TO, DATE and SUBJECT fields
                    msg.setFrom( new InternetAddress( "erp@terapreneur.com" ) );
                    msg.setRecipients( Message.RecipientType.TO,InternetAddress.parse(recipient) );
                    msg.setSentDate( new Date());
                    msg.setSubject( "Account Verification " );

                    //--[ Create the body of the mail
                    msg.setText( "Welcome to Terapreneur ERP, Your soulution in Business Automation Booster \n Please activate your Account  by clicking the link below. \n "+Link+" \n  Enjoy Your new Business Automatin Booster \n Terapreneur Tech. Support Team " );

                    //--[ Ask the Transport class to send our mail message
                    Transport.send( msg );

            }
            
            catch(Exception E)
                {
                    return false;
                }

        
            
            
            
            return true ; 
    }
    
    
    
}
