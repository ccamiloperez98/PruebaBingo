package com.example.bingo.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

/**
 * Clase dto figureboard
 * @author Cristian
 *
 */
public class FigureBoardDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotNull (message = "Array de boolean es requerido")
	private List<Boolean> figure;
	
	@NotNull (message = "Array de boolean es requerido")
	private List<Integer> boardNumbers;

	public List<Boolean> getFigure() {
		return figure;
	}

	public void setFigure(List<Boolean> figure) {
		this.figure = figure;
	}

	public List<Integer> getBoardNumbers() {
		return boardNumbers;
	}

	public void setBoardNumbers(List<Integer> boardNumbers) {
		this.boardNumbers = boardNumbers;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
