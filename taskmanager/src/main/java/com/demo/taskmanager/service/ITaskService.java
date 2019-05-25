package com.demo.taskmanager.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.demo.taskmanager.entity.Task;

public interface ITaskService {
	public Boolean saveTask(Task task);
	
	public List<Task> getAllTasks();
	
	public ResponseEntity<Task> getTaskById(Long taskId);
	
	public Boolean updateTask(Long taskId,Task task);
	
	public Boolean deleteTask(Long taskId);
	
	public List<Task> getTaskByFilterCriteria(Map<String , Object> filterCriteria);

	
}
