package com.fatec.leilaoEletronicoLp2.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler{
	
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<DefaultError> handleException(EntityNotFoundException e, HttpServletRequest request) {
		
		DefaultError erro = new DefaultError(HttpStatus.NOT_FOUND.value(), e.getMessage());
		return new ResponseEntity<DefaultError>(erro, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<DefaultError> violacaoIntegridade(DataIntegrityViolationException e, HttpServletRequest request) {
		
		DefaultError erro = new DefaultError(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
		return new ResponseEntity<DefaultError>(erro, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(InvalidDataAccessApiUsageException.class)
	public ResponseEntity<DefaultError> idInvalido(InvalidDataAccessApiUsageException e, HttpServletRequest request) {
		
		DefaultError erro = new DefaultError(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
		return new ResponseEntity<DefaultError>(erro, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<DefaultError> nullPointer(NullPointerException e, HttpServletRequest request) {
		
		DefaultError erro = new DefaultError(HttpStatus.NOT_FOUND.value(), e.getMessage());
		return new ResponseEntity<DefaultError>(erro, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DispositivosInformaticaTemLancesException.class)
	public ResponseEntity<DefaultError> diPossuiLances(DispositivosInformaticaTemLancesException e, HttpServletRequest request) {
		
		DefaultError erro = new DefaultError(HttpStatus.UNPROCESSABLE_ENTITY.value(), e.getMessage());
		return new ResponseEntity<DefaultError>(erro, HttpStatus.UNPROCESSABLE_ENTITY);
	}
}
