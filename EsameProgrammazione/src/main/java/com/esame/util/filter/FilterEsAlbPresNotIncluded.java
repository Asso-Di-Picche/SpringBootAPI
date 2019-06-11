package com.esame.util.filter;

import com.esame.model.Record;
import com.esame.util.other.Filter;
import com.esame.util.other.Filter2ParParent;

public class FilterEsAlbPresNotIncluded extends Filter2ParParent implements Filter  {
	
		
	public FilterEsAlbPresNotIncluded(Object parametri) {
		super(parametri);
	}

	public boolean filter(Record record) {
		
		if( record.getEsAlbPres() <= parametro1 | record.getEsAlbPres() >= parametro2) {
			return true;
		}
		return false;
	}
}
	