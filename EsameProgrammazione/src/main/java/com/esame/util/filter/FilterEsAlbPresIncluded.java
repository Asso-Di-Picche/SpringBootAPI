package com.esame.util.filter;

import com.esame.model.Record;

public class FilterEsAlbPresIncluded extends Filter2ParParent implements Filter  {
	
		
	public FilterEsAlbPresIncluded(Object parametri) {
		super(parametri);
	}

	public boolean filter(Record record) {
		
		if( record.getEsAlbPres() >= parametro1 & record.getEsAlbPres() <= parametro2) {
			return true;
		}
		return false;
	}
}
	