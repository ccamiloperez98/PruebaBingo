package com.example.bingo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bingo.entity.user.User;
import com.example.bingo.service.IUserService;

/**
 * Clase Controller donde se encuentran servicios relacionados con users
 * @author Cristian
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private IUserService serviceUser;
	
	/**
	 * Servicio para buscar un usuario por id
	 * @param id
	 * @return User
	 */
	@GetMapping(path = "/find")
	public ResponseEntity<User> find(@RequestParam(value ="id", required = true) int id){
		User resultUser = serviceUser.find(id);
		return new ResponseEntity<User>(resultUser, HttpStatus.OK);
	}
}
