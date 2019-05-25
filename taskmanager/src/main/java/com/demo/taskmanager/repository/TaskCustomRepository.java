package com.demo.taskmanager.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.taskmanager.entity.Task;

@Repository
public class TaskCustomRepository {
	@Autowired
	SessionFactory sessionFactory;
	Session session=null;
	
	public List<Task> getTaskByFilter(String query){
		session = sessionFactory.openSession();
		List<Task> taskList = (List<Task>) session.createQuery(query).list();
		return taskList;
	}

}
