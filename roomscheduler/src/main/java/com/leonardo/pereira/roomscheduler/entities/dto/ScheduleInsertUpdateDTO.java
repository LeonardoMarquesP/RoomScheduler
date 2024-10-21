package com.leonardo.pereira.roomscheduler.entities.dto;
import com.leonardo.pereira.roomscheduler.services.validation.ScheduleValid;

@ScheduleValid
public class ScheduleInsertUpdateDTO extends ScheduleDTO{
	private static final long serialVersionUID = 1L;
	
	ScheduleInsertUpdateDTO() {
		super();
	}

}
