package com.demo.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.taskmanager.entity.Label;

public interface ILabelRepository extends JpaRepository<Label, Long>{

}
