package com.esame.util.statistic;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import com.esame.model.Record;
import com.esame.model.StatsString;


public class StatsProvDest extends StatsParent implements StatsCalculator {

	
	public StatsProvDest(ArrayList<Record> RecordList) {
		super(RecordList);
	}
	
	public StatsString run(){
		
		int count = (int) records.stream().count();

	    Map<String, Long>  countForProvDest= 
						   records.stream()
						   .collect(Collectors.groupingBy(Record::getProvDest, Collectors.counting()));
	    
	    int uniqElem = countForProvDest.size();
	    
	    return new StatsString("ProvDest", count, uniqElem, countForProvDest);
	}

	
}
