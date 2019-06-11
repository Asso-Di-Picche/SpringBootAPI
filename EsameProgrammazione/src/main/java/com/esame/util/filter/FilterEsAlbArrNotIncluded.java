package com.esame.util.filter;

import com.esame.model.Record;
import com.esame.util.other.Filter;
import com.esame.util.other.Filter2ParParent;

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
	