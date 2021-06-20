package com.desafioorange.usuveicapi.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.desafioorange.usuveicapi.dto.VehicleFipeDTO;

@FeignClient(name = "tabelaFipe", url = "https://parallelum.com.br/fipe/api/v1")
public interface VehicleFipeService {

	@GetMapping("/{tipoVeiculo}/marcas")
	List<VehicleFipeDTO> getMarcas(@PathVariable("tipoVeiculo") String tipoVeiculo);

	@GetMapping("/{tipoVeiculo}/marcas/{idmarca}/modelos")
	VehicleFipeDTO getModelos(@PathVariable("tipoVeiculo") String tipoVeiculo,@PathVariable("idmarca") Long idmarca);

	@GetMapping("/{tipoVeiculo}/marcas/{idmarca}/modelos/{idmodelo}/anos")
    List<VehicleFipeDTO> getAnos(@PathVariable("tipoVeiculo") String tipoVeiculo, @PathVariable("idmarca") Long idmarca, @PathVariable("idmodelo") Long idmodelo);

    @GetMapping("/{tipoVeiculo}/marcas/{idmarca}/modelos/{idmodelo}/anos/{idano}")
    Object getModeloValor(@PathVariable("tipoVeiculo") String tipoVeiculo, @PathVariable("idmarca") Long idmarca, @PathVariable("idmodelo") Long idmodelo, @PathVariable("idano") String idano);
    
    
}
