package com.esame.util.filter;

import java.util.ArrayList;

public class FilterArrayStringParent {

	public ArrayList<String> param = new ArrayList<String>();

	
	public FilterArrayStringParent(Object parametri) {
		
		if(parametri instanceof ArrayList<?>) {
			
			for(Object ele : (ArrayList)parametri) {
				
				if(ele instanceof String) {
					param.add((String)ele);
				}else {
					throw new IllegalArgumentException("Parametri devono essere Stringhe");
				}
			}

		}else {			
			throw new IllegalArgumentException("Paremetri devono essere un Array");
		}
	}
	
	
	public void SetParametriFiltro(Object parametri) {
		
		if(parametri instanceof  ArrayList<?>) {
			//this.parametri = (String[])parametri;
			System.out.println("ciao");
		}
	
	}
	
}
