package com.min.edu.bookctrl;

import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MailController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value = "/mailform.do", method = RequestMethod.GET)
	public String mailForm() {
		
		logger.info("MailController 메일 작성 화면 이동");
		return "book/mailForm";
	}
	
	@RequestMapping(value = "mailSender.do", method = RequestMethod.POST)
	public String mailSender(@RequestParam Map<String, String> map) {
		logger.info("MailController 메일보내기 값{}", map);
		
		//보내는 사람의 메일 주소가 필수 값
		String setFrom = "taewanno93@gmail.com";
		
		//메일을 보내주는 객체 : MimeMessage 생성
		MimeMessage message = mailSender.createMimeMessage();
		
		//MimeMessage는 파일첨부가 있는지, text, html 여부, encoding 
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setFrom(setFrom); //보내는 사람의 이메일주소, 생략하면 안됨
			messageHelper.setTo(map.get("tomail")); //받는 사람의 이메일
			messageHelper.setSubject(map.get("title")); //메일의 제목, 생략가능
			
			messageHelper.setText(map.get("content"), false); //글자의 형태, true: html, false: 글자
			
			//첨부파일 MimeMessageHelper(message, true, "UTF-8"); 2번째 argument의 값이 true인 경우 multi-part로 처리됨
			FileSystemResource fileResource = new FileSystemResource("C:/Users/taewan/Downloads/006101.png");
			messageHelper.addAttachment("수륙챙이.png", fileResource);
			mailSender.send(message);
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		return "redirect:/mailform.do";
	}
}
