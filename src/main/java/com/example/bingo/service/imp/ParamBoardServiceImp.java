package com.example.bingo.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.bingo.dto.FigureBoardDto;
import com.example.bingo.entity.game.ParamBoard;
import com.example.bingo.repo.game.IParamBoardRepo;
import com.example.bingo.service.IParamBoardService;

/**
 * Clase ParamBoardServiceImp que contiene el core o logica relacionada con ParamBoard
 * @author Cristian
 *
 */
@Service
public class ParamBoardServiceImp implements IParamBoardService {

	@Autowired
	private IParamBoardRepo repoParamBoard;

	/**
	 * Metodo que obtiene listado de cartones (Paginados)
	 * @return Page<ParamBoard>
	 */
	@Override
	public Page<ParamBoard> getParamBoards(Integer page, Integer size) {
		Page<ParamBoard> paramBoards = repoParamBoard.findAll(PageRequest.of(page, size));
		return paramBoards;
	}

	/**
	 * Metodo que busca los cartones ganadores en la tabla cartones de acuerdo a una figura y lista de numeros
	 * @return Page<ParamBoard>
	 */
	@Override
	public List<ParamBoard> getWinnerParamBoards(FigureBoardDto figureBoard) {
		List<ParamBoard> winnerBoards = new ArrayList<>();
		ArrayList<Integer> winnerPositions = new ArrayList<>();
		ArrayList<Integer> winnerNumbers = new ArrayList<>();

		for (int i = 0; i < figureBoard.getFigure().size(); i++) {
			if (figureBoard.getFigure().get(i) != null) {
				if (figureBoard.getFigure().get(i) == true) {
					winnerPositions.add(i);
				}
			}
		}

		for (int i = 0; i < winnerPositions.size(); i++) {
			int auxNumber = figureBoard.getBoardNumbers().get(winnerPositions.get(i));
			winnerNumbers.add(auxNumber);
		}
		//System.out.println("Numeros Ganadores: ---------"+ winnerNumbers);
		
		
		int page=0;
		Page<ParamBoard> boards = repoParamBoard.findIdAndNumbers(PageRequest.of(page, 100, Sort.by("idBoard").ascending()));
		
		do {
			for (ParamBoard board : boards) {
				ArrayList<Integer> numbers = new ArrayList<>();
				for (int i = 0; i < winnerPositions.size(); i++) {
					int aux = board.getBoardNumbers().get(winnerPositions.get(i));
					numbers.add(aux);
				}
				//System.out.println("Evaluando ---------- "+numbers);
				
				if(winnerNumbers.equals(numbers)) {
					winnerBoards.add(board);
				};  
			}
			
			page=page+1;
		    boards = repoParamBoard.findIdAndNumbers(PageRequest.of(page, 100, Sort.by("idBoard").ascending()));
		}while(page<=2); // Actualmente solo evalua 3 paginas.. para todos--> boards.getTotalPages(), pero tarda mucho tiempo.

		return winnerBoards;
	}
}
