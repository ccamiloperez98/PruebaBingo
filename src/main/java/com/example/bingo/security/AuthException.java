package com.example.bingo.security;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author 
 * Clase error autenticacion
 */
public class AuthException implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException arg2)
			throws IOException, ServletException {
		final Map<String, Object> mapException = new HashMap<>();

		arg2.printStackTrace();
		
		mapException.put("status", "401");
		mapException.put("error", "UNAUTHORIZED");
		mapException.put("message", "No estas autorizado...");
		mapException.put("path", request.getServletPath());
		mapException.put("timestamp", LocalDateTime.now());

		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

		final ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getOutputStream(), mapException);
	}
}
