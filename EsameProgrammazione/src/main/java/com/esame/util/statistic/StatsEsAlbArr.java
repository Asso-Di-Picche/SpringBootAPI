package com.esame.util.statistic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import com.esame.model.Record;
import com.esame.model.StatsNum;
import com.esame.service.Calculate;

public class StatsEsAlbArr extends StatsParent implements StatsCalculator{

	
	public StatsEsAlbArr(ArrayList<Record> RecordList) {
		super(RecordList);
	}

	
	public StatsNum run(){
		
		StatsNum retStats = new StatsNum();
		
		ArrayList<Integer> Arrayint = (ArrayList<Integer>) records.stream()
	              .map(Record::getEsAlbArr)
	              .collect(Collectors.toList());
		
		double avg = records
				.stream()
	            .collect(Collectors.averagingInt(p -> p.getEsAlbArr()));
		
		Record min = records
				.stream().min(Comparator.comparing( Record::getEsAlbArr)).get();
		
		Record max = records
				.stream().max(Comparator.comparing( Record::getEsAlbArr)).get();
		
		double std = Calculate.StdDev(Arrayint, avg);
		
		int sum = records.stream().mapToInt(Record::getEsAlbArr).sum();
		
		int count = (int) records.stream().count();
		
		
		retStats.setField("EsAlbArr");
		retStats.setAvg(avg);
		retStats.setMin(min.getEsAlbArr());
		retStats.setMax(max.getEsAlbArr());
		retStats.setSum(sum);
		retStats.setCount(count);
		retStats.setStd(std); 
		
		return retStats;
		
	}	
}
