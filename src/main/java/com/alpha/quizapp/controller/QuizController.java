package com.alpha.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.quizapp.dao.Questiondao;
import com.alpha.quizapp.entities.Response;
import com.alpha.quizapp.service.QuizService;


@RestController
@RequestMapping("quiz")
public class QuizController {
	
	@Autowired
	QuizService quizservice;         
	
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title)
	{
		return quizservice.createquiz(category,numQ,title);
	}
	
	
	@GetMapping("get/{id}")
	public ResponseEntity<List<Questiondao>> getQuizQuestions(@PathVariable int id)
	{
		return quizservice.getQuizQuestions(id);  
	}
	
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable int id, @RequestBody List<Response> responses)
	{
		return quizservice.calculateQuiz(id, responses);
	}
}  
