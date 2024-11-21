package edu.du.project1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Random;

@Service
@Transactional
@RequiredArgsConstructor
public class JoinMailServiceImpl implements MailService {

    private final JavaMailSender mailSender;

    private String code;


    @Override
    public MimeMessage CreateMessage(String to) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();

        message.addRecipients(MimeMessage.RecipientType.TO, to); //보내는 대상
        message.setSubject("회원가입 인증번호");

        String msgg="";
        msgg += "<div style='margin:100px'>";
        msgg += "<h1> 안녕하세요</h1>";
        msgg += "<h1> 책방 입니다.";
        msgg += "<p> 아래의 코드를 입력란에다가 작성해주기시 바랍니다.<p>";
        msgg += "<h3 style='color:red;'>회원가입 인증 코드입니다.</h3>";
        msgg += "<div style='font-size:130%'>";
        msgg += "CODE : <strong>";
        msgg += code + "</strong><div><br/> "; //
        msgg += "</div>";


        message.setText(msgg,"utf-8","html");
        message.setFrom(new InternetAddress("네이버 이메일주소", "보내는 사용자이름"));

        return message;
    }

    @Override
    public String sendSimpleMessage(String to) throws Exception {
        code = createKey();
        MimeMessage message = CreateMessage(to);
        try {
            mailSender.send(message);
        }catch (MailException e){
            e.printStackTrace();
            throw new IllegalStateException();
        }
        return code;
    }

    @Override
    public String createKey() {
        Random random = new Random();
        int key = 100000+ random.nextInt(900000);

        return String.valueOf(key);
    }
}

