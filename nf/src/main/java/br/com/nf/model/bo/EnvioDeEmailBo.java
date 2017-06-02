package br.com.nf.model.bo;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.com.nf.model.vo.NotaFiscal;

public class EnvioDeEmailBo {
	
	public void enviar(NotaFiscal nota){
		
		try {
			Message message = new MimeMessage(gereSessao());
			message.setFrom(new InternetAddress("ed.ipo.jose@hotmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("ed.ipo.jose@hotmail.com"));
			message.setSubject("Nota fiscal gerada");
			message.setText(monteTextoDaMensagem(nota));

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	private String monteTextoDaMensagem(NotaFiscal nota){
		return "Nota fiscal gerada no valor de R$ " + nota.getValorBruto() + ", e o imposto calculado foi de R$ " + nota.getValorDoImposto();
	}
	
	private Session gereSessao() {
		
		/*deve-se inserir os dados do e-mail*/
		final String username = "ed.ipo.jose@hotmail.com";
		final String password = "666666666"; 

		Session session = Session.getInstance(configure(), new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		return session;
	}

	private Properties configure() {
		
		Properties props = new Properties();
	    props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.live.com");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
		
		return props;
	}
}
