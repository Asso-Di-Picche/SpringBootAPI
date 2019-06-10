package com.esame.util.filter;

import com.esame.model.Record;

public class FilterTotEsRicPresIncluded  extends Filter2ParParent implements Filter  {
	
		
	public FilterTotEsRicPresIncluded(Object parametri) {
		super(parametri);
	}

	public boolean filter(Record record) {
		
		if( record.getTotEsRicPres() >= parametro1 & record.getTotEsRicPres() <= parametro2) {
			return true;
		}
		return false;
	}
}
	