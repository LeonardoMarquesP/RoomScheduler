package com.leonardo.pereira.roomscheduler.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardo.pereira.roomscheduler.entities.User;
import com.leonardo.pereira.roomscheduler.entities.dto.UserDTO;
import com.leonardo.pereira.roomscheduler.infra.EntityNotFoundException;
import com.leonardo.pereira.roomscheduler.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

	@Transactional
	public List<UserDTO> findAll() {
		//Pega os dados do User - Antigamente : return repository.findAll();
		List<User> list = repository.findAll();
		//Constroi um UserDTO
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return listDto;
	}

	@Transactional
	public UserDTO findById(Long id) {
		//Pega os dados do User
		//Optional serve para evitar de trabalhar com valor nulo 
		Optional<User> obj = repository.findById(id);
		
		//Antes do exception : //User entity = obj.orElseThrow();
		User entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
		
		return new UserDTO(entity);
	}


	
}
