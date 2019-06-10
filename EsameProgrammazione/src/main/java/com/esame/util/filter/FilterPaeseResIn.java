package com.esame.util.filter;

import com.esame.model.Record;

public class FilterPaeseResIn extends FilterArrayStringParent implements Filter {

	
	public FilterPaeseResIn(Object parametri) {
		super(parametri);
		
	}

	public boolean filter(Record record) {
		
		for(String param : param) {
			if(record.getPaeseRes().equals(param)) {
				return true;
			}
		}
		return false;
	}
	
	
}
