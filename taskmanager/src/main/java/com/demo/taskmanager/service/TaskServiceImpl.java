package com.demo.taskmanager.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.taskmanager.entity.Task;
import com.demo.taskmanager.repository.ITaskRepository;
import com.demo.taskmanager.repository.TaskCustomRepository;
import com.demo.taskmanager.util.DateUtil;
import com.demo.taskmanager.util.QueryUtils;

@Service
public class TaskServiceImpl implements ITaskService {
	@Autowired
	ITaskRepository taskRepository;
	@Autowired
	TaskCustomRepository taskCustomRepository;

	@Override
	public Boolean saveTask(Task task) {
		taskRepository.save(task);
		return true;
	}

	@Override
	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}

	@Override
	public ResponseEntity<Task> getTaskById(Long taskId) {
		Task task=taskRepository.findOne(taskId);
		if(task==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(task);
	}

	@Override
	public Boolean updateTask(Long taskId, Task task) {
		Task dbTask=taskRepository.findOne(taskId);
		if(dbTask==null) {
			return false;
		}
		if(task.getName()!=null)
		dbTask.setName(task.getName());
		if(task.getLabel()!=null && task.getLabel().getId()!=null)
		dbTask.setLabel(task.getLabel());
		if(task.getPriority()!=null && task.getPriority().getId()!=null)
		dbTask.setPriority(task.getPriority());
		if(task.getTaskDate()!=null)
		dbTask.setTaskDate(task.getTaskDate());
		taskRepository.save(dbTask);
		return true;
	}

	@Override
	public Boolean deleteTask(Long taskId) {
		Task task=taskRepository.findOne(taskId);
		if(task==null) {
			return false;
		}
		taskRepository.delete(task);
		return true;
	}

	@Override
	public List<Task> getTaskByFilterCriteria(Map<String, Object> filterCriteria) {
		// TODO Auto-generated method stub
		StringBuilder query = new StringBuilder();
		query.append(" select tasks from Task tasks where")
			 .append(" tasks.status =1");
		if(filterCriteria.containsKey("label")) {
			query.append(" and tasks.label.name = '"+(String) filterCriteria.get("label")+"'");
		}
		if(filterCriteria.containsKey("priority")) {
			query.append(" and tasks.priority.name in "+QueryUtils.getInQueryAppender((List<String>) filterCriteria.get("priority")));
		}
		if(filterCriteria.containsKey("dayRange")) {
			Map<String, String> datefilter = DateUtil.getFromAndToDateFromDaySpan(Integer.parseInt((String) filterCriteria.get("dayRange")));
			if(datefilter.size()==1) {
				System.out.println(datefilter.get("date"));
				query.append(" and Date(tasks.taskDate) = '"+datefilter.get("date")+"'");
			}else {
				System.out.println(datefilter.get("fromDate"));
				System.out.println(datefilter.get("toDate"));
				query.append(" and tasks.taskDate between '"+datefilter.get("fromDate")+"' and '"+datefilter.get("toDate")+"'");
			}
		}
		if(filterCriteria.containsKey("priority")) {
			query.append(" order by tasks.priority.value DESC");
		}
		return taskCustomRepository.getTaskByFilter(query.toString());
	}

}
