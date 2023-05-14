package com.heliverse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heliverse.exceptions.QuizException;
import com.heliverse.model.Quiz;
import com.heliverse.repository.QuizDao;
import com.heliverse.utils.QuizStatus;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuizDao quizDao;

	@Override
	public Quiz createQuiz(Quiz quiz) throws QuizException {

		Quiz quiz2 = quizDao.save(quiz);

		if (quiz2 != null) {
			quiz2.updateStatus();
			return quiz2;
		} else {
			throw new QuizException("No Questions inserted...");
		}
	}

	@Override
	public List<Quiz> getAllQuizzes() throws QuizException {
		List<Quiz> quizzes = quizDao.findAll();

		if (quizzes.size() != 0) {
			return quizzes;
		}

		else {
			throw new QuizException("No Quizzes found");
		}
	}

	@Override
	public Quiz getActiveQuiz() throws QuizException {

		List<Quiz> quizzes = quizDao.findAll();

		for (Quiz quiz : quizzes) {
			if (quiz.getStatus() == QuizStatus.ACTIVE) {
				return quiz;
			}

		}
		throw new QuizException("No active quiz found");

	}

	@Override
	public Integer getQuizResult(Long quizId) throws QuizException {
		List<Quiz> quizzes = quizDao.findAll();
		for (Quiz quiz : quizzes) {
			if (quiz.getId().equals(quizId) && quiz.getStatus() == QuizStatus.FINISHED) {
				return quiz.getRightAnswer();
			}
		}
		throw new QuizException("Quiz result is not available yet");

	}

}
