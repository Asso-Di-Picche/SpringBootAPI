package com.esame.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import com.esame.util.filter.Filter;
import com.esame.database.DatabaseClass;
import com.esame.model.Record;



public class FilterService {

	final private String path = "com.esame.util.filter.";
	private static ArrayList<Record> records = DatabaseClass.getRecords();
	
	
	public FilterService() {}  
	
	
	// generazione errori ClassNotFoundException se nome filtro non coretto
	// gli altri errori non dovrebbero verificarsi mai, errori interni 
	//
	public Filter instanceFilter(String column,String operator,Object param) 
			throws ClassNotFoundException, LinkageError,SecurityException, NoSuchMethodException, 
			InstantiationException, IllegalAccessException, IllegalArgumentException, 
			InvocationTargetException {
		
		Filter filtro;
	    String ClassFilterName = path.concat("Filter"+column+operator);
	    
	    Class<?> cls = Class.forName(ClassFilterName); //seleziono la classe
		
	    Constructor<?> ct = cls.getDeclaredConstructor(Object.class); //seleziono il costruttore
	    
	    filtro =(Filter)ct.newInstance(param);  //instanzo oggetto filtro
	    
	    return filtro;
	    
	}
	
	
	public static ArrayList<Record> runFilterAND(Filter filtro, ArrayList<Record> previousArray){

		ArrayList<Record> filteredArray = new ArrayList<Record>();
		
		for(Record record :  previousArray) {

			if(filtro.filter(record))
				filteredArray.add(record);
		}				
		
		return filteredArray;
	}

	
	public static ArrayList<Record> runFilterOR(Filter filtro, ArrayList<Record> previousArray){

		ArrayList<Record> filteredArray = new ArrayList<Record>();
		
		for(Record record : records) {

			if(filtro.filter(record))
				filteredArray.add(record);
		}	
		
		previousArray.removeAll(filteredArray);
		previousArray.addAll(filteredArray);
		return previousArray;
	}
	
}
