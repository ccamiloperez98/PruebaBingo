package com.example.bingo.exception;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author Cristian Pérez
 * Clase de error (Estandarizar estructura)
 */
public class StandardError {
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime timestapm;
	private String status;
	private String error;
	private String message;
	private String path;
	
	
	public StandardError() {
		super();
	}

	public StandardError(LocalDateTime timestapm, String status, String error, String message, String path) {
		super();
		this.timestapm = timestapm;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}
	
	public LocalDateTime getTimestapm() {
		return timestapm;
	}
	public void setTimestapm(LocalDateTime timestapm) {
		this.timestapm = timestapm;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}
