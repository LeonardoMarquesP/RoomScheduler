package com.leonardo.pereira.roomscheduler.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.leonardo.pereira.roomscheduler.entities.User;
import com.leonardo.pereira.roomscheduler.entities.dto.UserDTO;
import com.leonardo.pereira.roomscheduler.entities.dto.UserInsertDTO;
import com.leonardo.pereira.roomscheduler.infra.EntityNotFoundException;
import com.leonardo.pereira.roomscheduler.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	//@Autowired
	//private BCryptPasswordEncoder passwordEncoder;

	//@Transactional(readOnly = true)
	@Transactional
	public List<UserDTO> findAll() {
		//Pega os dados do User - Antigamente : return repository.findAll();
		List<User> list = repository.findAll();
		//Constroi um UserDTO
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return listDto;
	}

	//@Transactional(readOnly = true)
	@Transactional
	public UserDTO findById(Long id) {
		//Pega os dados do User
		//Optional serve para evitar de trabalhar com valor nulo 
		Optional<User> obj = repository.findById(id);
		
		//Antes do exception : //User entity = obj.orElseThrow();
		User entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
		
		return new UserDTO(entity);
	}

	//@Transactional(readOnly = true)
	@Transactional
	public Page<UserDTO> findAllPaged(Pageable pageable) {
		Page<User> list = repository.findAll(pageable);
		return list.map(x -> new UserDTO(x));
	}
	
	//Insert
	//Ainda não Implementado
	@Transactional
	public UserDTO insert(UserInsertDTO dto) {
		//Cria um User
		User entity = new User();
		
		//Jogar os dados do DTO para a Entidade (Nome, Doc, Email, Role)
		copyDtoToEntity(dto, entity);
		
		//Jogar os dados do DTO para a Entidade (Senha)
		entity.setPassword(dto.getPassword());
		//entity.setPassword(passwordEncoder.encode(dto.getPassword()));
		
		entity = repository.save(entity);
		return new UserDTO(entity);
	}

	
	//Update
	
	/* Update DsCatalog
	 
	 @Transactional
	public UserDTO update(Long id, UserUpdateDTO dto) {
		try {
		    //User entity = repository.getOne(id);
			//User entity = repository.getById(id);
			User entity = repository.getReferenceById(id);
			
		    //entity.setName(dto.getName());
			copyDtoToEntity(dto, entity);
			
		    entity = repository.save(entity);
		    return new UserDTO(entity);
	    }
		catch(EntityNotFoundException e) {
	        throw new ResourceNotFoundException("Id not Found: " +id);
	    }
	}
	 */
	
	//Delete
	 
	/* Delete DsCATALOG
	 
	 //Não tem @Transacional
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not Found: "+id);
		}
		catch(DataIntegrityViolationException e) {
			throw new  DatabaseException("Integrity Violation");
		}
	}
	 */
	
	
	private void copyDtoToEntity(UserInsertDTO dto, User entity) {
		entity.setName(dto.getName());
		entity.setDocument(dto.getDocument());
		entity.setEmail(dto.getEmail());
		entity.setRole(dto.getRole());
	}
	
}
