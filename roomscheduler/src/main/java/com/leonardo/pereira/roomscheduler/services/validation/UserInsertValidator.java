package com.leonardo.pereira.roomscheduler.services.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.leonardo.pereira.roomscheduler.entities.User;
import com.leonardo.pereira.roomscheduler.entities.dto.UserInsertDTO;
import com.leonardo.pereira.roomscheduler.infra.FieldMessage;
import com.leonardo.pereira.roomscheduler.repositories.UserRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserInsertValidator implements ConstraintValidator<UserInsertValid, UserInsertDTO>{

	@Autowired
	private UserRepository repository;
	
	@Override 
	public void initialize(UserInsertValid ann){
		
	}
	
	@Override
	public boolean isValid(UserInsertDTO dto, ConstraintValidatorContext context) {
		//Lista de Erros
		List<FieldMessage> list = new ArrayList<>();
		
		// Coloque aqui seus testes de validação, acrescentando objetos FieldMessage à lista
		
		//Teste 1
		User user = repository.findByEmail(dto.getEmail());
		if(user != null) {
			list.add(new FieldMessage("email", "Email já existe"));
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
