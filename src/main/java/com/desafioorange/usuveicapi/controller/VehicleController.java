package com.desafioorange.usuveicapi.controller;

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

import com.desafioorange.usuveicapi.entity.Vehicle;
import com.desafioorange.usuveicapi.repository.VehicleRepository;

@RestController
@RequestMapping(value = "/")
public class VehicleController {

	@GetMapping("users/{id}/vehicles") // Notação usada para retornar dados
	public ResponseEntity<List<Vehicle>> findAll() {
		List<Vehicle> list = new ArrayList<>();

		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("vehicles") // Notação usada para retornar dados
	public ResponseEntity<List<Vehicle>> findAlls() {
		List<Vehicle> list = new ArrayList<>();

		return ResponseEntity.ok().body(list);
	}
	
	

	@Autowired // É responsável pela injeção de dependência
	VehicleRepository repository;

	@PostMapping // Notação usada para escrever dados
	@ResponseStatus(HttpStatus.CREATED) // 201
	public Vehicle save(@RequestBody Vehicle vehicle) {
		return repository.save(vehicle);
	}

	@GetMapping("")
	public Vehicle findFipe (@RequestBody Vehicle vehicle);
}
}
