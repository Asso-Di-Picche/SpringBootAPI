package com.esame.util.filter;

import com.esame.model.Record;

public class FilterRegGeoResIn extends FilterArrayStringParent implements Filter {

	
	public FilterRegGeoResIn(Object parametri) {
		super(parametri);
		
	}

	public boolean filter(Record record) {
		
		for(String param : param) {
			if(record.getRegGeoRes().equals(param)) {
				return true;
			}
		}
		return false;
	}
	
	
}
