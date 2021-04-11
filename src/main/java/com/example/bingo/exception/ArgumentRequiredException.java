package com.example.bingo.exception;

/**
 * 
 * @author Cristian Pérez
 * Clase excepción personalizada ArgumentRequired
 */
public class ArgumentRequiredException  extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public ArgumentRequiredException(String mensaje) {		
		super(mensaje);
	}

}