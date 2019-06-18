package com.esame.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esame.database.DatabaseClass;

import com.esame.exception.InternalGeneralException;
import com.esame.exception.FilterIllegalArgumentException;
import com.esame.exception.FilterNotFoundException;
import com.esame.exception.StatsNotFoundException;
import com.esame.model.Metadata;
import com.esame.model.Record;
import com.esame.service.JsonParser;
import com.esame.service.StatsService;
import com.esame.util.other.StatsCalculator;
import com.esame.model.Stats;
 
/** Rappresenta la classe che gestisce tutte le chiamate al Server 
 * permesse al Client.
 * @author Marco Sebastianelli
 * @author Cristian Vitali
*/

@RestController
public class ControllerClass {
	
	/**
	 * Risponde all richiesta GET /metadata 
	 * @return ArrayList di oggetti Metadata
	 */

	@RequestMapping(value = "metadata", method=RequestMethod.GET)
	public ArrayList<Metadata> getMetadata(){
		
		return DatabaseClass.getArrayMetadata();
	}
	
	/**
	 * Risponde all richiesta GET /data
	 * @return ArrayList di oggetti Record
	 */
	
	@RequestMapping(value = "data", method=RequestMethod.GET)
	public ArrayList<Record> getDataWithGet() {
		
		return DatabaseClass.getRecords();
	}
	
	/**
	 * Risponde all richiesta POST /data
	 * @param     Un Object contenente un JSON con i filtri da applicare al dataset.
	 * @return    ArrayList di oggetti Record filtrati.
	 * @throws    InternalGeneralException se vengono generati errori generali interni al server.
	 * @throws    FilterNotFoundException se vengono generati errori di Filtro non trovato.
	 * @throws    FilterIllegalArgumentException se vengono generati errori di parametro non valido in ingresso al filtro.
	 */
	
	@RequestMapping(value = "data", method=RequestMethod.POST)

	public ArrayList<Record> getDataWithPost(@RequestBody Object filter) 
    throws InternalGeneralException, FilterNotFoundException, FilterIllegalArgumentException {

		
		return JsonParser.JsonParserColonna(filter);
	}
	
	/**
	 * Risponde all richiesta POST /stats
	 * @param Una Stringa tramite URL che rappresenta la colonna sulla quale 
	 * si vuole effettuare la statistica. 
	 * @param Un Object contenente un JSON con i filtri da applicare al dataset.
	 * @return ArrayList di oggetti Record filtrati
	 * @throws    InternalGeneralException se vengono generati errori generali interni al server.
	 * @throws    StatsNotFoundException se vengono generati errori di richiesta su colonna non esistente 
	 * @throws    FilterNotFoundException se vengono generati errori di Filtro non trovato.
	 * @throws    FilterIllegalArgumentException se vengono generati errori di parametro non valido in ingresso al filtro.
	 */
	
	@RequestMapping(value = "stats", method=RequestMethod.POST)
	public Stats getStatsWithPost(@RequestParam(value = "field") String column,
								  @RequestBody Object filter) 
	throws InternalGeneralException, StatsNotFoundException, FilterNotFoundException, FilterIllegalArgumentException {
		
		ArrayList<Record> filteredArray = JsonParser.JsonParserColonna(filter);
		StatsCalculator sc = StatsService.instanceStatsCalculator(column, filteredArray);
		return sc.run();
	}
	
	
	@RequestMapping(value = "stats", method=RequestMethod.GET)
	public Stats getStats(@RequestParam(value = "field") String column) 
	throws InternalGeneralException, StatsNotFoundException, FilterNotFoundException, FilterIllegalArgumentException {

		
		ArrayList<Record> records = DatabaseClass.getRecords();
		StatsCalculator sc = StatsService.instanceStatsCalculator(column, records);
		return sc.run();
	}
}
