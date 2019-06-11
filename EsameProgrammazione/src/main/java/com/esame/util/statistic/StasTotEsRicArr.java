package com.esame.util.statistic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import com.esame.model.Record;
import com.esame.model.StatsNum;
import com.esame.service.Calculate;

public class StasTotEsRicArr extends StatsParent implements StatsCalculator{

	
	public StasTotEsRicArr(ArrayList<Record> RecordList) {
		super(RecordList);
	}

	
	public StatsNum run(){
		
		StatsNum retStats = new StatsNum();
		
		ArrayList<Integer> Arrayint = (ArrayList<Integer>) records.stream()
	              .map(Record::getTotEsRicArr)
	              .collect(Collectors.toList());
		
		double avg = records
				.stream()
	            .collect(Collectors.averagingInt(p -> p.getTotEsRicArr()));
		
		Record min = records
				.stream().min(Comparator.comparing( Record::getTotEsRicArr)).get();
		
		Record max = records
				.stream().max(Comparator.comparing( Record::getTotEsRicArr)).get();
		
		double std = Calculate.StdDev(Arrayint, avg);
		
		int sum = records.stream().mapToInt(Record::getTotEsRicArr).sum();
		
		int count = (int) records.stream().count();
		
		
		retStats.setField("TotEsRicArr");
		retStats.setAvg(avg);
		retStats.setMin(min.getTotEsRicArr());
		retStats.setMax(max.getTotEsRicArr());
		retStats.setSum(sum);
		retStats.setCount(count);
		retStats.setStd(std); 
		
		return retStats;
		
	}	
}
