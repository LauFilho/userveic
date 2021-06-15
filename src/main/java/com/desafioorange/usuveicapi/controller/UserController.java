package com.desafioorange.usuveicapi.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	@GetMapping // Notação usada para retornar dados
	public ResponseEntity<List<User>> findAll() {
		List<User> list = new ArrayList<>();
		list.add(new User(1L, "Laudelino Filho", "laualmeidafilho@hotmail.com", "12345678901", LocalDate.now()));
		list.add(new User(2L, "Samara Farias", "laualmeidafilho@hotmail.com", "12345678901", LocalDate.now()));

		return ResponseEntity.ok().body(list);
	}

	@Autowired
	UserRepository repository;

	@PostMapping // Notação usada para escrever dados
	@ResponseStatus(HttpStatus.CREATED) // 201
	public User save(@RequestBody User user) {
		return repository.save(user);
	}

}
