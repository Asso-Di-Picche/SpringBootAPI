package com.esame.util.filter;

import com.esame.model.Record;
import com.esame.util.other.Filter;
import com.esame.util.other.Filter2ParParent;

/** Rappresenta la classe che implemeta il filtro per il campo EsCompPres
 * con operatore: "non incluso tra" 
 * @author Marco Sebastianelli
 * @author Cristian Vitali
*/

public class FilterEsCompPresNotIncluded extends Filter2ParParent implements Filter  {
	
		
	public FilterEsCompPresNotIncluded(Object parametri) {
		super(parametri);
	}

	public boolean filter(Record record) {
		
		if( record.getEsCompPres() <= parametro1 | record.getEsCompPres() >= parametro2) {
			return true;
		}
		return false;
	}
}
	