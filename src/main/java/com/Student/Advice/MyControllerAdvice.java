package com.Student.Advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.Student.custom.exception.EmptyInputException;
import com.Student.custom.exception.StudentNotFoundException;

@ControllerAdvice
public class MyControllerAdvice {
	
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyinputexception){
		return new ResponseEntity<String>("Name should not empty",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<String> notfoundstudent(StudentNotFoundException studentnotfound){
		return new ResponseEntity<String>("Student Not Found",HttpStatus.NOT_FOUND);
	}
	

}
