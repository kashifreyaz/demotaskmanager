package com.demo.taskmanager.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.taskmanager.entity.Priority;
import com.demo.taskmanager.service.IPriorityService;

@RestController
@RequestMapping("/priority")
public class PriorityController {
	@Autowired
	IPriorityService priorityservice;

	/* to save Priority*/
	@PostMapping("/save")
	public Boolean createPriority(@Valid @RequestBody Priority priority) {
		return priorityservice.savePriority(priority);
	}
	
	/*get all Priorities*/
	@GetMapping("/getall")
	public List<Priority> getAllPriorities(){
		return priorityservice.getAllPriorities();
	}
	
	/*get Priority by priorityId*/
	@GetMapping("/get/{id}")
	public ResponseEntity<Priority> getPriorityById(@PathVariable(value="id") Long priorityId){
		return priorityservice.getPriorityById(priorityId);
	}
	
	/*update Priority by priorityId*/
	@PutMapping("/update/{id}")
	public Boolean updatePriority(@PathVariable(value="id") Long priorityId,@Valid @RequestBody Priority priority){
		return priorityservice.updatePriority(priorityId,priority);
	}
	
	/*Delete Priority*/
	@DeleteMapping("/delete/{id}")
	public Boolean deletePriority(@PathVariable(value="id") Long priorityId){
		return priorityservice.deletePriority(priorityId);
	}
}
