package com.leonardo.pereira.roomscheduler.services.validation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.leonardo.pereira.roomscheduler.entities.Schedule;
import com.leonardo.pereira.roomscheduler.entities.dto.ScheduleDTO;
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
		//Lista de Erros
		List<FieldMessage> list = new ArrayList<>();
				
		// Coloque aqui seus testes de validação, acrescentando objetos FieldMessage à lista
				
		//Teste 1 - Se a data esta no formato certo
		//Schedule schedule2 = repository.findByScheduledDate(dto.getScheduledDate());
		
		
		//Teste 2 - Se a data não está após 90 dias no futuro
		//Schedule schedule = repository.findByScheduledDate(dto.getScheduledDate());
		//LocalDate date = schedule.getScheduledDate();
		LocalDate dateS = dto.getScheduledDate();
		
		// Data atual
        LocalDate today = LocalDate.now();
        // Data máxima (90 dias no futuro)
        LocalDate maxDate = today.plusDays(90);
        
        // Verifica se a data está no intervalo entre hoje e até 90 dias no futuro
        if (dateS.isBefore(today) || dateS.isAfter(maxDate)) {
            //throw new IllegalArgumentException("A data agendada deve estar entre hoje e 90 dias no futuro.");
            list.add(new FieldMessage("scheduledDate", "Scheduled Date is invalid"));
        
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
