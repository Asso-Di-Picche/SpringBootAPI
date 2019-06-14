package com.esame.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.esame.exception.ErrorModel;



@ControllerAdvice
public class ExceptionHandlerClass{


 	@ExceptionHandler( value = {IllegalArgumentException.class})
 	public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException e, WebRequest request, HttpServletRequest request1){
 		
 		//1.Crea l oggetto ErrorModel
 		ErrorModel errorModel = new ErrorModel(
 						HttpStatus.BAD_REQUEST,
 						Instant.now(),
 						e.getClass().getCanonicalName(),
 						e.getMessage()
 						);
 		//2.Restituisci una ResponseEntity
 		return new ResponseEntity<>(errorModel, HttpStatus.BAD_REQUEST);
 	}
 	
 	@ExceptionHandler( value = {ClassNotFoundException.class})
 	public ResponseEntity<Object> handleClassNotFoundException(ClassNotFoundException e){
 		
 		//1.Crea l oggetto ErrorModel
 		ErrorModel errorModel = new ErrorModel(
 						HttpStatus.BAD_REQUEST,
 						Instant.now(),
 						e.getClass().getCanonicalName(),
 						e.getMessage()
 						);
 		//2.Restituisci una ResponseEntity
 		return new ResponseEntity<>(errorModel, HttpStatus.BAD_REQUEST);
 	}
}

