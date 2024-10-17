package com.leonardo.pereira.roomscheduler.entities.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.leonardo.pereira.roomscheduler.entities.Room;
import com.leonardo.pereira.roomscheduler.entities.Schedule;
import com.leonardo.pereira.roomscheduler.entities.User;

public class ScheduleDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private LocalDate scheduledDate;
	
	private User user;
	private Room room;
	
	public ScheduleDTO() {
		
	}

	public ScheduleDTO(Long id, LocalDate scheduledDate, User user, Room room) {
		super();
		this.id = id;
		this.scheduledDate = scheduledDate;
		this.user = user;
		this.room = room;
	}
	
	public ScheduleDTO(Schedule entity) {
		id = entity.getId();
		scheduledDate = entity.getScheduledDate();
		user = entity.getUser();
		room = entity.getRoom();
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}


	
	

}
