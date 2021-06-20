package com.desafioorange.usuveicapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
//@Table(name = "tb_vehicle")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String marca;
	private String modelo;
	private Integer ano;
	private String diaRodizio;
	private Boolean statusRodizio;

	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;

	public Vehicle() {

	}

	public Vehicle(Long id, String marca, String modelo, Integer ano, String diaRodizio, Boolean statusRodizio) {
		
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.diaRodizio = diaRodizio;
		this.statusRodizio = statusRodizio;

	}

	public Vehicle(String marca, String modelo, Integer ano) {

		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		

	}
	
	

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public Integer getAno() {
		return ano;
	}


	public User getUser() {
		return user;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public String getDiaRodizio() {
		return diaRodizio;
	}

	public Boolean getStatusRodizio() {
		return statusRodizio;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDiaRodizio(String diaRodizio) {
		this.diaRodizio = diaRodizio;
	}

	public void setStatusRodizio(Boolean statusRodizio) {
		this.statusRodizio = statusRodizio;
	}

}
