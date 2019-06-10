package com.esame.util.filter;

import com.esame.model.Record;

public class FilterEsCompArrLess extends Filter1ParParent implements Filter {

	
	public FilterEsCompArrLess(Object parametroFiltro) {
		super(parametroFiltro);
	}

	public boolean filter(Record record) {
		
		if(record.getEsCompArr() < parametroFiltro) {
			return true;
		}
		return false;
	}
}
	

