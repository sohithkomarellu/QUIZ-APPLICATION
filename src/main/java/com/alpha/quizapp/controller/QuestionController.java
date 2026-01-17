package com.alpha.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.quizapp.entities.Question;
import com.alpha.quizapp.service.QuestionService;



@RestController
@RequestMapping("question")  
public class QuestionController {
	
	@Autowired
	QuestionService questionservice;
	
	
	@GetMapping("allquestions")
	public List<Question> getAllQuestions()  
	{
		return questionservice.getAllQuestions();
	}
	
	@GetMapping("category/{category}")       
	public List<Question> getQuestionsByCategory(@PathVariable String category)
	{
		return questionservice.getQuestionsByCategory(category);  
	}
	
	@PostMapping("add")
	public String addQuestion(@RequestBody Question question)
	{
		return questionservice.addQuestion(question);
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteQuestion(@PathVariable int id)
	{  
		questionservice.deleteQuestion(id);               
	}
}




