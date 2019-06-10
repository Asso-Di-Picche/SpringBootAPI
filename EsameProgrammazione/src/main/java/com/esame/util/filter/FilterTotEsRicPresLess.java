package com.esame.util.filter;

import com.esame.model.Record;

public class FilterTotEsRicPresLess extends Filter1ParParent implements Filter {

	
	public FilterTotEsRicPresLess(Object parametroFiltro) {
		super(parametroFiltro);
	}

	public boolean filter(Record record) {
		
		if(record.getTotEsRicPres() < parametroFiltro) {
			return true;
		}
		return false;
	}
}
	

