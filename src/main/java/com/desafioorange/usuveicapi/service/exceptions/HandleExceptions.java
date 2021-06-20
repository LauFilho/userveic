package com.desafioorange.usuveicapi.service.exceptions;

import java.time.OffsetDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandleExceptions extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserException.class)
	public ResponseEntity<Object> userHandler(UserException ex, WebRequest request) {
		Erro erro = new Erro();
		HttpStatus status = HttpStatus.BAD_REQUEST;
		erro.setStatus(status.value());
		erro.setTituloString(ex.getMessage());
		erro.setDataHora(OffsetDateTime.now());
		
		return super.handleExceptionInternal(ex, erro, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler(VeiculoException.class)
	public ResponseEntity<Object> veiculoHandler(VeiculoException ex, WebRequest request) {
		Erro erro = new Erro();
		HttpStatus status = HttpStatus.BAD_REQUEST;
		erro.setStatus(status.value());
		erro.setTituloString(ex.getMessage());
		erro.setDataHora(OffsetDateTime.now());
		
		return super.handleExceptionInternal(ex, erro, new HttpHeaders(), status, request);
	}
	

}
