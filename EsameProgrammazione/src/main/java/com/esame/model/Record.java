package com.esame.model;

public class Record {

	protected String ProvDest ;
	protected String RegGeoRes ;
	protected String PaeseRes ;
	protected int EsAlbArr;
	protected int EsAlbPres;
	protected int EsCompArr;
	protected int EsCompPres;
	protected int TotEsRicArr;
	protected int TotEsRicPres;


	public Record(String provDest, String regGeoRes, String paeseRes, 
				  int esAlbArr, int esAlbPres, int esCompArr,
				  int esCompPres, int totEsRicArr, int totEsRicPres) {

		ProvDest = provDest;
		RegGeoRes = regGeoRes;
		PaeseRes = paeseRes;
		EsAlbArr = esAlbArr;
		EsAlbPres = esAlbPres;
		EsCompArr = esCompArr;
		EsCompPres = esCompPres;
		TotEsRicArr = totEsRicArr;
		TotEsRicPres = totEsRicPres;
	}


	public String getProvDest() {
		return ProvDest;
	}


	public void setProvDest(String provDest) {
		ProvDest = provDest;
	}


	public String getRegGeoRes() {
		return RegGeoRes;
	}


	public void setRegGeoRes(String regGeoRes) {
		RegGeoRes = regGeoRes;
	}


	public String getPaeseRes() {
		return PaeseRes;
	}


	public void setPaeseRes(String paeseRes) {
		PaeseRes = paeseRes;
	}


	public int getEsAlbArr() {
		return EsAlbArr;
	}


	public void setEsAlbArr(int esAlbArr) {
		EsAlbArr = esAlbArr;
	}


	public int getEsAlbPres() {
		return EsAlbPres;
	}


	public void setEsAlbPres(int esAlbPres) {
		EsAlbPres = esAlbPres;
	}


	public int getEsCompArr() {
		return EsCompArr;
	}


	public void setEsCompArr(int esCompArr) {
		EsCompArr = esCompArr;
	}


	public int getEsCompPres() {
		return EsCompPres;
	}


	public void setEsCompPres(int esCompPres) {
		EsCompPres = esCompPres;
	}


	public int getTotEsRicArr() {
		return TotEsRicArr;
	}


	public void setTotEsRicArr(int totEsRicArr) {
		TotEsRicArr = totEsRicArr;
	}


	public int getTotEsRicPres() {
		return TotEsRicPres;
	}


	public void setTotEsRicPres(int totEsRicPres) {
		TotEsRicPres = totEsRicPres;
	}	
}