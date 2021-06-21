package com.desafioorange.usuveicapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioorange.usuveicapi.dto.VehicleDTO;
import com.desafioorange.usuveicapi.entity.User;
import com.desafioorange.usuveicapi.entity.Vehicle;
import com.desafioorange.usuveicapi.exceptions.VehicleException;
import com.desafioorange.usuveicapi.repository.UserRepository;
import com.desafioorange.usuveicapi.repository.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private VehicleRepository vehicleRepository;

	public List<Vehicle> listarTodos() {

		if (vehicleRepository.findAll().isEmpty()) {
			throw new VehicleException("Não há veículos cadastrados!");
		}

		return vehicleRepository.findAll();
	}

	public void insert(VehicleDTO newVehicleDTO, Long userid) {
		if (!userRepository.existsById(userid)) {
			throw new VehicleException("Não foi possível cadastar o veículo! Usuário com esse ID não existe!");
		}

		User user = new User();
		Vehicle vehicle = newVehicleDTO.toVehicle();
		user.setId(userid);
		vehicle.setUser(user);
		vehicleRepository.save(vehicle);
	}

}
