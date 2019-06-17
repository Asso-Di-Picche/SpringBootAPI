package com.esame.util.filter;

import com.esame.model.Record;
import com.esame.util.other.Filter;
import com.esame.util.other.FilterArrayStringParent;

/** Rappresenta la classe che implemeta il filtro per il campo PaeseRes
 * con operatore: "non corrisponde a"
 * @author Marco Sebastianelli
 * @author Cristian Vitali
*/

public class FilterPaeseResNin extends FilterArrayStringParent implements Filter {

	
	public FilterPaeseResNin(Object parametri) {
		super(parametri);
		
	}

	public boolean filter(Record record) {
		
		for(String param : param) {
			if(record.getPaeseRes().equals(param)) {
				return false;
			}
		}
		return true;
	}
	
	
}