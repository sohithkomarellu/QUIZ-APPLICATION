package com.alpha.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.quizapp.entities.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Integer>{
	
	
	

}
