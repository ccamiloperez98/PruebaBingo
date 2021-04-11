package com.example.bingo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.bingo.dto.FigureDto;
import com.example.bingo.entity.game.ParamFigure;

/**
 * Interfaz service IParamFigureService 
 * @author Cristian
 *
 */
@Component
public interface IParamFigureService {

	public List<ParamFigure> getAllFigures();
	
	public ParamFigure editFigure(FigureDto figure);
}
