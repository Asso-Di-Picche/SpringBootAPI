package com.esame.model;

import java.util.Map;

/** Rappresenta la classe i cui oggetti sono la risposta 
 * alla richiesta Stats su valori colonna String.
 * @author Marco Sebastianelli
 * @author Cristian Vitali
*/

public class StatsString extends Stats {
	
	int uniqElem;
	Map<String,Long> occurrences;

	
	public StatsString() {
		super();
	}

	
	public StatsString(String field, int count, int uniqElem, Map<String,Long> occurrences) {
		
		super(field, count);
		this.uniqElem = uniqElem;
		this.occurrences = occurrences;
	}

	public int getUniqElem() {
		return uniqElem;
	}

	public void setUniqElem(int uniqElem) {
		this.uniqElem = uniqElem;
	}

	public Map<String, Long> getOccurrences() {
		return occurrences;
	}

	public void setOccurrences(Map<String, Long> occurrences) {
		this.occurrences = occurrences;
	}
	
}
