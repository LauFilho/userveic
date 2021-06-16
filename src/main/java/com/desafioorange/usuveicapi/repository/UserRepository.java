package com.desafioorange.usuveicapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafioorange.usuveicapi.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	boolean existsByCpf(String cpf);// De acordo com o desafio, deve ser único
	boolean existsByEmail(String email);// De acordo com o desafio, deve ser único

}
