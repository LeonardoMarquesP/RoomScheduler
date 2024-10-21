package com.leonardo.pereira.roomscheduler.entities.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.leonardo.pereira.roomscheduler.entities.Room;
import com.leonardo.pereira.roomscheduler.entities.Schedule;
import com.leonardo.pereira.roomscheduler.entities.User;

//@ScheduleValid
public class ScheduleDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private LocalDate scheduledDate;
	
	//Invez de colocar user e room no DTO como na classe normal, o DTO sera diferente, usarei so ID de room e user
	//private User user;
	//private Room room;
	
	private Long userId;
	private Long roomId;
	
	public ScheduleDTO() {
		
	}

	public ScheduleDTO(Long id, LocalDate scheduledDate, User user, Room room) {
		super();
		this.id = id;
		this.scheduledDate = scheduledDate;
		this.userId = user.getId();
		this.roomId = room.getId();
	}
	
	public ScheduleDTO(Schedule entity) {
		id = entity.getId();
		scheduledDate = entity.getScheduledDate();
		userId = entity.getUser().getId();
		roomId = entity.getRoom().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getScheduledDate() {
		return scheduledDate;
	}

	public void setScheduledDate(LocalDate scheduledDate) {
		this.scheduledDate = scheduledDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	
	

}
