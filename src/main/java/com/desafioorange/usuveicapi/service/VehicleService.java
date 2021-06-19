package com.desafioorange.usuveicapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.desafioorange.usuveicapi.dto.VehicleDTO;
import com.desafioorange.usuveicapi.dto.VehicleFipeDTO;
import com.desafioorange.usuveicapi.entity.User;
import com.desafioorange.usuveicapi.entity.Vehicle;
import com.desafioorange.usuveicapi.repository.VehicleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service

public class VehicleService {


	@Autowired
	private VehicleRepository vehicleRepository;

	@Autowired
	private VehicleFipeService vehicleFipeService;
	
	public List<Vehicle> listarTodos() {

		return vehicleRepository.findAll();
	}

	public List<VehicleFipeDTO> listaMarcas(String tipoVeiculo) {

		return vehicleFipeService.getListaMarcas(tipoVeiculo);
	}

	public VehicleFipeDTO listaModelos(String tipoVeiculo, Long idMarca) {

		return vehicleFipeService.getListaMarcaModelos(tipoVeiculo, idMarca);
	}

	public List<VehicleFipeDTO> listaModelosAnos(String tipoVeiculo, Long idMarca, Long idModelo) {

		return vehicleFipeService.getListaModeloAnos(tipoVeiculo, idMarca, idModelo);
	}

	public VehicleFipeDTO getModelo(String tipoVeiculo, Long idMarca, Long idModelo, String idAno) {

		Object vehicle = vehicleFipeService.getModelo(tipoVeiculo, idMarca, idModelo, idAno);
		return new ObjectMapper().convertValue(vehicle, VehicleFipeDTO.class);
	}

	public void insert(VehicleFipeDTO newVehicleDTO, Long userid) {
		User user = new User();
		user.setId(userid);
		Vehicle vehicle = newVehicleDTO.toVehicle();	
		vehicle.setUser(user);
		vehicleRepository.save(vehicle);
	}

	public Page<VehicleDTO> listaVeiculoUsuario(Pageable pageable) {

		User user = new User();
		Page<Vehicle> vehicles = vehicleRepository.findByUserId(user.getId(), pageable);
		return vehicles.map(VehicleDTO::new);
	}

//	    public Page<VehicleFipeDTO> listaVeiculoRodizioAtivo(Pageable pageable) {
//	        
//	        Page<Vehicle> vehicles = vehicleRepository.fin(usuario.getId(), RodizioService.digitosFinaisParaHoje(), pageable);
//	        return veiculos.map(VeiculoUsuarioDTO::new);
//	    }

}
