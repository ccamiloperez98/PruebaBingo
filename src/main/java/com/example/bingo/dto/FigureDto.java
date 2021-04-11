package com.example.bingo.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

/**
 * Clase dto de figura
 * @author Cristian
 *
 */
public class FigureDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotNull (message = "Id es requerido")
	private Integer idFigure;
	
	@NotNull (message = "Nombre es requerido")
	private String figureName;
	
	@NotNull (message = "Array de boolean es requerido")
	private List<Boolean> positionsWinner;
	

	public Integer getIdFigure() {
		return idFigure;
	}

	public void setIdFigure(Integer idFigure) {
		this.idFigure = idFigure;
	}

	public String getFigureName() {
		return figureName;
	}

	public void setFigureName(String figureName) {
		this.figureName = figureName;
	}

	public List<Boolean> getPositionsWinner() {
		return positionsWinner;
	}

	public void setPositionsWinner(List<Boolean> positionsWinner) {
		this.positionsWinner = positionsWinner;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
