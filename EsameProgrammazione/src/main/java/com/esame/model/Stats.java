package com.esame.model;

/** Rappresenta la superclasse contenente il nome colonna e conteggio
 * elemementi.
 * @author Marco Sebastianelli
 * @author Cristian Vitali
*/

public class Stats {
	
	public String field;
	int count;
	
	
	public Stats() {}
	
	public Stats(String field,int count) {
		this.field = field;
		this.count = count;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}