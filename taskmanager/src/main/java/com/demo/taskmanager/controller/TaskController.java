package com.demo.taskmanager.controller;

import java.util.List;
import java.util.Map;

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

import com.demo.taskmanager.entity.Task;
import com.demo.taskmanager.service.ITaskService;

@RestController
@RequestMapping("/task")
public class TaskController {
	@Autowired
	ITaskService taskservice;

	/* to save Task*/
	@PostMapping("/save")
	public Boolean createTask(@Valid @RequestBody Task task) {
		return taskservice.saveTask(task);
	}
	
	/*get all Tasks*/
	@GetMapping("/getall")
	public List<Task> getAllTasks(){
		return taskservice.getAllTasks();
	}
	
	/*get Task by taskId*/
	@GetMapping("/get/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable(value="id") Long taskId){
		return taskservice.getTaskById(taskId);
	}
	
	/*update Task by taskId*/
	@PutMapping("/update/{id}")
	public Boolean updateTask(@PathVariable(value="id") Long taskId,@Valid @RequestBody Task task){
		return taskservice.updateTask(taskId,task);
	}
	
	/*Delete Task*/
	@DeleteMapping("/delete/{id}")
	public Boolean deleteTask(@PathVariable(value="id") Long taskId){
		return taskservice.deleteTask(taskId);
	}
	
	/*get Task by taskId*/
	@GetMapping("/getbyfilter")
	public List<Task> getTaskByFilterCriteria(@RequestBody Map<String , Object> filterCriteria){
		return taskservice.getTaskByFilterCriteria(filterCriteria);
	}
}
