package com.esame.util.filter;

import com.esame.model.Record;

public class FilterEsAlbArrNotIncluded extends Filter2ParParent implements Filter  {
	
		
	public FilterEsAlbArrNotIncluded(Object parametri) {
		super(parametri);
	}

	public boolean filter(Record record) {
		
		if( record.getEsAlbArr() <= parametro1 & record.getEsAlbArr() >= parametro2) {
			return true;
		}
		return false;
	}
}
	