package com.desafioorange.usuveicapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioorange.usuveicapi.dto.UserDTO;
import com.desafioorange.usuveicapi.entity.User;
import com.desafioorange.usuveicapi.repository.UserRepository;
import com.desafioorange.usuveicapi.service.exceptions.UserCadastradoException;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> findAll(){
		
		return userRepository.findAll();
	}
	
	public UserDTO save(UserDTO dto){
		this.validaUser(dto);
		
		User entity = new User();
		
		copyDtoToEntity(dto, entity);
		
		entity = userRepository.save(entity);
		
		return new UserDTO(entity);
	}
	
	private void copyDtoToEntity(UserDTO dto, User entity) {
		entity.setNome(dto.getNome());
		entity.setCpf(dto.getCpf());		
		entity.setEmail(dto.getEmail());
		entity.setDataNascimento(dto.getDataNascimento());
		entity.setVehicle(dto.getVehicle());
		
	}
	
	private void validaUser(UserDTO dto) {
		validaCpf(dto);
		validaEmail(dto);
	}
	
	private void validaCpf(UserDTO dto) {
		boolean exists = userRepository.existsByCpf(dto.getCpf());
		if (exists) {
			throw new UserCadastradoException("Esse usuário já possui CPF cadastrado!");
		}
	}
	
	private void validaEmail(UserDTO dto) {
		boolean exists = userRepository.existsByEmail(dto.getEmail());
		if (exists) {
			throw new UserCadastradoException("Esse usuário já possui Email cadastrado");
		}
	}
	

}
