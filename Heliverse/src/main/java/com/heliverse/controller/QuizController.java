package com.heliverse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heliverse.exceptions.QuizException;
import com.heliverse.model.Quiz;
import com.heliverse.services.QuizService;

@RestController

@RequestMapping("/quizzes")
public class QuizController {

	@Autowired
	private QuizService service;

	@PostMapping
	public ResponseEntity<Quiz> createQuizHandler(@RequestBody Quiz quiz) throws QuizException {
		Quiz q = service.createQuiz(quiz);
		return new ResponseEntity<Quiz>(q, HttpStatus.CREATED);

	}

	@GetMapping("/active")
	public ResponseEntity<Quiz> getActiveQuizHandler() throws QuizException {
		Quiz q = service.getActiveQuiz();
		return new ResponseEntity<Quiz>(q, HttpStatus.OK);
	}

	@GetMapping("/{quizId}/result")
	public ResponseEntity<Integer> getQuizResultHandler(@PathVariable("quizId") Long quizId) throws QuizException {
		Integer res = service.getQuizResult(quizId);
		return new ResponseEntity<Integer>(res, HttpStatus.FOUND);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Quiz>> getAllQuizzesHandler() throws QuizException {

		List<Quiz> quiz = service.getAllQuizzes();
		return new ResponseEntity<List<Quiz>>(quiz, HttpStatus.OK);

	}

}
