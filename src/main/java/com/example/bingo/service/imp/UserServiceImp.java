package com.example.bingo.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.bingo.exception.ModelNotFoundException;
import com.example.bingo.repo.user.IUserRepo;
import com.example.bingo.service.IUserService;

/**
 * Clase UserServiceImp que contiene el core o logica relacionada con User
 * @author Cristian
 *
 */
@Service
public class UserServiceImp implements IUserService, UserDetailsService{
	
	@Autowired
	private IUserRepo userRepo;
	
	/**
	 * Metodo para buscar un usuario
	 */
	@Override
	public com.example.bingo.entity.user.User find(Integer id) {
		com.example.bingo.entity.user.User user=userRepo.findByIdUser(id);
		if(user!=null) return userRepo.findByIdUser(id);
		else throw new ModelNotFoundException("Id de usuario no encontrado");
	}
	
	/**
	 * Metodo para autenticar usuario por medio de la contraseña y clave (Login)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		com.example.bingo.entity.user.User user = userRepo.findByUsername(username);
		if(user == null)
			throw new ModelNotFoundException("Usuario o password incorrecto");
		
		if(user.isCredrencialsExpired())
			throw new ModelNotFoundException("Sus creenciales han expirado");
		
		List<GrantedAuthority> rols = new ArrayList<>();
		rols.add(new SimpleGrantedAuthority(user.getRol().getName()));
		
		UserDetails userDetails = new User(user.getUsername(), user.getPassword(), rols);	
		return userDetails;
	}
}
