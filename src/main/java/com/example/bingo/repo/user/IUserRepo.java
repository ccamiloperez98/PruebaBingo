package com.example.bingo.repo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bingo.entity.user.User;

/**
 * 
 * @author Cristian Pérez
 * Interfaz repository de User
 */
@Repository
public interface IUserRepo extends JpaRepository<User, Integer> {

	/**
	 * 
	 * @param username
	 * @return Obj User
	 */
	public User findByUsername(String username);
	
	/**
	 * 
	 * @param idUser
	 * @return return Obj User
	 */
	public User findByIdUser(Integer idUser);
	
}
