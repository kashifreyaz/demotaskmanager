package com.demo.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.taskmanager.entity.Task;

public interface ITaskRepository extends JpaRepository<Task, Long> {

}
