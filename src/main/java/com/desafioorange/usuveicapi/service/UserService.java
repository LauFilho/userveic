package com.desafioorange.usuveicapi.service;

import java.util.List;
import java.util.Optional;

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

	public List<User> findAll() {

		return userRepository.findAll();
	}

	public Optional<User> findUser(Long UserId) {

		return userRepository.findById(UserId);
	}

	public UserDTO insertUser(UserDTO userDTO) {
		this.validaUser(userDTO);

		User newUser = new User();

		copyUserDtoToEntity(userDTO, newUser);

		newUser = userRepository.save(newUser);

		return new UserDTO(newUser);
	}

	private void copyUserDtoToEntity(UserDTO dto, User entity) {
		entity.setNome(dto.getNome());
		entity.setCpf(dto.getCpf());
		entity.setEmail(dto.getEmail());
		entity.setDataNascimento(dto.getDataNascimento());
		entity.setVehicle(dto.getVehicle());
	}

	private void validaUser(UserDTO dto) {
		validaUserCpf(dto);
		validaUserEmail(dto);
	}

	private void validaUserCpf(UserDTO dto) {
		boolean exists = userRepository.existsByCpf(dto.getCpf());
		if (exists) {
			throw new UserCadastradoException("Esse usuário já possui CPF cadastrado!");
		}
	}

	private void validaUserEmail(UserDTO dto) {
		boolean exists = userRepository.existsByEmail(dto.getEmail());
		if (exists) {
			throw new UserCadastradoException("Esse usuário já possui Email cadastrado");
		}
	}

}
