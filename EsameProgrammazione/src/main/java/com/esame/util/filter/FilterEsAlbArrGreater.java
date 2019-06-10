package com.esame.util.filter;

import com.esame.model.Record;

public class FilterEsAlbArrGreater extends Filter1ParParent implements Filter {

	
	public FilterEsAlbArrGreater(Object parametroFiltro) {
		super(parametroFiltro);
	}

	public boolean filter(Record record) {
		
		if(record.getEsAlbArr() > parametroFiltro) {
			return true;
		}
		return false;
	}
}
