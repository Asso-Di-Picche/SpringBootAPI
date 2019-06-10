package com.esame.util.filter;

import com.esame.model.Record;

public class FilterEsAlbArrLess extends Filter1ParParent implements Filter {

	
	public FilterEsAlbArrLess(Object parametroFiltro) {
		super(parametroFiltro);
	}

	public boolean filter(Record record) {
		
		if(record.getEsAlbArr() < parametroFiltro) {
			return true;
		}
		return false;
	}
}
	

