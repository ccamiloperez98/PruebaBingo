package com.example.bingo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bingo.dto.FigureDto;
import com.example.bingo.entity.game.ParamFigure;
import com.example.bingo.service.IParamFigureService;

/**
 * Clase Controller donde se encuentran servicios relacionados con figures
 * @author Cristian
 *
 */
@RestController
@RequestMapping("/figures")
public class ParamFigureController {
	
	@Autowired
	private IParamFigureService serviceParamFigure;
	
	/**
	 * Servicio para obtener lista de figuras
	 * @return List<ParamFigure>
	 */
	@GetMapping(path = "/getAll")
	public ResponseEntity<List<ParamFigure>> getAllFigures(){
		List<ParamFigure> listFigures=serviceParamFigure.getAllFigures();
		return new ResponseEntity<List<ParamFigure>>(listFigures, HttpStatus.OK);
	}
	
	/**
	 * Servicio para editar figura
	 * @param figure
	 * @return Obj ParamFigure editada
	 */
	@PutMapping(path = "/edit")
	public ResponseEntity<ParamFigure> editar(@Valid @RequestBody FigureDto figure){
		ParamFigure editedFigure=serviceParamFigure.editFigure(figure);
		return new ResponseEntity<ParamFigure>(editedFigure,HttpStatus.OK);
	}
}
