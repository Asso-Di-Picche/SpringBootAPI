package com.esame.util.statistic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import com.esame.model.Record;
import com.esame.model.StatsNum;
import com.esame.service.Calculate;
import com.esame.util.other.StatsCalculator;
import com.esame.util.other.StatsParent;

public class StatsTotEsRicPres extends StatsParent implements StatsCalculator{

	
	public StatsTotEsRicPres(ArrayList<Record> RecordList) {
		super(RecordList);
	}

	
	public StatsNum run(){
		
		StatsNum retStats = new StatsNum();
		
		ArrayList<Integer> Arrayint = (ArrayList<Integer>) records.stream()
	              .map(Record::getTotEsRicPres)
	              .collect(Collectors.toList());
		
		double avg = records
				.stream()
	            .collect(Collectors.averagingInt(p -> p.getTotEsRicPres()));
		
		Record min = records
				.stream().min(Comparator.comparing( Record::getTotEsRicPres)).get();
		
		Record max = records
				.stream().max(Comparator.comparing( Record::getTotEsRicPres)).get();
		
		double std = Calculate.StdDev(Arrayint, avg);
		
		int sum = records.stream().mapToInt(Record::getTotEsRicPres).sum();
		
		int count = (int) records.stream().count();
		
		
		retStats.setField("TotEsRicPres");
		retStats.setAvg(avg);
		retStats.setMin(min.getTotEsRicPres());
		retStats.setMax(max.getTotEsRicPres());
		retStats.setSum(sum);
		retStats.setCount(count);
		retStats.setStd(std); 
		
		return retStats;
		
	}	
}
