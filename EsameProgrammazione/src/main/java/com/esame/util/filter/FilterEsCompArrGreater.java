package com.esame.util.filter;

import com.esame.model.Record;

public class FilterEsCompArrGreater extends Filter1ParParent implements Filter {

	
	public FilterEsCompArrGreater(Object parametroFiltro) {
		super(parametroFiltro);
	}

	public boolean filter(Record record) {
		
		if(record.getEsCompArr() > parametroFiltro) {
			return true;
		}
		return false;
	}
}

