package com.demo.taskmanager.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.demo.taskmanager.entity.Label;

public interface ILabelService {
	public Boolean saveLabel(Label label);
	
	public List<Label> getAllLabels();
	
	public ResponseEntity<Label> getLabelById(Long labelId);
	
	public Boolean updateLabel(Long labelId,Label label);
	
	public Boolean deleteLabel(Long labelId);

}
