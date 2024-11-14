package br.com.vbruno.notificacao.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoEmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String remetente;

    private static final String ASSUNTO_NOTIFICACAO = "Status da análise de crédito";

    private final Logger logger = LoggerFactory.getLogger(NotificacaoEmailService.class);

    public void notificar(String destinatario, String message) {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(remetente);
            simpleMailMessage.setTo(destinatario);
            simpleMailMessage.setSubject(ASSUNTO_NOTIFICACAO);
            simpleMailMessage.setText(message);
            javaMailSender.send(simpleMailMessage);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }
}
