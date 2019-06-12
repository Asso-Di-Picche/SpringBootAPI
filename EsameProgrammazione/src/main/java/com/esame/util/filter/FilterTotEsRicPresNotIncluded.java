package com.esame.util.filter;

import com.esame.model.Record;
import com.esame.util.other.Filter;
import com.esame.util.other.Filter2ParParent;

public class FilterTotEsRicPresNotIncluded extends Filter2ParParent implements Filter  {
	
		
	public FilterTotEsRicPresNotIncluded(Object parametri) {
		super(parametri);
	}

	public boolean filter(Record record) {
		
		if( record.getTotEsRicPres() <= parametro1 | record.getTotEsRicPres() >= parametro2) {
			return true;
		}
		return false;
	}
}
	