package com.leonardo.pereira.roomscheduler.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leonardo.pereira.roomscheduler.entities.User;

@RestController
@RequestMapping(value = "users")
public class UserResource {
	
	//FindAll
	public ResponseEntity<User> findAll() {

		return null;
		
	}

}
