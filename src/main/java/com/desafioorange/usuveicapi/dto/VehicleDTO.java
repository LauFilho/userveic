package com.desafioorange.usuveicapi.dto;

import com.desafioorange.usuveicapi.entity.Vehicle;
import com.desafioorange.usuveicapi.service.RodizioService;

public class VehicleDTO {

	private Integer ano;
	private String marca;
	private String modelo;

	public VehicleDTO() {

	}
	
	//Retorna o dia do rodizio do veículo
	public String getDiaRodizio() {

		return RodizioService.diaRodizio(this.ano);

	}

	// Checa se é dia de rodizio
	public boolean isRodizio() {

		return RodizioService.isDiaRodizio(this.ano);

	}

	public VehicleDTO(Integer ano, String marca, String modelo) {
		this.ano = ano;
		this.marca = marca;
		this.modelo = modelo;
	}
	
	public VehicleDTO(Vehicle vehicle) {
		this.ano = vehicle.getAno();
		this.marca = vehicle.getMarca();
		this.modelo = vehicle.getModelo();
	}

	public Integer getAno() {
		return ano;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

}