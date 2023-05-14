package com.heliverse.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(QuizException.class)
	public ResponseEntity<ErrorDetails> loginExceptionHandler(QuizException le, WebRequest req) {
		ErrorDetails err = new ErrorDetails();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage(le.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	// wrong uri exception

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> MANVExceptionHandler(MethodArgumentNotValidException me) {
		ErrorDetails err = new ErrorDetails();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage("Validation Error");
		err.setDetails(me.getBindingResult().getFieldError().getDefaultMessage());

		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	// for other exception

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> otherExceptionHandler(Exception e, WebRequest req) {
		ErrorDetails err = new ErrorDetails();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<ErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
