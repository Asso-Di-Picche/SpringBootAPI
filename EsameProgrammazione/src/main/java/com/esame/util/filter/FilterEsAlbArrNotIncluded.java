package com.esame.util.filter;

import com.esame.model.Record;
import com.esame.util.other.Filter;
import com.esame.util.other.Filter2ParParent;

/** Rappresenta la classe che implemeta il filtro per il campo EsAlbArr
 * con operatore: "non incluso tra" 
 * @author Marco Sebastianelli
 * @author Cristian Vitali
*/

public class FilterEsAlbArrNotIncluded extends Filter2ParParent implements Filter  {
	
		
	public FilterEsAlbArrNotIncluded(Object parametri) {
		super(parametri);
	}

	public boolean filter(Record record) {
		
		if( record.getEsAlbArr() <= parametro1 | record.getEsAlbArr() >= parametro2) {
			return true;
		}
		return false;
	}
}
	