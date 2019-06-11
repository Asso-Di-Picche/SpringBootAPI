package com.esame.util.filter;

import com.esame.model.Record;
import com.esame.util.other.Filter;
import com.esame.util.other.Filter1ParParent;

public class FilterEsAlbPresLess extends Filter1ParParent implements Filter {

	
	public FilterEsAlbPresLess(Object parametroFiltro) {
		super(parametroFiltro);
	}

	public boolean filter(Record record) {
		
		if(record.getEsAlbPres() < parametroFiltro) {
			return true;
		}
		return false;
	}
}
	

