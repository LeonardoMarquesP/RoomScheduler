package com.leonardo.pereira.roomscheduler.entities.dto;

import java.io.Serializable;

import com.leonardo.pereira.roomscheduler.entities.User;

public class UserDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	//@NotBlank(message = "Campo Obrigatorio")
	private String name;
	private String document;
	//@Email(message = "Favor inserir um email valido")
	private String email;
	private String role;
	
	public UserDTO() {
		
	}

	public UserDTO(Long id, String name, String document, String email, String role) {
		super();
		this.id = id;
		this.name = name;
		this.document = document;
		this.email = email;
		this.role = role;
	}
	
	public UserDTO(User entity) {
		id = entity.getId();
		name = entity.getName();
		document = entity.getDocument();
		email = entity.getEmail();
		role = entity.getRole();
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

}
