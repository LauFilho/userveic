package com.desafioorange.usuveicapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafioorange.usuveicapi.dto.VehicleFipeDTO;
import com.desafioorange.usuveicapi.service.VehicleFipeService;

@RestController
@RequestMapping(value = "/vehicle")
public class VehicleFIPEController {

	@Autowired
	private VehicleFipeService vehicleFipeService;

	@GetMapping("/{tipoVeiculo}/marcas")
	public ResponseEntity<List<VehicleFipeDTO>> getMarcas(@PathVariable String tipoVeiculo) {
		List<VehicleFipeDTO> marcas = vehicleFipeService.getMarcas(tipoVeiculo);
		return ResponseEntity.ok(marcas);
	}

	@GetMapping("/{tipoVeiculo}/marcas/{idmarca}/modelos")
	public ResponseEntity<VehicleFipeDTO> getListaModelo(@PathVariable String tipoVeiculo, @PathVariable Long idmarca) {
		VehicleFipeDTO modelos = vehicleFipeService.getModelos(tipoVeiculo, idmarca);
		return ResponseEntity.ok(modelos);
	}

	@GetMapping("/{tipoVeiculo}/marcas/{idmarca}/modelos/{idmodelo}/anos")
	public ResponseEntity<List<VehicleFipeDTO>> getListaAnos(@PathVariable String tipoVeiculo,
			@PathVariable Long idmarca, @PathVariable Long idmodelo) {
		List<VehicleFipeDTO> anos = vehicleFipeService.getAnos(tipoVeiculo, idmarca, idmodelo);
		return ResponseEntity.ok(anos);
	}

	@GetMapping("/{tipoVeiculo}/marcas/{idmarca}/modelos/{idmodelo}/anos/{idano}")
	public ResponseEntity<Object> getModelo(@PathVariable String tipoVeiculo, @PathVariable Long idmarca,
			@PathVariable Long idmodelo, @PathVariable String idano) {
		Object vehicle = vehicleFipeService.getModeloValor(tipoVeiculo, idmarca, idmodelo, idano);
		return ResponseEntity.ok(vehicle);
	}

}
