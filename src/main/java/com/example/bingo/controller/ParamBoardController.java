package com.example.bingo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bingo.dto.FigureBoardDto;
import com.example.bingo.entity.game.ParamBoard;
import com.example.bingo.service.IParamBoardService;

/**
 * Clase Controller donde se encuentran servicios relacionados con boards
 * @author Cristian
 *
 */
@RestController
@RequestMapping("/boards")
public class ParamBoardController {

	@Autowired
	private IParamBoardService serviceParamBoard;
	
	/**
	 * Servicio listar cartones (Paginados)
	 * @param page
	 * @param size
	 * @return Page<ParamBoard>
	 */
	@GetMapping(path = "/getPageableBoards/{page}/{size}")
	public ResponseEntity<Page<ParamBoard>> listPageable(@PathVariable int page,@PathVariable int size) {
		Page<ParamBoard> boards = serviceParamBoard.getParamBoards(page, size);
		return new ResponseEntity<Page<ParamBoard>>(boards, HttpStatus.OK);
	}
	
	/**
	 * Servicio para obtener cartones ganadores
	 * @param figureBoard
	 * @return List<ParamBoard>
	 */
	@PostMapping(path = "/getWinnerBoards")
	public ResponseEntity<List<ParamBoard>> returnWinnerBoards(@RequestBody FigureBoardDto figureBoard) {
	List<ParamBoard> winnerBoards=serviceParamBoard.getWinnerParamBoards(figureBoard);
	return new ResponseEntity<List<ParamBoard>>(winnerBoards, HttpStatus.OK);
	}
	
}
