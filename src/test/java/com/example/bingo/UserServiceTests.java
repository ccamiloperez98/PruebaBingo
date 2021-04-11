package com.example.bingo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.bingo.service.IUserService;

@SpringBootTest
public class UserServiceTests {

	@Autowired
	private IUserService service;
	
	@Test
	void testFind() {
		service.find(7725);
		System.out.println("testFind()");
		assertTrue(true);
	}
}
