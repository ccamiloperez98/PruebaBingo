package com.example.bingo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Clase Configuracion Cors
 * @author Cristian
 *
 */
@Configuration
public class CORSConfig {
	 @Bean
	    public WebMvcConfigurer CORSConfigurer(){
	        return new WebMvcConfigurer() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry.addMapping("/**")
	                        .allowedOrigins("*")
	                        .allowedMethods("*")
	                        .allowedHeaders("*")
	                        .allowCredentials(false);         
	            }
	        };
	    }
}
