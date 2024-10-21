package com.leonardo.pereira.roomscheduler.entities.dto;

import com.leonardo.pereira.roomscheduler.services.validation.UserInsertValid;

@UserInsertValid
public class UserInsertDTO extends UserDTO{
	private static final long serialVersionUID = 1L;
	
	//UserInsertDTO serve porque não há request de senha no UserDTO + @UserInsertValid
	
	private String password;
	
	UserInsertDTO(){
		super();
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
