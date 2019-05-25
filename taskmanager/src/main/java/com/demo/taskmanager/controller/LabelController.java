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

import com.demo.taskmanager.entity.Label;
import com.demo.taskmanager.service.ILabelService;

@RestController
@RequestMapping("/label")
public class LabelController {
	@Autowired
	ILabelService labelservice;

	/* to save Label*/
	@PostMapping("/save")
	public Boolean createLabel(@RequestBody Label label) {
		return labelservice.saveLabel(label);
	}
	
	/*get all Labels*/
	@GetMapping("/getall")
	public List<Label> getAllLabels(){
		return labelservice.getAllLabels();
	}
	
	/*get Label by labelId*/
	@GetMapping("/get/{id}")
	public ResponseEntity<Label> getLabelById(@PathVariable(value="id") Long labelId){
		return labelservice.getLabelById(labelId);
	}
	
	/*update Label by labelId*/
	@PutMapping("/update/{id}")
	public Boolean updateLabel(@PathVariable(value="id") Long labelId,@Valid @RequestBody Label label){
		return labelservice.updateLabel(labelId,label);
	}
	
	/*Delete Label*/
	@DeleteMapping("/delete/{id}")
	public Boolean deleteLabel(@PathVariable(value="id") Long labelId){
		return labelservice.deleteLabel(labelId);
	}
}
