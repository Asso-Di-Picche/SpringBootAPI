package com.esame.service; 

import java.util.ArrayList;

public class Calculate {

	public static double StdDev(ArrayList<Integer> arrayint, double avg) {
		
		double temp = 0;
		
		for(int i: arrayint) {
			temp+=(i-avg)*(i-avg);
		}
		
		double variance = temp / (arrayint.size()-1);
		double stdDev = Math.sqrt(variance);
		
		return stdDev;
	}

}
