package com.esame.util.filter;

import com.esame.model.Record;
import com.esame.util.other.Filter;
import com.esame.util.other.Filter1ParParent;

/** Rappresenta la classe che implemeta il filtro per il campo EsCompArr
 * con operatore: "maggiore di" 
 * @author Marco Sebastianelli
 * @author Cristian Vitali
*/

public class FilterEsCompArrGreater extends Filter1ParParent implements Filter {

	
	public FilterEsCompArrGreater(Object parametroFiltro) {
		super(parametroFiltro);
	}

	public boolean filter(Record record) {
		
		if(record.getEsCompArr() > parametroFiltro) {
			return true;
		}
		return false;
	}
}

