package com.employee.portal.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(value = RuntimeException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public final ResponseEntity<ErrorDetails> handleException(HttpServletRequest request, Exception ex) {
		ErrorDetails errorDetails = new ErrorDetails(request.getPathInfo(), LocalDateTime.now(),
				ex.getClass().getName(), ex.getMessage());
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	
}
