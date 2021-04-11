package com.example.bingo;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.bingo.entity.game.ParamFigure;
import com.example.bingo.service.IParamFigureService;

@SpringBootTest
public class ParamFigureServiceTests {
	
	@Autowired
	private IParamFigureService service;
	
	@Test
	void testGetAllFigures() {
		List<ParamFigure> listFigures = service.getAllFigures();
		System.out.println("testGetAllFigures()");
		assertNotEquals(listFigures, null);
	}
}
