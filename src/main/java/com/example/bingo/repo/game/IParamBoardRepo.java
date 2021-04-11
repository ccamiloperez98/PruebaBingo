package com.example.bingo.repo.game;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.bingo.entity.game.ParamBoard;

/**
 * 
 * @author Cristian Pérez
 * Interfaz repository de ParamBoard
 */
@Repository
public interface IParamBoardRepo extends JpaRepository<ParamBoard, Integer>{

	/**
	 * @param pageable
	 * @return Page<ParamBoard> 
	 */
	@Query(value = "SELECT p FROM ParamBoard p")
	public Page<ParamBoard> findIdAndNumbers(Pageable pageable);

}
