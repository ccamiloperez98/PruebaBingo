package com.example.bingo.exception;

import java.time.LocalDateTime;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 
 * @author Cristian Pérez
 * Clase manejador de excepciones
 */
@ControllerAdvice
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {
	
	private LocalDateTime ldt=LocalDateTime.now();
	
	@ExceptionHandler(ModelNotFoundException.class)
	public final ResponseEntity<StandardError> ModelNotFoundExceptionHandler(ModelNotFoundException ex, WebRequest request){
		StandardError error= new StandardError(ldt, HttpStatus.NOT_FOUND.toString(),HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<StandardError>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ArgumentRequiredException.class)
	public final ResponseEntity<StandardError> ArgumentRequiredExceptionHandler (ArgumentRequiredException ex, WebRequest request){
		StandardError error = new StandardError(ldt,HttpStatus.BAD_REQUEST.toString(), HttpStatus.BAD_REQUEST.getReasonPhrase(), ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<StandardError>(error, HttpStatus.BAD_REQUEST);			
	}
	
	@ExceptionHandler(NullPointerException.class)
	public final ResponseEntity<StandardError> NullPointerExceptionHandler (NullPointerException ex, WebRequest request){
		StandardError error = new StandardError(ldt, HttpStatus.INTERNAL_SERVER_ERROR.toString(),
				HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<StandardError>(error, HttpStatus.INTERNAL_SERVER_ERROR);			
	}
	
	@ExceptionHandler(ArithmeticException.class)
	public final ResponseEntity<StandardError> ArithmeticExceptionHandler (ArithmeticException ex, WebRequest request){
		StandardError error = new StandardError(ldt, HttpStatus.INTERNAL_SERVER_ERROR.toString(),
				HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<StandardError>(error, HttpStatus.INTERNAL_SERVER_ERROR);			
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<StandardError>ExceptionHandler (Exception ex, WebRequest request){
		StandardError error = new StandardError(ldt, HttpStatus.INTERNAL_SERVER_ERROR.toString(),
				HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<StandardError>(error, HttpStatus.INTERNAL_SERVER_ERROR);			
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		StandardError error = new StandardError(ldt, HttpStatus.BAD_REQUEST.toString(),HttpStatus.BAD_REQUEST.getReasonPhrase(),
				"El Json no tiene la estructura adecuada",request.getDescription(false));
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);			
		
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		StandardError error = new StandardError(ldt,HttpStatus.UNSUPPORTED_MEDIA_TYPE.toString(),
				HttpStatus.UNSUPPORTED_MEDIA_TYPE.getReasonPhrase(),  "Tipo de informacion no soportado",request.getDescription(false));
		return new ResponseEntity<Object>(error, HttpStatus.UNSUPPORTED_MEDIA_TYPE);			
		
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		StandardError error = new StandardError(ldt, HttpStatus.BAD_REQUEST.toString(),
				HttpStatus.BAD_REQUEST.getReasonPhrase(),ex.getBindingResult().getFieldError().getDefaultMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);			
	}

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		StandardError error = new StandardError(ldt, HttpStatus.METHOD_NOT_ALLOWED.toString(),HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(error, HttpStatus.METHOD_NOT_ALLOWED);			
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		StandardError error = new StandardError(ldt, HttpStatus.BAD_REQUEST.toString(),HttpStatus.BAD_REQUEST.getReasonPhrase(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		StandardError error = new StandardError(ldt, HttpStatus.NOT_FOUND.toString(),HttpStatus.NOT_FOUND.getReasonPhrase(), "No encontrado", request.getDescription(false));
		return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
	}
	
}
