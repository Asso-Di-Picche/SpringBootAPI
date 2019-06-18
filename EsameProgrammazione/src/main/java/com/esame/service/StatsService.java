package com.esame.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import com.esame.model.Record;
import com.esame.util.other.StatsCalculator;
import com.esame.exception.InternalGeneralException;
import com.esame.exception.StatsNotFoundException;

/** Rappresenta la classe statica che gestisce i calcoli di stats sul 
 * dataset.
 * @author Marco Sebastianelli
 * @author Cristian Vitali
*/

public class StatsService {

	/** package contenente le classi che implementato l'interfaccia StatsCalculator */
	private final static String path = "com.esame.util.statistic.";
	
	
	/**
	 * Permette di istanziare un oggetto StatsCalculator dalle classi presenti nel 
	 * package com.esame.util.statistic 
	 * @param     column campo su cui si vuole eseguire la stistica. (es: EsAlbArr)
	 * @param     records è l'array su cui si vuole eseguire la statistica.
	 * @return    un oggetto che implementa l'interfaccia StatsCalculator.
	 * @throws    StatsNotFoundException per il campo richiesto non è presente un StatsCalculator
	 * 			  nel package. 
	 * @throws    InternalGeneralException errori interni. (se si verifica è necessaria una 
	 * 			  revisione del codice)
	 */
	
	public static StatsCalculator instanceStatsCalculator(String column, ArrayList<Record> records) 
			throws InternalGeneralException, StatsNotFoundException {
		
		StatsCalculator statsCalculator;
		
	    String ClassStatsName = path.concat("Stats"+column);
	    
	    try {
	    	
	    	Class<?> cls = Class.forName(ClassStatsName); //seleziono la classe
		
	    	Constructor<?> ct = cls.getDeclaredConstructor(ArrayList.class); //seleziono il costruttore
	    
	    	statsCalculator =(StatsCalculator)ct.newInstance(records);  //instanzo oggetto StasCalulator
	    }

	    //entra qui se il nome di StatsCalculator non è corretto 
	    catch(ClassNotFoundException e){
	    	throw new StatsNotFoundException("Impossible to calculate statistics for the field: '"
	    			                         +column+"' does not exist");
	    }
		
	    //entra qui se sbagliate maiuscole e minuscole
	    catch(NoClassDefFoundError e){
	    	throw new StatsNotFoundException("Impossible to calculate statistics for the field: '"
	    			+column+"' probably uppercase and lowercase error");
	    }
	    
	    //altri errori interni (lato server)
	    catch( LinkageError | NoSuchMethodException | SecurityException |IllegalArgumentException  
	    	   | InstantiationException | IllegalAccessException | InvocationTargetException e ) {
	    	
	    	e.printStackTrace();
	    	throw new InternalGeneralException("try later");
	    }
	    
	    
	    return statsCalculator;
	    
	}
	
}
