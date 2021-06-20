package com.desafioorange.usuveicapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.desafioorange.usuveicapi.dto.VehicleDTO;
import com.desafioorange.usuveicapi.entity.Vehicle;
import com.desafioorange.usuveicapi.service.VehicleService;

@RestController
@RequestMapping(value = "/vehicle")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	
	@GetMapping
	public ResponseEntity<List<Vehicle>> findAll(){ 
		List<Vehicle> list = vehicleService.listarTodos();

		return ResponseEntity.ok().body(list);
	}

	//Insere um veículo para um determinado usuário atráves do id do Usuário
	@PostMapping("users/{id}")
	@ResponseStatus(HttpStatus.CREATED) // 201
	public ResponseEntity<Void> insertVehicle(@RequestBody VehicleDTO vehicleDTO, @PathVariable Long id) {
		
		vehicleService.insert(vehicleDTO, id);
		return ResponseEntity.status(HttpStatus.CREATED).build() ;
	}

}
