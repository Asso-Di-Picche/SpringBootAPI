package com.esame.util.filter;

import com.esame.model.Record;
import com.esame.util.other.Filter;
import com.esame.util.other.FilterArrayStringParent;

/** Rappresenta la classe che implemeta il filtro per il campo PaeseRes
 * con operatore: "corrisponde a"
 * @author Marco Sebastianelli
 * @author Cristian Vitali
*/

public class FilterPaeseResIn extends FilterArrayStringParent implements Filter {

	
	public FilterPaeseResIn(Object parametri) {
		super(parametri);
		
	}

	public boolean filter(Record record) {
		
		for(String p : param) {
			if(record.getPaeseRes().equals(p)) {
				return true;
			}
		}
		return false;
	}
	
	
}
