package com.esame.util.statistic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import com.esame.model.Record;
import com.esame.model.StatsNum;
import com.esame.service.Calculate;
import com.esame.util.other.StatsCalculator;
import com.esame.util.other.StatsParent;

public class StatsEsCompPres extends StatsParent implements StatsCalculator{

	
	public StatsEsCompPres(ArrayList<Record> RecordList) {
		super(RecordList);
	}

	
	public StatsNum run(){
		
		StatsNum retStats = new StatsNum();
		
		ArrayList<Integer> Arrayint = (ArrayList<Integer>) records.stream()
	              .map(Record::getEsCompPres)
	              .collect(Collectors.toList());
		
		double avg = records
				.stream()
	            .collect(Collectors.averagingInt(p -> p.getEsCompPres()));
		
		Record min = records
				.stream().min(Comparator.comparing( Record::getEsCompPres)).get();
		
		Record max = records
				.stream().max(Comparator.comparing( Record::getEsCompPres)).get();
		
		double std = Calculate.StdDev(Arrayint, avg);
		
		int sum = records.stream().mapToInt(Record::getEsCompPres).sum();
		
		int count = (int) records.stream().count();
		
		
		retStats.setField("EsACompPres");
		retStats.setAvg(avg);
		retStats.setMin(min.getEsCompPres());
		retStats.setMax(max.getEsCompPres());
		retStats.setSum(sum);
		retStats.setCount(count);
		retStats.setStd(std); 
		
		return retStats;
		
	}	
}
