package com.demo.taskmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.taskmanager.entity.Priority;
import com.demo.taskmanager.repository.IPriorityRepository;

@Service
public class PrioritySreviceImpl implements IPriorityService {
	@Autowired
	IPriorityRepository priorityRepository;

	@Override
	public Boolean savePriority(Priority priority) {
		priorityRepository.save(priority);
		return true;
	}

	@Override
	public List<Priority> getAllPriorities() {
		return priorityRepository.findAll();
	}

	@Override
	public ResponseEntity<Priority> getPriorityById(Long priorityId) {
		// TODO Auto-generated method stub
		Priority priority=priorityRepository.findOne(priorityId);
		if(priority!=null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(priority);
	}

	@Override
	public Boolean updatePriority(Long priorityId, Priority priority) {
		Priority dbPriority = priorityRepository.findOne(priorityId);
		if(dbPriority==null) {
			return false;
		}
		if(priority.getName()!=null) {
			dbPriority.setName(priority.getName());
		}
		if(priority.getValue()!=null) {
			dbPriority.setValue(priority.getValue());
		}
		priorityRepository.save(dbPriority);
		return true;
	}

	@Override
	public Boolean deletePriority(Long priorityId) {
		Priority priority=priorityRepository.findOne(priorityId);
		if(priority==null) {
			return false;
		}
		priorityRepository.delete(priority);
		return true;
	}

}
