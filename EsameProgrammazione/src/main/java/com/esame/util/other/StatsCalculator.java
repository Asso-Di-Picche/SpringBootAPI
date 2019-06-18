package com.esame.util.other;

import com.esame.model.Stats;

/** Rappresenta l interfaccia per StatsCalculator.
 * @author Marco Sebastianelli
 * @author Cristian Vitali
*/

public interface StatsCalculator {

	/** questo metodo calcola una statistica
	 * @return Stats un oggetto che rappresenta la statistica
	*/
	public Stats run();
}
