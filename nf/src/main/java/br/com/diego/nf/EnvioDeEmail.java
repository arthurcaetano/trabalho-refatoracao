package br.com.diego.nf;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnvioDeEmail {
	public void enviar(NotaFiscal nota){
		try {
			Message message = new MimeMessage(gereSessao());
			message.setFrom(new InternetAddress("refatoracaoalfa2017@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("caetano_arthur@hotmail.com"));
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
		final String username = "refatoracaoalfa2017@gmail.com";
		final String password = "refatoracao123";

		Session session = Session.getInstance(configure(), new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		return session;
	}

	private Properties configure() {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		return props;
	}
}
