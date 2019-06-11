package com.esame.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import com.esame.model.Record;
import com.esame.util.statistic.StatsCalculator;;

public class StatsService {

	private final static String path = "com.esame.util.statistic.";
	
	
	// generazione errori ClassNotFoundException se nome calolatore statistica non coretto
	// gli altri errori non dovrebbero verificarsi mai, errori interni 
	// column -> campo su cui si vuol calcolare la statistica
	// records -> elementi su cui si vuol calcolare la statistica
	
	public static StatsCalculator instanceStatsCalculator(String column, ArrayList<Record> records) 
			throws ClassNotFoundException, LinkageError,SecurityException, NoSuchMethodException, 
			InstantiationException, IllegalAccessException, IllegalArgumentException, 
			InvocationTargetException {
		
		StatsCalculator statsCalculator;
		
	    String ClassStatsName = path.concat("Stats"+column);
	    
	    Class<?> cls = Class.forName(ClassStatsName); //seleziono la classe
		
	    Constructor<?> ct = cls.getDeclaredConstructor(ArrayList.class); //seleziono il costruttore
	    
	    statsCalculator =(StatsCalculator)ct.newInstance(records);  //instanzo oggetto StasCalulator
	    	    
	    return statsCalculator;
	    
	}
	
}
