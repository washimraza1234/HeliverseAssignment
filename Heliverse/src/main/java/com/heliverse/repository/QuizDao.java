package com.heliverse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heliverse.model.Quiz;


@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer>{
	
	

}
