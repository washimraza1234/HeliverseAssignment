package com.heliverse.services;

import java.util.List;

import com.heliverse.exceptions.QuizException;
import com.heliverse.model.Quiz;

public interface QuizService {

	public Quiz createQuiz(Quiz quiz) throws QuizException;

	public Quiz getActiveQuiz() throws QuizException;

	public Integer getQuizResult(Long quizId) throws QuizException;
	
	public List<Quiz> getAllQuizzes() throws QuizException;

}
