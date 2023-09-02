package com.OpenWeather.Request.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.OpenWeather.Request.Services.EmailBatchService;

import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/")

public class EmailBatchController {
	private static final Logger logger = LoggerFactory.getLogger(EmailBatchService.class);

	@Autowired
	private EmailBatchService emailBatchService;

	@PostMapping("/run-batch")
	public String runEmailBatch() throws MessagingException {

		try {
			emailBatchService.sendEmailsToAllUsers(); // Ejecuta el proceso batch para enviar correos
		} catch (HttpClientErrorException ex) {
			logger.error("Error al obtener datos meteorológicos: " + ex.getMessage(), ex);
		}

		return "Proceso batch completado";
	}
}