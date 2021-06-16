package com.desafioorange.usuveicapi.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import com.desafioorange.usuveicapi.entity.User;
import com.desafioorange.usuveicapi.entity.Vehicle;
import com.fasterxml.jackson.annotation.JsonFormat;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	private Long id;
	@NotBlank(message = "{campo.nome.obrigatorio}")
	private String nome;
	
	@NotBlank(message = "{campo.email.obrigatorio}")
	private String email;
	
	@NotBlank(message = "{campo.cpf.obrigatorio}")
	@CPF(message = "{campo.cpf.invalido}")
	private String cpf;
	
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate  dataNascimento;
	
	private List<Vehicle> vehicle;
	
	public UserDTO() {
	}

	public UserDTO(Long id, 
			@NotBlank(message = "{campo.nome.obrigatorio}") String nome,
			@NotBlank(message = "{campo.email.obrigatorio}") String email,
			@NotBlank(message = "{campo.cpf.obrigatorio}") 
			@CPF(message = "{campo.cpf.invalido}") String cpf,
			LocalDate dataNascimento, List<Vehicle> vehicle) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.vehicle = vehicle;
	}



	public UserDTO(User p) {
		this.id = p.getId();
		this.nome = p.getNome();
		this.email = p.getEmail();
		this.cpf = p.getCpf();
		this.dataNascimento = p.getDataNascimento();
		this.vehicle = p.getVehicle();
	}
	// Getters e Setters Omissos

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}

	
}
