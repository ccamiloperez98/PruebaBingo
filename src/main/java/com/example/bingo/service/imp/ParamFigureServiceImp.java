package com.example.bingo.service.imp;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bingo.dto.FigureDto;
import com.example.bingo.entity.game.ParamFigure;
import com.example.bingo.exception.ArgumentRequiredException;
import com.example.bingo.repo.game.IParamFigureRepo;
import com.example.bingo.service.IParamFigureService;

/**
 * Clase ParamFigureServiceImp que contiene el core o logica relacionada con ParamFigure
 * @author Cristian
 *
 */
@Service
public class ParamFigureServiceImp implements IParamFigureService {
	
	@Autowired
	private IParamFigureRepo repoParamFigure;

	/**
	 * Metodo para listar todas las figuras
	 * @return  List<ParamFigure>
	 */
	@Override
	public List<ParamFigure> getAllFigures() {
		return repoParamFigure.findAll();
	}

	/**
	 * Metodo para editar figuras
	 * @return ParamFigure Editada
	 */
	@Override
	public ParamFigure editFigure(FigureDto figure) {
		if (figure.getIdFigure()== null) throw new ArgumentRequiredException("El id de Figura es requerido");
		ParamFigure actFigure=repoParamFigure.findByIdFigure(figure.getIdFigure());
		LocalDateTime ldt=LocalDateTime.now();
		actFigure.setFigureName(figure.getFigureName());
		actFigure.setPositionsWinner(figure.getPositionsWinner());
		actFigure.setLastUpdatedAt(ldt);
		repoParamFigure.save(actFigure);
		return actFigure;
	}

}
