package opms.project.loginreg;
import java.util.Properties;    
import javax.mail.*;    
import javax.mail.internet.*;    

class SendEmail{
	static String from = "opmsproject2018@gmail.com";
	static String password = "opmsproject";
    public static void send(String to, int randNum, String path, String username){  
          //Get properties object 
    	  StringBuilder sb = new StringBuilder("Please click Following link to activate your account "
    	  								+ "in CDAC project Management System"
    			  				+ "\n" + path + "_verification?username="+ username + "&code=" + randNum);
    	  String sub = "Email Verification for CDAC Project Management System Account";
    	  String msg = sb.toString();
          Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");    
          //get Session   
          Session session = Session.getDefaultInstance(props,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(SendEmail.from,SendEmail.password);  
           }    
          });
          //compose message    
          try {    
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
           message.setSubject(sub);    
           message.setText(msg);    
           //send message  
           Transport.send(message);    
           System.out.println("message sent successfully");    
          } catch (MessagingException e) {throw new RuntimeException(e);}    
             
    }  
}  

