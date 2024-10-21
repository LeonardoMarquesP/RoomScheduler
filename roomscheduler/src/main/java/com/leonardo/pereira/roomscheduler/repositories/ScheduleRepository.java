package com.leonardo.pereira.roomscheduler.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leonardo.pereira.roomscheduler.entities.Schedule;
import java.time.LocalDate;


@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long>{
	
	Schedule findByScheduledDate(LocalDate scheduledDate);

}
