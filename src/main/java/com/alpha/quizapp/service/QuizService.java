package com.alpha.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alpha.quizapp.dao.Questiondao;
import com.alpha.quizapp.entities.Question;
import com.alpha.quizapp.entities.Quiz;
import com.alpha.quizapp.entities.Response;
import com.alpha.quizapp.exception.QuizNotFoundException;
import com.alpha.quizapp.repository.QuestionRepository;
import com.alpha.quizapp.repository.QuizRepository;

@Service
public class QuizService {
	
	@Autowired
	QuizRepository quizrepository;
	
	@Autowired
	QuestionRepository questionrepository;
	
	public ResponseEntity<String> createquiz(String category, int numQ, String title) {
		List<Question> question=questionrepository.getRandomQuestionsByCategory(category,numQ);
		
		Quiz quiz=new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(question);
		
		quizrepository.save(quiz);
		return new ResponseEntity<String>("SUCCESS",HttpStatus.CREATED);  
		
	}

	public ResponseEntity<List<Questiondao>> getQuizQuestions(int id) {
		Quiz quiz=quizrepository.findById(id).orElseThrow(()->new QuizNotFoundException());   
		List<Question> questionsfromdb=quiz.getQuestions();  
		List<Questiondao> questionsforuser=new ArrayList<>();
		
		for(Question q: questionsfromdb)
		{
			Questiondao questiondao=new Questiondao(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
			questionsforuser.add(questiondao);   
		}
		
		
		return new ResponseEntity<>(questionsforuser,HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateQuiz(int id, List<Response> responses) {
		Quiz quiz=quizrepository.findById(id).orElseThrow(()-> new QuizNotFoundException());
	    List<Question> questions=quiz.getQuestions();
	    
	    int right=0;
	    int i=0;
	    for(Response response: responses)
	    {
	    	if(response.getResponse().equals(questions.get(i).getRightAnswer()))
	    	{
	    		right ++;
	    		
	    		i++;
	    	}
	    }
		return new ResponseEntity<>(right,HttpStatus.OK);
	}
	
	
}
