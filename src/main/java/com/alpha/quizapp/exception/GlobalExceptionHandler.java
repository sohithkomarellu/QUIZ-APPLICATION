package com.alpha.quizapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.alpha.quizapp.dao.ResponseStructure;
import com.alpha.quizapp.entities.Question;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(QuestionNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> QuestionNotFoundExceptionHandler()
	{
		ResponseStructure<String> responsestructure=new ResponseStructure<String>();
		responsestructure.setStatuscode(HttpStatus.NOT_FOUND.value());
		responsestructure.setMessage("not found");
		responsestructure.setData(null);
		return new ResponseEntity<ResponseStructure<String>>(responsestructure,HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<ResponseStructure<String>> quizNotFoundExceptionHandler()
	{
		ResponseStructure<String> responsestructure=new ResponseStructure<String>();
		responsestructure.setStatuscode(HttpStatus.NOT_FOUND.value());
		responsestructure.setMessage("not found");
		responsestructure.setData(null);
		return new ResponseEntity<ResponseStructure<String>>(responsestructure,HttpStatus.NOT_FOUND);
	}
}
