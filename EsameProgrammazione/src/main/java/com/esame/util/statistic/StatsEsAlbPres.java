package com.esame.util.statistic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import com.esame.model.Record;
import com.esame.model.StatsNum;
import com.esame.service.Calculate;

public class StatsEsAlbPres extends StatsParent implements StatsCalculator{

	
	public StatsEsAlbPres(ArrayList<Record> RecordList) {
		super(RecordList);
	}

	
	public StatsNum run(){
		
		StatsNum retStats = new StatsNum();
		
		ArrayList<Integer> Arrayint = (ArrayList<Integer>) records.stream()
	              .map(Record::getEsAlbPres)
	              .collect(Collectors.toList());
		
		double avg = records
				.stream()
	            .collect(Collectors.averagingInt(p -> p.getEsAlbPres()));
		
		Record min = records
				.stream().min(Comparator.comparing( Record::getEsAlbPres)).get();
		
		Record max = records
				.stream().max(Comparator.comparing( Record::getEsAlbPres)).get();
		
		double std = Calculate.StdDev(Arrayint, avg);
		
		int sum = records.stream().mapToInt(Record::getEsAlbPres).sum();
		
		int count = (int) records.stream().count();
		
		
		retStats.setField("EsAlbPres");
		retStats.setAvg(avg);
		retStats.setMin(min.getEsAlbPres());
		retStats.setMax(max.getEsAlbPres());
		retStats.setSum(sum);
		retStats.setCount(count);
		retStats.setStd(std); 
		
		return retStats;
		
	}	
}
