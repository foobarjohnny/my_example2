package com.epaide.email;

import java.io.IOException;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.TemplateException;

/**
 * MIME邮件服务类.
 * 
 * @author daragon
 */
public class MimeMailService {

	private final static Log logger = LogFactory.getLog(MimeMailService.class);
	private JavaMailSender mailSender;
	private FreeMarkerConfigurationFactoryBean freeMarkerConfigurer;

	/**
	 * Spring的MailSender.
	 */
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void setFreeMarkerConfigurer(
			FreeMarkerConfigurationFactoryBean freeMarkerConfigurer) {
		this.freeMarkerConfigurer = freeMarkerConfigurer;
	}

	/**
	 * 发送邮件的工具
	 * 
	 * @param message
	 * @param templateName
	 * @param model
	 * @throws IOException
	 * @throws TemplateException
	 * @throws MessagingException
	 */
	public void send(MimeMessage message, String templateName, Map model)
			throws IOException, TemplateException, MessagingException {
		String content = FreeMarkerTemplateUtils.processTemplateIntoString(
				freeMarkerConfigurer.createConfiguration().getTemplate(
						templateName), model);

		message.setText(content);
		mailSender.send(message);
	}

	/**
	 * 发送邮件，不需要使用FreeMarker模板
	 * 
	 * @param message
	 */
	public void send(MimeMessage message) {
		mailSender.send(message);
	}

}
