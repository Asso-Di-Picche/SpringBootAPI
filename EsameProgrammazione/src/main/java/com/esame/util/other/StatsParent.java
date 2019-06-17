package com.esame.util.other;

import java.util.ArrayList;
import com.esame.model.Record;

/** Rappresenta la superclasse per i calcolatori di statistiche.
 * @author Marco Sebastianelli
 * @author Cristian Vitali
*/

public class StatsParent {

	protected ArrayList<Record> records;
	
	/** Costruttore 
	 * @param RecordList array su cui si vuol calcolare la statistica 
	*/
	public StatsParent(ArrayList<Record> RecordList) {
		this.records = RecordList;
	}

}
