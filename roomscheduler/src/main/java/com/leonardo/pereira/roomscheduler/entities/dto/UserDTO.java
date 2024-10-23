package com.leonardo.pereira.roomscheduler.entities.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.leonardo.pereira.roomscheduler.entities.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotBlank(message = "Campo Obrigatorio")
	private String name;
	private String document;
	
	@Email(message = "Favor inserir um email valido")
	private String email;
	//private String role;
	
	//UserInsertDTO
	//private String password;
	
	//RoleDTO roles = new RoleDTO();
	
	Set<RoleDTO> roles = new HashSet<>();
	
	public UserDTO() {
		
	}

	public UserDTO(Long id, String name, String document, String email) {
		super();
		this.id = id;
		this.name = name;
		this.document = document;
		this.email = email;
	}
	
	public UserDTO(User entity) {
		id = entity.getId();
		name = entity.getName();
		document = entity.getDocument();
		email = entity.getEmail();

		entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<RoleDTO> getRoles() {
		return roles;
	}

	

	


	
	
	

}
