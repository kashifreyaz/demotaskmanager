package com.demo.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.taskmanager.entity.Priority;

public interface IPriorityRepository extends JpaRepository<Priority, Long> {

}
