package com.esame.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.esame.exception.FilterIllegalArgumentException;
import com.esame.exception.FilterNotFoundException;
import com.esame.exception.InternalGeneralException;
import com.esame.model.Record;
import com.esame.service.FilterService;
import com.esame.util.other.Filter;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonParser {

	
	public static ArrayList<Record> JsonParserColonna(Object filter) throws JsonParseException, JsonMappingException, IOException, FilterNotFoundException, FilterIllegalArgumentException, InternalGeneralException{
		
		ArrayList<Record> previousArray = new ArrayList<Record>();
		ArrayList<Record> filteredArray = new ArrayList<Record>();
		HashMap<String, Object> result = new ObjectMapper().convertValue(filter, HashMap.class);
		
		for(Map.Entry<String, Object> entry : result.entrySet()) {
			
			//ad ogni ciclo ripulisce l array "filteredArray"
			filteredArray = new ArrayList<Record>();
		    String column = entry.getKey();
		    Object filterParam = entry.getValue();
		    filteredArray = JsonParserOperator(column, filterParam, previousArray);
		    //ripulisce "previousArray" prima di riempirlo con "filteredArray"
		    previousArray = new ArrayList<Record>();
		    previousArray.addAll(filteredArray);
		}
		return filteredArray;		
	}
	
	
	public static ArrayList<Record> JsonParserOperator(String column, 
													   Object filterParam, 
												       ArrayList<Record> previousArray) throws JsonParseException, JsonMappingException, IOException,InternalGeneralException, FilterNotFoundException, FilterIllegalArgumentException{
		
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
