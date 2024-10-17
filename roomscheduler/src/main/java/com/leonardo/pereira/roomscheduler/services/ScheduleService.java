package com.leonardo.pereira.roomscheduler.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.leonardo.pereira.roomscheduler.entities.Schedule;
import com.leonardo.pereira.roomscheduler.entities.dto.ScheduleDTO;
import com.leonardo.pereira.roomscheduler.infra.DatabaseException;
import com.leonardo.pereira.roomscheduler.infra.EntityNotFoundException;
import com.leonardo.pereira.roomscheduler.infra.ResourceNotFoundException;
import com.leonardo.pereira.roomscheduler.repositories.ScheduleRepository;

import jakarta.transaction.Transactional;

@Service
public class ScheduleService {
	
	@Autowired
	private ScheduleRepository repository;
	
	//@Transactional(readOnly = true)
	@Transactional
	public List<ScheduleDTO> findAll(){
		//Pega os dados do Schedule - Antigamente : return repository.findAll();
		List<Schedule> list = repository.findAll();
		//Constroi um ScheduleDTO
		List<ScheduleDTO> listDto = list.stream().map(x -> new ScheduleDTO(x)).collect(Collectors.toList());
		return listDto;
	}
	
	//@Transactional(readOnly = true)
	@Transactional
	public Page<ScheduleDTO> findAllPaged(Pageable pageable){
		Page<Schedule> list = repository.findAll(pageable);
		return list.map(x -> new ScheduleDTO(x));
	}
	
	//@Transactional(readOnly = true)
	@Transactional
	public ScheduleDTO findById(Long id) {
		//Pega os dados do Schedule
		//Optional serve para evitar de trabalhar com valor nulo 
		Optional<Schedule> obj = repository.findById(id);
		//Antes do exception : //User entity = obj.orElseThrow();
		Schedule entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
		return new ScheduleDTO(entity);
	}
	
	@Transactional
	public ScheduleDTO insert(ScheduleDTO dto) {
		//Cria um Schedule Vazio
		Schedule entity = new Schedule();
		
		//Jogar os dados do DTO para a Entidade (Nome, Doc, Email, Role)
		copyDtoToEntity(dto, entity);
		
		entity = repository.save(entity);
		return new ScheduleDTO(entity);
	}
	
	//Update
	@Transactional
	public ScheduleDTO update(Long id, ScheduleDTO dto) {
		try {
			Schedule entity = repository.getReferenceById(id);
				
			copyDtoToEntity(dto, entity);
				
			entity = repository.save(entity);
				
			//Salva o novo DTO
			return new ScheduleDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not Found: " +id);
		}
	}
	
	//Delete
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not Found: "+id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity Violation");
		}
	}

	
	private void copyDtoToEntity(ScheduleDTO dto, Schedule entity) {
		entity.setScheduledDate(dto.getScheduledDate());
		entity.setUser(dto.getUser());
		entity.setRoom(dto.getRoom());
	}
	

}
