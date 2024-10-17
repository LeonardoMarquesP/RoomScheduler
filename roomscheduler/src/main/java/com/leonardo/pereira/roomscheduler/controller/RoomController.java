package com.leonardo.pereira.roomscheduler.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.leonardo.pereira.roomscheduler.entities.dto.RoomDTO;
import com.leonardo.pereira.roomscheduler.services.RoomService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/rooms")
public class RoomController {
	
	@Autowired
	private RoomService service;
	
	//FindAllPageable
	@GetMapping
	public ResponseEntity<Page<RoomDTO>> findAllPaged(Pageable pageable){
		
		Page<RoomDTO> list = service.findAllPaged(pageable);
		
		return ResponseEntity.ok().body(list);
		
	}
	
	//FindById
	@GetMapping(value = "/{id}")
	public ResponseEntity<RoomDTO> findById(@PathVariable Long id){
		
		RoomDTO roomDto = service.findById(id);
		
		return ResponseEntity.ok().body(roomDto);
	}
	
	
	//Insert
	@PostMapping
	public ResponseEntity<RoomDTO> insert(@Valid @RequestBody RoomDTO dto){
		
		RoomDTO newDto = service.insert(dto);
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("{/id}")
				.buildAndExpand(newDto.getId()).toUri();
		
		return ResponseEntity.created(uri).body(newDto);
	}
	
	//Update
	@PutMapping(value = "/{id}")
	public ResponseEntity<RoomDTO> update(@PathVariable Long id, @Valid @RequestBody RoomDTO dto){
		
		RoomDTO newDto = service.update(id, dto);
		
		return ResponseEntity.ok().body(newDto);
	}
	
	//Delete
	@DeleteMapping(value= "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	

}
