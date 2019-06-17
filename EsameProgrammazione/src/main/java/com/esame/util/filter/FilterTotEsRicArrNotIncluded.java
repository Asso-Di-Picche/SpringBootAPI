package com.esame.util.filter;

import com.esame.model.Record;
import com.esame.util.other.Filter;
import com.esame.util.other.Filter2ParParent;

/** Rappresenta la classe che implemeta il filtro per il campo TotEsRicArr
 * con operatore: "non incluso tra" 
 * @author Marco Sebastianelli
 * @author Cristian Vitali
*/

public class FilterTotEsRicArrNotIncluded extends Filter2ParParent implements Filter  {
	
		
	public FilterTotEsRicArrNotIncluded(Object parametri) {
		super(parametri);
	}

	public boolean filter(Record record) {
		
		if( record.getTotEsRicArr() <= parametro1 | record.getTotEsRicArr() >= parametro2) {
			return true;
		}
		return false;
	}
}
	