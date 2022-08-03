package com.vendasapi.exceptionhandler;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class VendaExceptionHandler extends ResponseEntityExceptionHandler{

	@Autowired
	private MessageSource messageSource;
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		String messagemUsuario = messageSource.getMessage("messagem.invalida", null, LocaleContextHolder.getLocale());
		String messagemDesenvolverdor = ex.getCause().toString();
		
		
		return handleExceptionInternal(ex, new Erro(messagemUsuario, messagemDesenvolverdor), headers, HttpStatus.BAD_REQUEST, request);
	}
	
	
	public static class Erro {
		
		
		private String messagemUsuario;
		private String messagemDesenvolvedorString;
		
		public Erro(String messagemUsuario, String messagemDesenvolvedorString) {
			super();
			this.messagemUsuario = messagemUsuario;
			this.messagemDesenvolvedorString = messagemDesenvolvedorString;
		}

		public String getMessagemUsuario() {
			return messagemUsuario;
		}

		public void setMessagemUsuario(String messagemUsuario) {
			this.messagemUsuario = messagemUsuario;
		}

		public String getMessagemDesenvolvedorString() {
			return messagemDesenvolvedorString;
		}

		public void setMessagemDesenvolvedorString(String messagemDesenvolvedorString) {
			this.messagemDesenvolvedorString = messagemDesenvolvedorString;
		}
		
		
		
		
	}
}
