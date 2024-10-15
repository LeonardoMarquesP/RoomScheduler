package com.leonardo.pereira.roomscheduler.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardo.pereira.roomscheduler.entities.User;
import com.leonardo.pereira.roomscheduler.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

	public List<User> findAll() {

		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		User entity = obj.orElseThrow();
		return new User(entity);
		
		//return repository.findById();
	}


	
}
