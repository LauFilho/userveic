package com.desafioorange.usuveicapi.entity;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_vehicle")
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String marca;
	private String modelo;
	private String ano;
	private Date diaRodizio;
	private Boolean statusRodizio;
	
	@ManyToOne
	private User user;

	public Vehicle() {

	}

	public Vehicle(Long id, String marca, String modelo, String ano, Date diaRodizio, Boolean statusRodizio, User user,
			LocalDate dataNascimento) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.diaRodizio = diaRodizio;
		this.statusRodizio = statusRodizio;
		this.user = user;
		
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getAno() {
		return ano;
	}

	public Date getDiaRodizio() {
		return diaRodizio;
	}

	public Boolean getStatusRodizio() {
		return statusRodizio;
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

	public void setAno(String ano) {
		this.ano = ano;
	}

	public void setDiaRodizio(Date diaRodizio) {
		this.diaRodizio = diaRodizio;
	}

	public void setStatusRodizio(Boolean statusRodizio) {
		this.statusRodizio = statusRodizio;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
