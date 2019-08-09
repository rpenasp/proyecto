/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shopping.controlador;

import edu.shopping.facades.UsuarioFacadeLocal;
import java.util.Properties;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author roxi9
 */
@Named(value = "correoEnviar")
@RequestScoped
public class CorreoEnviar {

    @EJB
    UsuarioFacadeLocal usuarioFacadeLocal;

    private String correoE = "carritodecompras98";
    private String claveE = "ilovedance123";
    private String correroR;
    private String asunto = "Recuperar Contraseña";
    private String cuerpo="prueba correo";

    public CorreoEnviar() {
    }

    public boolean enviarCorreo() {

        try {
         

            Properties props = System.getProperties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.user", correoE);
            props.put("mail.smtp.clave", claveE);
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.port", "587");

            Session session = Session.getDefaultInstance(props);
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(correoE));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correroR));
            message.setSubject(asunto);
            message.setText(cuerpo);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", correoE, claveE);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            return true;
        } catch (MessagingException me) {
            me.printStackTrace();
            return false;
        }
    }

    public String getCorreroR() {
        return correroR;
    }

    public void setCorreroR(String correroR) {
        this.correroR = correroR;
    }

    

}
