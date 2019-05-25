package com.demo.taskmanager.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.demo.taskmanager.entity.Priority;


public interface IPriorityService {
	public Boolean savePriority(Priority priority);
	
	public List<Priority> getAllPriorities();
	
	public ResponseEntity<Priority> getPriorityById(Long priorityId);
	
	public Boolean updatePriority(Long priorityId,Priority priority);
	
	public Boolean deletePriority(Long priorityId);

}
