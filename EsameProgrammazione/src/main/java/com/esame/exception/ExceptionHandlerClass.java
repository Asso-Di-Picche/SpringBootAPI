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

/** Rappresenta la classe in sui vengono gestiti gli errori
 * generati da eventuali chiamate errate da parte del Client.
 * @author Marco Sebastianelli
 * @author Cristian Vitali
*/

@ControllerAdvice
public class ExceptionHandlerClass{


	/**
	 * Risponde quando viene lanciato l'errore FilterIllegalArgumentException
	 * creando e restituendo un oggetto errorModel, con stato BAD_REQUEST.
	 * @return ResponseEntity di Object errorModel
	 */
	
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
	
	/**
	 * Risponde quando viene lanciato l'errore FilterNotFoundException
	 * creando e restituendo un oggetto errorModel, con stato BAD_REQUEST.
	 * @return ResponseEntity di Object errorModel
	 */
 	
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
 	
	/**
	 * Risponde quando viene lanciato l'errore StatsNotFoundException
	 * creando e restituendo un oggetto errorModel, con stato BAD_REQUEST.
	 * @return ResponseEntity di Object errorModel
	 */
 	
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
 	
	/**
	 * Risponde quando viene lanciato l'errore InternalGeneralException
	 * creando e restituendo un oggetto errorModel, con stato INTERNAL_SERVER_ERROR.
	 * @return ResponseEntity di Object errorModel
	 */
 	
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

