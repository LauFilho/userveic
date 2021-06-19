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

import com.desafioorange.usuveicapi.dto.VehicleFipeDTO;
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

	// Retorna as marcas de determinado tipo de Veiculo(moto, carro etc)
	@GetMapping("/{tipoVeiculo}/marcas")
	public ResponseEntity<List<VehicleFipeDTO>> getMarcas(@PathVariable String tipoVeiculo) {

		List<VehicleFipeDTO> lista = vehicleService.listaMarcas(tipoVeiculo);
		return ResponseEntity.ok(lista);
	}

	// Retorna o modelo de determinado tipo e de determinada marca
	@GetMapping("/{tipoVeiculo}/marcas/{idmarca}/modelos")
	public ResponseEntity<VehicleFipeDTO> getModelos(@PathVariable String tipoVeiculo, @PathVariable Long idmarca) {
		VehicleFipeDTO modelo = vehicleService.listaModelos(tipoVeiculo, idmarca);

		return ResponseEntity.ok().body(modelo);
	}

	// Retorna os anos de determinados modelos de determinado tipos e de determinadas marcas
	@GetMapping("/{tipoVeiculo}/marcas/{idmarca}/modelos/{idmodelo}/anos")
	public ResponseEntity<List<VehicleFipeDTO>> getAnos(@PathVariable String tipoVeiculo, @PathVariable Long idmarca, @PathVariable Long idmodelo) {
		List<VehicleFipeDTO> anos = vehicleService.listaModelosAnos(tipoVeiculo, idmarca, idmodelo);

		return ResponseEntity.ok().body(anos);
	}

	// Retorna o veiculo especifico no determinado 
	//ano especifico de determinado modelo de determinado tipo e de determinada marca
	
	@GetMapping("/{tipoVeiculo}/marcas/{idmarca}/modelos/{idmodelo}/anos/{idano}")
    public ResponseEntity<VehicleFipeDTO> getModelo(@PathVariable String tipoVeiculo, @PathVariable Long idmarca, @PathVariable Long idmodelo, @PathVariable String idano) {
		VehicleFipeDTO veiculo = vehicleService.getModelo(tipoVeiculo, idmarca, idmodelo, idano);
        return ResponseEntity.ok(veiculo);
    }
	
	//Insere um veículo para um determinado usuário atráves do id do Usuário
	@PostMapping("users/{id}")
	@ResponseStatus(HttpStatus.CREATED) // 201
	public ResponseEntity<Void> insertVehicle(@RequestBody VehicleFipeDTO vehicleFipeDTO, @PathVariable Long id) {
		
		vehicleService.insert(vehicleFipeDTO, id);
		return ResponseEntity.status(HttpStatus.CREATED).build() ;
	}

}
