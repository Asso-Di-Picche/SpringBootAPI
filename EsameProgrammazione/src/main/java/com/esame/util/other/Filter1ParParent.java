package com.esame.util.other;

public class Filter1ParParent {

	protected int parametroFiltro;
	
	public Filter1ParParent(Object parametroFiltro){
		
		if(parametroFiltro instanceof Integer ) { 
			this.parametroFiltro =(Integer)parametroFiltro;
		}else {
			throw new IllegalArgumentException("il parametro deve essere un intero");
		}
		
	}
		
	public void setParametroFiltro(Object parametroFiltro) {
		
		if(parametroFiltro instanceof Integer ) { 
			this.parametroFiltro =(Integer)parametroFiltro;
		}else {
			throw new IllegalArgumentException("il parametro deve essere un intero");
		}
	}

	// Overloading
	public void setParametroFiltro(int parametroFiltro) {
		this.parametroFiltro = parametroFiltro;
	}

	public int getParametroFiltro() {
		return parametroFiltro;
	}
}
