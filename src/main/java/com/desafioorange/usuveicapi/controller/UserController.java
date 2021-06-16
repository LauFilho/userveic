package com.desafioorange.usuveicapi.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.desafioorange.usuveicapi.entity.User;
import com.desafioorange.usuveicapi.repository.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired// É responsável pela injeção de dependência
	UserRepository repository;
	
	@GetMapping // Notação usada para retornar dados
	public List<User> findAll() {
		
		return repository.findAll();
		
	}

	@PostMapping // Notação usada para escrever dados
	@ResponseStatus(HttpStatus.CREATED) // 201
	public User save(@RequestBody User user, HttpServletResponse response) {
		
		return repository.save(user);
	}
	
}
	
	

