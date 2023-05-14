package com.heliverse.model;

import java.time.LocalDateTime;
import java.util.List;

import com.heliverse.utils.QuizStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String question;
	private List<String> options;
	private Integer rightAnswer;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private QuizStatus status;

	public Quiz() {
		
	}

	

	public Quiz(Integer id, String question, List<String> options, Integer rightAnswer, LocalDateTime startDate,
			LocalDateTime endDate, QuizStatus status) {
		super();
		this.id = id;
		this.question = question;
		this.options = options;
		this.rightAnswer = rightAnswer;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}


	

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getQuestion() {
		return question;
	}



	public void setQuestion(String question) {
		this.question = question;
	}



	public List<String> getOptions() {
		return options;
	}



	public void setOptions(List<String> options) {
		this.options = options;
	}



	public int getRightAnswer() {
		return rightAnswer;
	}



	public void setRightAnswer(Integer rightAnswer) {
		this.rightAnswer = rightAnswer;
	}



	public LocalDateTime getStartDate() {
		return startDate;
	}



	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}



	public LocalDateTime getEndDate() {
		return endDate;
	}



	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}



	public QuizStatus getStatus() {
		return status;
	}



	public void setStatus(QuizStatus status) {
		this.status = status;
	}



	public void updateStatus() {
		LocalDateTime currentTime = LocalDateTime.now();
		if (currentTime.isBefore(startDate)) {
			status = QuizStatus.INACTIVE;
		} else if (currentTime.isAfter(endDate)) {
			status = QuizStatus.FINISHED;
		} else {
			status = QuizStatus.ACTIVE;
		}
	}
}
