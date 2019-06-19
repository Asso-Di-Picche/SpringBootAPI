package com.esame.util.other;

import java.util.ArrayList;

/** Rappresenta la superclasse per i filtri che lavorano su stringhe 
 * @author Marco Sebastianelli
 * @author Cristian Vitali
*/

public class FilterArrayStringParent {

	protected ArrayList<String> param = new ArrayList<String>();

	
	/** Costruttore 
	 * @param parametri deve essere un ArrayList String.
	 * @throws IllegalArgumentException parametri non è del tipo richiesto. 
	*/
	public FilterArrayStringParent(Object parametri) {
		
		if(parametri instanceof ArrayList<?>) {
			
			for(Object ele : (ArrayList<?>)parametri) {
				
				if(ele instanceof String) {
					param.add((String)ele);
				}else {
					throw new IllegalArgumentException("Type: String ");
				}
			}

		}else {			
			throw new IllegalArgumentException("Type: Array ");
		}
	}
	
	
	/** Set 
	 * @param parametri deve essere un ArrayList di stringhe
	 * @throws IllegalArgumentException parametri non è del tipo richiesto. 
	*/
	public void SetParametriFiltro(Object parametri) {
		
		
		if(parametri instanceof ArrayList<?>) {
			
			for(Object ele : (ArrayList<?>)parametri) {
				
				if(ele instanceof String) {
					param.add((String)ele);
				}else {
					throw new IllegalArgumentException("Type: String ");
				}
			}

		}else {			
			throw new IllegalArgumentException("Type: Array ");
		}
	}
	
	
}
