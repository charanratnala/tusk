package com.lhs.customexception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(GlobalExceptionHandler.class)
	public ResponseEntity<String> handle(GlobalExceptionHandler error) {

		return new ResponseEntity<String>("already username exists", HttpStatus.BAD_REQUEST);

	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, String> map = new HashMap<>();

		ex.getBindingResult().getAllErrors().forEach((error) -> {

			String fieldname = ((FieldError) error).getField();
			String message = error.getDefaultMessage();

			map.put(fieldname, message);
		});
		return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);

	}

}
