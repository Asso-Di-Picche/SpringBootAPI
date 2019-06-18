package com.esame.util.filter;

import com.esame.model.Record;
import com.esame.util.other.Filter;
import com.esame.util.other.Filter1ParParent;

/** Rappresenta la classe che implemeta il filtro per il campo TotEsRicPres
 * con operatore: "minore di" 
 * @author Marco Sebastianelli
 * @author Cristian Vitali
*/

public class FilterTotEsRicPresLess extends Filter1ParParent implements Filter {

	
	public FilterTotEsRicPresLess(Object parametroFiltro) {
		super(parametroFiltro);
	}

	public boolean filter(Record record) {
		
		if(record.getTotEsRicPres() < parametroFiltro) {
			return true;
		}
		return false;
	}
}
	

