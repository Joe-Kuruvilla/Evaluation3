package com.masai.app.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptions 
{
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorMessage> notFoundException(NoHandlerFoundException ex, WebRequest wr)
	{
		ErrorMessage error=new ErrorMessage();
		error.setLdt(LocalDateTime.now());
		error.setMessage(ex.getMessage());
		error.setDetails(wr.getDescription(false));
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorMessage> notFoundException(MethodArgumentNotValidException ex, WebRequest wr)
	{
		ErrorMessage error=new ErrorMessage();
		error.setLdt(LocalDateTime.now());
		error.setMessage(ex.getMessage());
		String msg=ex.getBindingResult().getFieldError().getDefaultMessage();
		error.setDetails(msg);
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> otherExceptions(Exception ex)
	{
		System.out.println("The exception is...");
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
}
