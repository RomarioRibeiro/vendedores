package com.vendasapi.exceptionhandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
	
	
	@ExceptionHandler({EmptyResultDataAccessException.class})
   	public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex,  WebRequest request) {
		
		
		String mensagemUsuario = messageSource.getMessage("recurso.nao-encontrado", null, LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = ex.toString();
		
		List<Erro> erros = Arrays.asList(new Erro(mensagemUsuario, mensagemDesenvolvedor));
		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
			

		List<Erro> erros = criarListaDeErros(ex.getBindingResult());
		return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	
	private List<Erro> criarListaDeErros(BindingResult bindingResult) {
		List<Erro> erros = new  ArrayList<>();
		
		for(FieldError fieldError : bindingResult.getFieldErrors()) {
			String messagemUsuario = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
			String messagemDesenvolverdor = fieldError.toString();
			erros.add(new Erro(messagemUsuario, messagemDesenvolverdor));
			
		}
		return erros;
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
