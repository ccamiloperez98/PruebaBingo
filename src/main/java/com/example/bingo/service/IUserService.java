package com.example.bingo.service;

import org.springframework.stereotype.Component;

import com.example.bingo.entity.user.User;

/**
 * Interfaz service IUserService
 * @author Cristian
 *
 */
@Component
public interface IUserService {

	public User find(Integer id);
}
