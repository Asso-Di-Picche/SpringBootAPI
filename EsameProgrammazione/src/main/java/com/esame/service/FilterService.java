package com.esame.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import com.esame.database.DatabaseClass;
import com.esame.exception.FilterIllegalArgumentException;
import com.esame.exception.FilterNotFoundException;
import com.esame.model.Record;
import com.esame.util.other.Filter;
import com.esame.exception.InternalGeneralException;

/** Rappresenta la classe statica che gestisce i filtraggi del dataset.
 * @author Marco Sebastianelli
 * @author Cristian Vitali
*/

public class FilterService {

	private final static String path = "com.esame.util.filter.";
	private static ArrayList<Record> records = DatabaseClass.getRecords();
	
	
	// generazione errori ClassNotFoundException se nome filtro non coretto
	// gli altri errori non dovrebbero verificarsi mai, errori interni 
	//
	public static Filter instanceFilter(String column,String operator,Object param) 
		   throws FilterNotFoundException, FilterIllegalArgumentException,InternalGeneralException{
		
		Filter filtro;
		String filterName = new String("Filter"+column+operator);
		String ClassFilterName = path.concat(filterName);
	    
		try {
			
			Class<?> cls = Class.forName(ClassFilterName); //seleziono la classe
		
			Constructor<?> ct = cls.getDeclaredConstructor(Object.class); //seleziono il costruttore
	    
			filtro =(Filter)ct.newInstance(param);  //istanzo oggetto filtro
		}
		
	    //entra qui se il nome filtro non è corretto 
	    catch(ClassNotFoundException e){
	    	throw new FilterNotFoundException("The filter in field: '"+column+"' with operator: '"+
	                                          operator +"' does not exist");
	    }
		
		//entra qui se sbagliate maiuscole e minuscole
	    catch(NoClassDefFoundError e){
	    	throw new FilterNotFoundException(
	    			"Error typing: '"+filterName+"' uppercase and lowercase error");
	    }

	    //entra qui se il costruttore chiamato da newInstance lancia un eccezione 
	   	catch (InvocationTargetException e) {  
	   		//genero una nuova eccezione 
	   		throw new FilterIllegalArgumentException(e.getTargetException().getMessage()
	   				+ " Expected in '"+column+"'");
	   	}

	    catch(LinkageError | NoSuchMethodException | SecurityException 
		    	   | InstantiationException | IllegalAccessException e ) {
		    	
		    	e.printStackTrace();
		    	throw new InternalGeneralException("try later");
		    }

		
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
