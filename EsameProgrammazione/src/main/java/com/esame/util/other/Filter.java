package com.esame.util.other;

import com.esame.model.Record;

/** Rappresenta l interfaccia per i filtri.
 * @author Marco Sebastianelli
 * @author Cristian Vitali
*/
public interface Filter {

	
	/** questo metodo restituisce True se il record rispetta le caratteristiche 
	 * richeste del filtro che implementa l'interfaccia.
	 * @param record su cui si vuol esegurire la verifica.
	*/
	public boolean filter(Record record);
}
