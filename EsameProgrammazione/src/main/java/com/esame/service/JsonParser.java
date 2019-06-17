package com.esame.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.esame.exception.FilterIllegalArgumentException;
import com.esame.exception.FilterNotFoundException;
import com.esame.exception.InternalGeneralException;
import com.esame.model.Record;
import com.esame.service.FilterService;
import com.esame.util.other.Filter;
import com.fasterxml.jackson.databind.ObjectMapper;

/** Rappresenta la classe statica che effettua il parsing ricorsivo su un 
 * oggetto di tipo JSON
 * @author Marco Sebastianelli
 * @author Cristian Vitali
*/

public class JsonParser {

	/**
	 * Effettua il parsing piu esterno, selezionando il valore colonna
	 * e un oggetto valore, che contiene il filtro da applicare al dataset
	 * ed eventualmente il type con cui aggiungere il filtro ai precedenti.
	 * @param Un object contenente il JSON con le informazioni sul filtraggio
	 * @return Un ArrayList di Record filtrato
	 */
	
	public static ArrayList<Record> JsonParserColumn(Object filter) throws InternalGeneralException, FilterNotFoundException, FilterIllegalArgumentException{
		
		ArrayList<Record> previousArray = new ArrayList<Record>();
		ArrayList<Record> filteredArray = new ArrayList<Record>();
		HashMap<String, Object> result = new ObjectMapper().convertValue(filter, HashMap.class);
		
		for(Map.Entry<String, Object> entry : result.entrySet()) {
			
			//ad ogni ciclo ripulisce l array "filteredArray"
			filteredArray = new ArrayList<Record>();
		    String column = entry.getKey();
		    Object filterParam = entry.getValue();
		    try {
				filteredArray = JsonParserOperator(column, filterParam, previousArray);
			} catch (  SecurityException e) {

				throw new InternalGeneralException("Error in parsing I/O operation");
				
			} 
		    //ripulisce "previousArray" prima di riempirlo con "filteredArray"
		    previousArray = new ArrayList<Record>();
		    previousArray.addAll(filteredArray);
		}
		return filteredArray;		
	}
	
	/**
	 * Effettua il parsing piu interno, selezionando l operatore e il parametro
	 * per il filtraggio e lancia il filtro corrispondente alla richiesta. 
	 * @param Una Stringa che rappresenta la colonna su cui si vuole effettuare
	 * il filtraggio.
	 * @param Un object contenente i parametri di filtraggio.
	 * @param L'ArrayList ottenuto dai filtraggi precedenti relativi 
	 * ad altre colonne.
	 * @return Un ArrayList di Record filtrato
	 */
	
	public static ArrayList<Record> JsonParserOperator(String column, 
													   Object filterParam, 
												       ArrayList<Record> previousArray) throws InternalGeneralException, FilterNotFoundException, FilterIllegalArgumentException {
		
		String type="";
		Filter filter;
		ArrayList<Record> filteredArray = new ArrayList<Record>();
		HashMap<String, Object> result = new ObjectMapper().convertValue(filterParam, HashMap.class);
		
		for(Map.Entry<String, Object> entry : result.entrySet()) {
			
		    String operator = entry.getKey();
		    Object value = entry.getValue();
		    // Se operatore è type allora guarda se il valore (and o or)
		    // lancia il metodo runfilter corrispondente
		    if(operator.equals("type") || operator.equals("Type")) {
		    	type = (String) value;
		    	if(!(value.equals("and")) && !(value.equals("or"))) {
		    		throw new FilterIllegalArgumentException("'and' o 'or' expected after 'type'");
		    	}
		    	continue;
		    }
		    
		    filter = FilterService.instanceFilter(column, operator, value);
		    switch(type) {
		    
			    case "and":
			    	filteredArray = FilterService.runFilterAND(filter, previousArray);
			    	break;
			    case "or":
			    	filteredArray = FilterService.runFilterOR(filter, previousArray);
			    	break;
			    default:
			    	filteredArray = FilterService.runFilterOR(filter, previousArray);		    	
		    }
		}
		return filteredArray;	
	}
}
