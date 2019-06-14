package com.esame.util.other;

import java.util.ArrayList;

public class FilterArrayStringParent {

	protected ArrayList<String> param = new ArrayList<String>();

	
	public FilterArrayStringParent(Object parametri) {
		
		if(parametri instanceof ArrayList<?>) {
			
			for(Object ele : (ArrayList)parametri) {
				
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
	
	
	public void SetParametriFiltro(Object parametri) {
		
		if(parametri instanceof  ArrayList<?>) {
			//this.parametri = (String[])parametri;
			System.out.println("ciao");
		}
	
	}
	
}
