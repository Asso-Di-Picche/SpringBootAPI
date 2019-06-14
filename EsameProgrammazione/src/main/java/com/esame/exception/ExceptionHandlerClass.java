package com.esame.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.esame.exception.ErrorModel;
import com.esame.exception.FilterIllegalArgumentException;
import com.esame.exception.FilterNotFoundException;
import com.esame.exception.InternalGeneralException;
import com.esame.exception.StatsNotFoundException;



@ControllerAdvice
public class ExceptionHandlerClass{


	@ExceptionHandler( value = {FilterIllegalArgumentException.class})
 	public ResponseEntity<Object> handleFilterIllegalArgumentException(FilterIllegalArgumentException e){
 		
 		//1.Crea l oggetto errore model
 		ErrorModel errorModel = new ErrorModel(
 						HttpStatus.BAD_REQUEST,
 						Instant.now(),
 						e.getClass().getCanonicalName(),
 						e.getMessage()
 						);
 		//2.return response entity
 		return new ResponseEntity<>(errorModel, HttpStatus.BAD_REQUEST);
 	}
 	
 	@ExceptionHandler( value = {FilterNotFoundException.class})
 	public ResponseEntity<Object> handleFilterNotFoundException(FilterNotFoundException e){
 		
 		//1.Crea l oggetto errore model
 		ErrorModel errorModel = new ErrorModel(
 						HttpStatus.BAD_REQUEST,
 						Instant.now(),
 						e.getClass().getCanonicalName(),
 						e.getMessage()
 						);
 		//2.return response entity
 		return new ResponseEntity<>(errorModel, HttpStatus.BAD_REQUEST);
 	}
 	
 	@ExceptionHandler( value = {StatsNotFoundException.class})
 	public ResponseEntity<Object> handleStatsNotFoundException(StatsNotFoundException e){
 		
 		//1.Crea l oggetto errore model
 		ErrorModel errorModel = new ErrorModel(
 						HttpStatus.BAD_REQUEST,
 						Instant.now(),
 						e.getClass().getCanonicalName(),
 						e.getMessage()
 						);
 		//2.return response entity
 		return new ResponseEntity<>(errorModel, HttpStatus.BAD_REQUEST);
 	}
 	
 	@ExceptionHandler( value = {InternalGeneralException.class})
 	public ResponseEntity<Object> handleInternalGeneralException(InternalGeneralException e){
 		
 		//1.Crea l oggetto errore model
 		ErrorModel errorModel = new ErrorModel(
 						HttpStatus.INTERNAL_SERVER_ERROR,
 						Instant.now(),
 						e.getClass().getCanonicalName(),
 						e.getMessage()
 						);
 		//2.return response entity
 		return new ResponseEntity<>(errorModel, HttpStatus.INTERNAL_SERVER_ERROR);
 	}
}

