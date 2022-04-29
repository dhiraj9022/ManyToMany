package com.dhiraj.demo.advice;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dhiraj.demo.exception.AlreadyExistsException;

@ControllerAdvice
@RestController
public class ExceptionController {
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ConstraintViolationException.class)
	public Map<String, String> handleValidationExceptions(ConstraintViolationException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getConstraintViolations().forEach((error) -> {
			String fieldName = error.getPropertyPath().toString();
			String errorMessage = error.getMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(AlreadyExistsException.class)
	public String alreadyExists(AlreadyExistsException exception) {
		return exception.getMessage();
	}
}
