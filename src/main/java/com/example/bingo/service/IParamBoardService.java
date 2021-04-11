package com.example.bingo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import com.example.bingo.dto.FigureBoardDto;
import com.example.bingo.entity.game.ParamBoard;

/**
 * Interfaz service IParamBoardService 
 * @author Cristian
 *
 */
@Component
public interface IParamBoardService {

	public Page<ParamBoard> getParamBoards(Integer page, Integer size);
	
	public List<ParamBoard> getWinnerParamBoards(FigureBoardDto figureBoard);
}
