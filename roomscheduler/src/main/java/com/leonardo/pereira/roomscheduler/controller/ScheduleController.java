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

import com.leonardo.pereira.roomscheduler.entities.dto.ScheduleDTO;
import com.leonardo.pereira.roomscheduler.services.ScheduleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/schedules")
public class ScheduleController {
	
	@Autowired
	private ScheduleService service;
	
	//FindById
		@GetMapping(value = "/{id}")
		public ResponseEntity<ScheduleDTO> findById(@PathVariable Long id){
			
			ScheduleDTO scheduleDto = service.findById(id);
			//List<User> list2 = service.findById();
			return ResponseEntity.ok().body(scheduleDto);
			
		}
		
		//FindAllPageable
		@GetMapping
		public ResponseEntity<Page<ScheduleDTO>> findAllPaged(Pageable pageable){
			Page<ScheduleDTO> list = service.findAllPaged(pageable);		
			return ResponseEntity.ok().body(list);
		}
		
		//Insert
		//Quando for inserir um recurso usar o Post
		@PostMapping
		public ResponseEntity<ScheduleDTO> insert (@Valid @RequestBody ScheduleDTO dto){
			ScheduleDTO newDto = service.insert(dto);
			
			URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("{/id}")
					.buildAndExpand(newDto.getId()).toUri();
			
			return ResponseEntity.created(uri).body(newDto);
		}
		
		//Update
		@PutMapping(value = "/{id}")
		public ResponseEntity<ScheduleDTO> update(@PathVariable Long id, @Valid @RequestBody ScheduleDTO dto){
			ScheduleDTO newDto = service.update(id, dto);
			return ResponseEntity.ok().body(newDto);
		}
		
		//Delete
		@DeleteMapping(value= "/{id}")
		public ResponseEntity<Void> delete(@PathVariable Long id){
			service.delete(id);
			return ResponseEntity.noContent().build();
		}

}
