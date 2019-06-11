package com.esame.model;


public class StatsNum extends Stats {

	public long avg;
	public int min;
	public int max;
	public double std;
	public int sum;
	
	
	public StatsNum() {
		super();
	}
	
	
	public StatsNum(String field, long avg, int min, int max, 
			        long std, int sum, int count) {

		super(field,count);
		this.avg = avg;
		this.min = min;
		this.max = max;
		this.std = std;
		this.sum = sum;

	}
	

	public long getAvg() {
		return (long) avg;
	}

	public void setAvg(double avg2) {
		this.avg = (long) avg2;
	}

	public long getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public long getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public double getStd() {
		return std;
	}

	public void setStd(double std) {
		this.std = std;
	}

	public long getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

}
