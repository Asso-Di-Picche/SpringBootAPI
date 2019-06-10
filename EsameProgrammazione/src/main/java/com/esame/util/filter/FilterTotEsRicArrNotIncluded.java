package com.esame.util.filter;

import com.esame.model.Record;

public class FilterTotEsRicArrNotIncluded extends Filter2ParParent implements Filter  {
	
		
	public FilterTotEsRicArrNotIncluded(Object parametri) {
		super(parametri);
	}

	public boolean filter(Record record) {
		
		if( record.getTotEsRicArr() <= parametro1 & record.getTotEsRicArr() >= parametro2) {
			return true;
		}
		return false;
	}
}
	