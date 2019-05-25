package com.demo.taskmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.taskmanager.entity.Label;
import com.demo.taskmanager.repository.ILabelRepository;
import com.demo.taskmanager.repository.TaskCustomRepository;

@Service
public class LabelServiceImpl implements ILabelService {
	@Autowired
	ILabelRepository labelRepository;

	@Override
	public Boolean saveLabel(Label label) {
		labelRepository.save(label);
		return true;
	}

	@Override
	public List<Label> getAllLabels() {
		return labelRepository.findAll();
	}

	@Override
	public ResponseEntity<Label> getLabelById(Long labelId) {
		Label label=labelRepository.findOne(labelId);
		if(label==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(label);
	}

	@Override
	public Boolean updateLabel(Long labelId, Label label) {
		Label emp=labelRepository.findOne(labelId);
		if(emp==null) {
			return false;
		}
		emp.setName(label.getName());
		Label updateEmployee=labelRepository.save(emp);
		return true;
	}

	@Override
	public Boolean deleteLabel(Long labelId) {
		Label label=labelRepository.findOne(labelId);
		if(label==null) {
			return false;
		}
		labelRepository.delete(label);
		return true;
	}

}
