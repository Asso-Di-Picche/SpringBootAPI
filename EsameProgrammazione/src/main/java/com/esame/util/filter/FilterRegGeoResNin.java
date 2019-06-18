package com.esame.util.filter;

import com.esame.model.Record;
import com.esame.util.other.Filter;
import com.esame.util.other.FilterArrayStringParent;

/** Rappresenta la classe che implemeta il filtro per il campo RegGeo
 * con operatore: "non corrisponde a"
 * @author Marco Sebastianelli
 * @author Cristian Vitali
*/

public class FilterRegGeoResNin extends FilterArrayStringParent implements Filter {

	
	public FilterRegGeoResNin(Object parametri) {
		super(parametri);
		
	}

	public boolean filter(Record record) {
		
		for(String param : param) {
			if(record.getRegGeoRes().equals(param)) {
				return false;
			}
		}
		return true;
	}
	
	
}