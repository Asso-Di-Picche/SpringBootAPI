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

	/** package contenente le classi che implementano l'interfaccia Filter 
	 */
	private final static String path = "com.esame.util.filter.";
	
	private static ArrayList<Record> records = DatabaseClass.getRecords();
	
	
	
	/**
	 * Permette di istanziare un oggetto Filter dalle classi presenti nel package com.esame.util.filter
	 * indicando i paramatri di filtraggio desiderati. 
	 * @param     column campo su cui si vuole eseguire il filtraggio. (es: EsAlbArr)
	 * @param     operator tipo di filtraggio selezionato. (es: Greater)
	 * @param     param parametro ingresso necessario al filro selezionato. 
	 * @return    un oggetto che implementa l'interfaccia Filter.(ossia il filtro desiderato)
	 * @throws    FilterNotFoundException il filtro richiesto non è presente nel package. 
	 * @throws    FilterIllegalArgumentException il parametro d'ingresso al filtro non è
	 *            valido per il filro selezionato. 
	 * @throws    InternalGeneralException errori interni. (se si verifica è necessaria una 
	 * 			  revisione del codice)
	 */

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
		
	
	/**
	 * Questo metodo scorre un ArrayList<Record> e restitusce un nuovo ArrayList<Record> composto
	 * da soli record che risultano positivi al filtro.
	 * @param     filtro che si desidera utilizzare. 
	 * @param     previousArray ArrayList<Record> su cui si vuol eseguire l'operazione di filtraggio. 
	 * @return    ArrayList<Record> frutto dell'operazione di filtraggio.
	 */
	
	public static ArrayList<Record> runFilterAND(Filter filtro, ArrayList<Record> previousArray){

		ArrayList<Record> filteredArray = new ArrayList<Record>();
		
		for(Record record :  previousArray) {

			if(filtro.filter(record))
				filteredArray.add(record);
		}				
		
		return filteredArray;
	}

	
	
	/**
	 * Questo metodo restitusce un ArrayList<Record> composto dai record precedenti
	 * con in aggiunta quelli che rispettano il filtro prendendoli dal database.
	 * @param     filtro che si desidera utilizzare. 
	 * @param     previousArray ArrayList<Record> precedente. 
	 * @return    ArrayList<Record> frutto dell'operazione di filtraggio.
	 */
	
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
