package com.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

		@ExceptionHandler(EmployeeNotFoundException.class)
		public ResponseEntity<String> handleEmployeeNotFound(EmployeeNotFoundException ex) {

				return ResponseEntity.status(404).body(ex.getMessage());
		}
}