package com.esame.util.other;

import java.util.ArrayList;

/** Rappresenta la superclasse per i filtri che lavorano su due interi. 
 * @author Marco Sebastianelli
 * @author Cristian Vitali
*/

public class Filter2ParParent {

	protected int parametro1;
	protected int parametro2;
	
		
	/** Costruttore 
	 * @param parametri deve essere un ArrayList<Integer> di lunghezza 2.
	 * @throws IllegalArgumentException parametri non è del tipo richiesto. 
	*/
	public Filter2ParParent(Object parametro){

		if(parametro instanceof ArrayList<?>) {
				
			if( ((ArrayList<?>) parametro).size() != 2) {
				throw new IndexOutOfBoundsException("2 Integer ") ;
			}//control of array length 
												
			if(((ArrayList<?>) parametro).get(0) instanceof Integer) {
				parametro1 = (int) ((ArrayList<?>) parametro).get(0) ;
			}else {throw new IllegalArgumentException("Type: Integer ");}
					
			if(((ArrayList<?>) parametro).get(1) instanceof Integer) {
				parametro2 = (int) ((ArrayList<?>) parametro).get(1) ;
			}else{throw new IllegalArgumentException("Type: Integer ");}			
					
					
		}else {
			throw new IllegalArgumentException("Type: Array of 2 Integer ");
		}
		
		if(parametro2 < parametro1) {
			throw new IllegalArgumentException("Integer two must be greater than Integer one ");
		}
	}


	
	/** Set
	 * @param parametri deve essere un ArrayList<Integer> di lunghezza 2.
	 * @throws IllegalArgumentException parametri non è del tipo richiesto. 
	*/
	
	public void setParametri (Object parametro) {
		
		if(parametro instanceof ArrayList<?>) {
			
			if( ((ArrayList<?>) parametro).size() != 2) {
				throw new IndexOutOfBoundsException("2 Integer ") ;
			}//control of array length 
												
			if(((ArrayList<?>) parametro).get(0) instanceof Integer) {
				parametro1 = (int) ((ArrayList<?>) parametro).get(0) ;
			}else {throw new IllegalArgumentException("Type: Integer ");}
					
			if(((ArrayList<?>) parametro).get(1) instanceof Integer) {
				parametro2 = (int) ((ArrayList<?>) parametro).get(1) ;
			}else{throw new IllegalArgumentException("Type: Integer ");}			
					
			
		}else {
			throw new IllegalArgumentException("Type: Array of 2 Integer ");
		}
		
		if(parametro2 < parametro1) {
			throw new IllegalArgumentException("Integer two must be greater than Integer one ");
		}
	}
	
	public int getParametro1() {
		return parametro1;
	}


	public void setParametro1(int parametro1) {
		this.parametro1 = parametro1;
	}


	public int getParametro2() {
		return parametro2;
	}


	public void setParametro2(int parametro2) {
		this.parametro2 = parametro2;
	}
	
	



}
