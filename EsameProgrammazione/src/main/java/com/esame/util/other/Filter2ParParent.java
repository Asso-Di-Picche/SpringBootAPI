package com.esame.util.other;

import java.util.ArrayList;

public class Filter2ParParent {

	protected int parametro1;
	protected int parametro2;
	
	
	public Filter2ParParent(Object parametro){

		if(parametro instanceof ArrayList<?>) {
				
			if( ((ArrayList) parametro).size() != 2) {
				throw new IndexOutOfBoundsException("inserire due soli interi") ;
			}//control of array length 
												
			if(((ArrayList) parametro).get(0) instanceof Integer) {
				parametro1 = (int) ((ArrayList) parametro).get(0) ;
			}else {throw new IllegalArgumentException("Parametri devono essere interi");}
					
			if(((ArrayList) parametro).get(1) instanceof Integer) {
				parametro2 = (int) ((ArrayList) parametro).get(1) ;
			}else{throw new IllegalArgumentException("Parametri devono essere interi");}			
					
					
		}else {
			throw new IllegalArgumentException("il parametro deve essere un arrayList di interi");
		}
		
		if(parametro2 < parametro1) {
			throw new IllegalArgumentException("il parametro 2 non può essere minore del parametro 1");
		}
	}


	
	
	public void setParametri (Object parametro) {
		
		if(parametro instanceof ArrayList<?>) {
			
			if( ((ArrayList) parametro).size() != 2) {
				throw new IndexOutOfBoundsException("inserire due soli interi") ;
			}//control of array length 
												
			if(((ArrayList) parametro).get(0) instanceof Integer) {
				parametro1 = (int) ((ArrayList) parametro).get(0) ;
			}else {throw new IllegalArgumentException("Parametri devono essere interi");}
					
			if(((ArrayList) parametro).get(1) instanceof Integer) {
				parametro2 = (int) ((ArrayList) parametro).get(1) ;
			}else{throw new IllegalArgumentException("Parametri devono essere interi");}			
					
			
		}else {
			throw new IllegalArgumentException("il parametro deve essere un arrayList di interi");
		}
		
		if(parametro2 < parametro1) {
			throw new IllegalArgumentException("il parametro 2 non può essere minore del parametro 1");
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
