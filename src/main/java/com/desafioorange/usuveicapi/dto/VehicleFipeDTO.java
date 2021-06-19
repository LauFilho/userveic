package com.desafioorange.usuveicapi.dto;

import java.util.ArrayList;
import java.util.List;

import com.desafioorange.usuveicapi.entity.Vehicle;

public class VehicleFipeDTO {

	// Variaveis da FIPE
	private String valor;
	private String marca;
	private String modelo;
	private String combustivel;
	private String codigoFipe;
	private String mesReferencia;
	private String SiglaCombustivel;
	private Integer anoModelo;
	private Integer tipoVeiculo;
	private Long idUser;
	private List<VehicleFipeDTO> anos = new ArrayList<>();
	private List<VehicleFipeDTO> modelos = new ArrayList<>();

	public VehicleFipeDTO() {

	}
	
	public Vehicle toVehicle() {
		
		return new Vehicle(idUser,marca,modelo,anoModelo);

	}
	

	public String getValor() {
		return valor;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public String getCodigoFipe() {
		return codigoFipe;
	}

	public String getMesReferencia() {
		return mesReferencia;
	}

	public String getSiglaCombustivel() {
		return SiglaCombustivel;
	}

	public Integer getAnoModelo() {
		return anoModelo;
	}

	public Integer getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public void setCodigoFipe(String codigoFipe) {
		this.codigoFipe = codigoFipe;
	}

	public void setMesReferencia(String mesReferencia) {
		this.mesReferencia = mesReferencia;
	}

	public void setSiglaCombustivel(String siglaCombustivel) {
		SiglaCombustivel = siglaCombustivel;
	}

	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}

	public void setTipoVeiculo(Integer tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	public List<VehicleFipeDTO> getAnos() {
		return anos;
	}

	public List<VehicleFipeDTO> getModelos() {
		return modelos;
	}

	public void setAnos(List<VehicleFipeDTO> anos) {
		this.anos = anos;
	}

	public void setModelos(List<VehicleFipeDTO> modelos) {
		this.modelos = modelos;
	}

}