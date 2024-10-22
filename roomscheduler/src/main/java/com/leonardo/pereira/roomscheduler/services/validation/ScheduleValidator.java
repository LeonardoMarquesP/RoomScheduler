package com.leonardo.pereira.roomscheduler.services.validation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.leonardo.pereira.roomscheduler.entities.Schedule;
import com.leonardo.pereira.roomscheduler.entities.dto.ScheduleInsertUpdateDTO;
import com.leonardo.pereira.roomscheduler.infra.FieldMessage;
import com.leonardo.pereira.roomscheduler.repositories.ScheduleRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ScheduleValidator implements ConstraintValidator<ScheduleValid, ScheduleInsertUpdateDTO>{

	@Autowired
	private ScheduleRepository repository;
	
	@Override 
	public void initialize(ScheduleValid ann){
		
	}
	
	@Override
	public boolean isValid(ScheduleInsertUpdateDTO dto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
				
		//Teste 1 - Se a data não está após 90 dias no futuro
		LocalDate dateS = dto.getScheduledDate();
        LocalDate today = LocalDate.now();
        LocalDate maxDate = today.plusDays(90);
        if (dateS.isBefore(today) || dateS.isAfter(maxDate)) {
            list.add(new FieldMessage("scheduledDate", "Scheduled Date is invalid"));
        }	
        
        //Teste 2
        Schedule dateS2 = repository.findByScheduledDate(dto.getScheduledDate());
        if (dateS2 != null) {
        	list.add(new FieldMessage("scheduledDate", "Scheduled Date already exists"));
        }
        
        
        
        
        
		//Pega a lista fieldMessage e insere no beansvalidation os erros
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
	
	
	
	

}
