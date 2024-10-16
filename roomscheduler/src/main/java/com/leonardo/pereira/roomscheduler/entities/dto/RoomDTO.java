package com.leonardo.pereira.roomscheduler.entities.dto;

import java.io.Serializable;
import java.util.Objects;

import com.leonardo.pereira.roomscheduler.entities.Room;

import jakarta.validation.constraints.NotBlank;

public class RoomDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotBlank(message = "Campo Nome da Sala Obrigatorio")
	private String name;
	
	
	public RoomDTO() {
		
	}


	public RoomDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public RoomDTO(Room entity) {
		super();
		this.id = entity.getId();
		this.name = entity.getName();
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


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoomDTO other = (RoomDTO) obj;
		return Objects.equals(id, other.id);
	}
	

}
