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

import com.leonardo.pereira.roomscheduler.entities.Room;
import com.leonardo.pereira.roomscheduler.entities.dto.RoomDTO;
import com.leonardo.pereira.roomscheduler.infra.DatabaseException;
import com.leonardo.pereira.roomscheduler.infra.EntityNotFoundException;
import com.leonardo.pereira.roomscheduler.infra.ResourceNotFoundException;
import com.leonardo.pereira.roomscheduler.repositories.RoomRepository;

import jakarta.transaction.Transactional;

@Service
public class RoomService {
	
	@Autowired
	private RoomRepository repository;
	
	//FindAll
	@Transactional
	public List<RoomDTO> findAll(){
		//Pega os dados do Room - Antigamente : return repository.findAll();
		List<Room> list = repository.findAll();
		//Constroi um UserDTO
		List<RoomDTO> listDto = list.stream().map(x -> new RoomDTO(x)).collect(Collectors.toList());
		return listDto;
	}
	
	//FindById
	@Transactional
	public RoomDTO findById(Long id) {
		
		Optional<Room> obj = repository.findById(id);
		
		//Antes do exception : //User entity = obj.orElseThrow();
		Room entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found"));

		return new RoomDTO(entity);
	}
	
	//FindAllPaged
	@Transactional
	public Page<RoomDTO> findAllPaged(Pageable pageable) {
		Page<Room> list = repository.findAll(pageable);
		return list.map(x -> new RoomDTO(x));
	}
	
	//Insert
	@Transactional
	public RoomDTO insert(RoomDTO dto) {
		//Cria um Room
		Room entity = new Room();
		
		//Passa o Room para RoomDTO
		copyDtoToEntity(dto, entity);
		
		//Salvar
		entity = repository.save(entity);
		
		return new RoomDTO(entity);
	}
	
	//Update
	@Transactional
	public RoomDTO update(Long id, RoomDTO dto) {
		try {
			Room entity = repository.getReferenceById(id);
			
			copyDtoToEntity(dto, entity);
			
			entity = repository.save(entity);
			
			//Salva o novo DTO
			return new RoomDTO(entity);
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
	
	//
	private void copyDtoToEntity(RoomDTO dto, Room entity) {
		entity.setName(dto.getName());
	}

}
