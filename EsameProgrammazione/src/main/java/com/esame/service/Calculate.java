package com.esame.service; 

import java.util.ArrayList;

/** Rappresenta la classe statica che effettua calcoli non usuali
 * su dataset di interi ( esempio: Deviazione Standard ).
 * @author Marco Sebastianelli
 * @author Cristian Vitali
*/

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
