package com.esame.util.statistic;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import com.esame.model.Record;
import com.esame.model.StatsString;
import com.esame.util.other.StatsCalculator;
import com.esame.util.other.StatsParent;


public class StatsPaeseRes extends StatsParent implements StatsCalculator {

	
	public StatsPaeseRes(ArrayList<Record> RecordList) {
		super(RecordList);
	}
	
	public StatsString run(){
		
		int count = (int) records.stream().count();

	    Map<String, Long>  countForPaeseRes= 
						   records.stream()
						   .collect(Collectors.groupingBy(Record::getPaeseRes, Collectors.counting()));
	    
	    int uniqElem = countForPaeseRes.size();
	    
	    return new StatsString("PaeseRes", count, uniqElem, countForPaeseRes);
	}

	
}
