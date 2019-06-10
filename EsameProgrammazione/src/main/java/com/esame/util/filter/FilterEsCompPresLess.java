package com.esame.util.filter;

import com.esame.model.Record;

public class FilterEsCompPresLess extends Filter1ParParent implements Filter {

	
	public FilterEsCompPresLess(Object parametroFiltro) {
		super(parametroFiltro);
	}

	public boolean filter(Record record) {
		
		if(record.getEsCompPres() < parametroFiltro) {
			return true;
		}
		return false;
	}
}
	

