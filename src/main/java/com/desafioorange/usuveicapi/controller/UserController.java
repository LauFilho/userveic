package com.desafioorange.usuveicapi.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.desafioorange.usuveicapi.dto.UserDTO;
import com.desafioorange.usuveicapi.entity.User;
import com.desafioorange.usuveicapi.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = userService.findAll();

		return ResponseEntity.ok().body(list);
	}
	
//	@GetMapping("/{id}")
//	public <Optional>ResponseEntity <User> findUser(@ PathVariable Long UserId) {
//		User user = userService.findUser(UserId);
//		
//
//		return ResponseEntity.ok(user);
//	}

	// Versão inicial pra testar o EndPoint de cadastrar User

	/*
	 * @PostMapping // Notação usada para escrever dados
	 * 
	 * @ResponseStatus(HttpStatus.CREATED) // 201 public User save(@RequestBody User
	 * user, HttpServletResponse response) {
	 * 
	 * return repository.save(user); }
	 */

	@PostMapping
	public ResponseEntity<UserDTO> insertUser(@RequestBody @Valid UserDTO dto) {
		dto = userService.insertUser(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();

		return ResponseEntity.created(uri).body(dto);
	}

}
