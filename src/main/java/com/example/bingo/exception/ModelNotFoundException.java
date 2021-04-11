package com.example.bingo.exception;

/**
 * 
 * @author Cristian Pérez
 * Clase excepción personalizada ModelNotFound
 */
public class ModelNotFoundException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;

	public ModelNotFoundException(String message) {
		super(message);
	}
}
