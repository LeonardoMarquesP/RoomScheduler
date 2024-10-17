package com.leonardo.pereira.roomscheduler.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leonardo.pereira.roomscheduler.entities.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{
	
	

}
