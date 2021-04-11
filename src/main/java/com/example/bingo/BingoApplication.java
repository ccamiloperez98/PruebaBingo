package com.example.bingo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses=BingoApplication.class)
public class BingoApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(BingoApplication.class, args);
	}

}
