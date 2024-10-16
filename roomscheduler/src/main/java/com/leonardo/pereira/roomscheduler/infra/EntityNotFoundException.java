package com.leonardo.pereira.roomscheduler.infra;

public class EntityNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public EntityNotFoundException(String msg) {
		super(msg);
	}

}
