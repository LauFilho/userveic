package com.desafioorange.usuveicapi.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.lang.NonNull;

import com.desafioorange.usuveicapi.entity.User;
import com.desafioorange.usuveicapi.entity.Vehicle;
import com.fasterxml.jackson.annotation.JsonFormat;

public class UserDTO {

	private Long id;

	@NonNull
	@NotBlank(message = "{campo.nome.obrigatorio}")
	private String nome;

	@NonNull
	@NotBlank(message = "{campo.email.obrigatorio}")
	private String email;

	@NotBlank(message = "{campo.cpf.obrigatorio}")
	@NonNull
	@CPF(message = "{campo.cpf.invalido}")
	@Size(min = 11, max = 11, message = "É obrigatório CPF conter 11 dígitos")
	private String cpf;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;

	private List<Vehicle> vehicle;

	public UserDTO() {
	}

	public User newUser() {

		return new User(nome, cpf, email, dataNascimento);
	}



	public UserDTO(Long id, @NotBlank(message = "{campo.nome.obrigatorio}") String nome,
			@NotBlank(message = "{campo.email.obrigatorio}") String email,
			@NotBlank(message = "{campo.cpf.obrigatorio}") @CPF(message = "{campo.cpf.invalido}") @Size(min = 11, max = 11, message = "É obrigatório CPF conter 11 dígitos") String cpf,
			Date dataNascimento, List<Vehicle> vehicle) {
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}

}
