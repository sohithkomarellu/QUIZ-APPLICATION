package com.alpha.quizapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.quizapp.entities.Question;
import com.alpha.quizapp.exception.QuestionNotFoundException;
import com.alpha.quizapp.repository.QuestionRepository;

@Service
public class QuestionService {
	
	@Autowired  
	QuestionRepository questionrepository;

	public List<Question> getAllQuestions() {
		
		return questionrepository.findAll();     
	}

	public List<Question> getQuestionsByCategory(String category) {
		// TODO Auto-generated method stub
		return questionrepository.findByCategory(category);  
	}

	public String addQuestion(Question question) {
		
		questionrepository.save(question);
		return "question added ";
	}

	public void deleteQuestion(int id) {
		Question question=questionrepository.findById(id).orElseThrow(()->new QuestionNotFoundException());
		questionrepository.delete(question); 
		
		
		
		
	}
}
