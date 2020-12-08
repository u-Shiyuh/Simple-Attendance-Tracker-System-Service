package com.accenture.sats.server.response;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.accenture.sats.server.exception.AttendanceException;

@ControllerAdvice
public class ErrorResponseHandler {

	public ErrorResponseHandler() {
		
	}
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(AttendanceException exc, WebRequest web){
		
		ErrorResponse error = new ErrorResponse();
		error.setTimestamp(LocalDateTime.now());
		
		if("Not Found".equals(exc.getMessage())) {
			
			error.setStatus(HttpStatus.NOT_FOUND.value());
			error.setError("Not Found");
			error.setMessage(exc.NO_TIMED_IN);
			return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
			
		}else if("Conflicttimein".equals(exc.getMessage())) {
			
			error.setStatus(HttpStatus.CONFLICT.value());
			error.setMessage(exc.ALREADY_TIMED_IN);
			
		}else if("Conflicttimeout".equals(exc.getMessage())) {
			
			error.setStatus(HttpStatus.CONFLICT.value());
			error.setMessage(exc.ALREADY_TIMED_OUT);
		
		}
		error.setError("Conflict");
		return new ResponseEntity<>(error,HttpStatus.CONFLICT);
	}
	
	
}
