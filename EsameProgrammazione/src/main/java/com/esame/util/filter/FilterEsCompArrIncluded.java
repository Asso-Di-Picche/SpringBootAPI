package com.esame.util.filter;

import com.esame.model.Record;
import com.esame.util.other.Filter;
import com.esame.util.other.Filter2ParParent;

public class FilterEsCompArrIncluded  extends Filter2ParParent implements Filter  {
	
		
	public FilterEsCompArrIncluded(Object parametri) {
		super(parametri);
	}

	public boolean filter(Record record) {
		
		if( record.getEsCompArr() >= parametro1 & record.getEsCompArr() <= parametro2) {
			return true;
		}
		return false;
	}
}
	