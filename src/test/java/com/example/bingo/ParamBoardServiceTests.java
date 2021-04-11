package com.example.bingo;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.example.bingo.dto.FigureBoardDto;
import com.example.bingo.entity.game.ParamBoard;
import com.example.bingo.service.IParamBoardService;

@SpringBootTest
public class ParamBoardServiceTests {

	@Autowired
	private IParamBoardService service;
	
	@Test
	void testGetPageableBoards() {
		Page<ParamBoard> listaPaginaAutor = service.getParamBoards(1, 5);
		System.out.println("testGetPageableBoards()");
		assertNotEquals(listaPaginaAutor, null);
	}
	

	@Test
	void testWinnerBoards() {
		Boolean[] figure= {true,false,false,false,false,true,false,false,false,false,true,false,null,false,false,
						   true,false,false,false,false,true,true,true,true,true};
		Integer[] boardNumbers= {1,16,31,46,61,2,17,32,47,62,3,18,null,48,63,
		                         4,19,33,49,64,5,20,34,50,65};
		
		List<Boolean> listFigure = Arrays.asList(figure);
		List<Integer> listNumbers = Arrays.asList(boardNumbers);
		FigureBoardDto figureBoard= new FigureBoardDto();
		figureBoard.setFigure(listFigure);
		figureBoard.setBoardNumbers(listNumbers);
		service.getWinnerParamBoards(figureBoard);
		System.out.println("testWinnerBoards()");
		assertTrue(true);
	}
	
}
