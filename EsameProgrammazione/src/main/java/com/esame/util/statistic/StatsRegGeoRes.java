package com.esame.util.statistic;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import com.esame.model.Record;
import com.esame.model.StatsString;
import com.esame.util.other.StatsCalculator;
import com.esame.util.other.StatsParent;


public class StatsRegGeoRes extends StatsParent implements StatsCalculator {

	
	public StatsRegGeoRes(ArrayList<Record> RecordList) {
		super(RecordList);
	}
	
	public StatsString run(){
		
		int count = (int) records.stream().count();

	    Map<String, Long>  countForRegGeoRes= 
						   records.stream()
						   .collect(Collectors.groupingBy(Record::getRegGeoRes, Collectors.counting()));
	    
	    int uniqElem = countForRegGeoRes.size();
	    
	    return new StatsString("RegGeoRes", count, uniqElem, countForRegGeoRes);
	}

	
}
