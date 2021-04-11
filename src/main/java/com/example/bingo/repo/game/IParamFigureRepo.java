package com.example.bingo.repo.game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bingo.entity.game.ParamFigure;

/**
 * 
 * @author Cristian Pérez
 * Interfaz repository de ParamFigure
 */
@Repository
public interface IParamFigureRepo  extends JpaRepository<ParamFigure, Integer>{
	
	/**
	 * 
	 * @param idFigure
	 * @return Obj ParamFigure
	 */
	public ParamFigure findByIdFigure(Integer idFigure);

}
