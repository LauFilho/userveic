package com.desafioorange.usuveicapi.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Range;

import com.desafioorange.usuveicapi.entity.Vehicle;
import com.desafioorange.usuveicapi.service.RodizioService;

public class VehicleDTO {

	@NotBlank(message = "{campo.veiculo.marca}")
	private String marca;
	@NotBlank(message = "{campo.veiculo.modelo}")
	private String modelo;
	@NotBlank(message = "{campo.veiculo.ano}")
	@Range(min = 1900, max = 9999, message = "Ano no formato XXXX")
	private Integer AnoModelo;

	@NotBlank(message = "{campo.userid.naoexiste}")
	private Long idUser;
	// Retorna o dia do rodizio do veículo
	public String getDiaRodizio() {
		return RodizioService.diaRodizio(AnoModelo);
	}
	// Checa se é dia de rodizio
	public boolean isRodizio() {
		return RodizioService.isDiaRodizio(AnoModelo);
	}
	public Vehicle toVehicle() {
		return new Vehicle(idUser, marca, modelo, AnoModelo, getDiaRodizio(), isRodizio());
	}
	public VehicleDTO() {

	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public Integer getAnoModelo() {
		return AnoModelo;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setAnoModelo(Integer AnoModelo) {
		this.AnoModelo = AnoModelo;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

}