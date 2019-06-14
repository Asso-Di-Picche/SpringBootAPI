package com.esame.database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import com.esame.model.Metadata;
import com.esame.model.Record;
import com.esame.service.CsvParser;



public class DatabaseClass {

	private static ArrayList<Record>  records = new ArrayList<Record>();
	private static ArrayList<Metadata> metadata = new ArrayList<Metadata>();

	
	public static ArrayList<Record> getRecords() {
		return records;
	}	

	public static ArrayList<Metadata> getArrayMetadata() {
		
		metadata.add(new Metadata("ProvDest","Provincia di destinazione","String"));
		metadata.add(new Metadata("RegGeoRes","Regione geografica di residenza","String"));
		metadata.add(new Metadata("PaeseRes","Paese di residenza","String"));
		metadata.add(new Metadata("EsAlbArr","Esercizi alberghieri - Arrivi","Integer"));
		metadata.add(new Metadata("EsAlbPres","Esercizi alberghieri - Presenze","Integer"));
		metadata.add(new Metadata("EsCompArr","Esercizi complementari - Arrivi","Integer"));
		metadata.add(new Metadata("EsCompPres","Esercizi complementari - Presenze","Integer"));
		metadata.add(new Metadata("TotEsRicArr","Totale esercici ricettivi - Arrivi","Integer"));
		metadata.add(new Metadata("TotEsRicPres","Totale esercici ricettivi - Presenze","Integer"));
		return metadata;
	}	
	
	public static void downloadCsv(String url) {
		
		try {
			
			URLConnection openConnection = new URL(url).openConnection();
			openConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
			InputStream in = openConnection.getInputStream();
			
			String data = "";
			String line = "";
			try {
				InputStreamReader inR = new InputStreamReader( in );
				BufferedReader buf = new BufferedReader( inR );
				  
				while ( ( line = buf.readLine() ) != null ) {
					data+= line;
				}
			} finally {
				in.close();
			}
			 
			JSONObject obj = (JSONObject) JSONValue.parseWithException(data); 
			JSONObject objI = (JSONObject) (obj.get("result"));
			JSONArray objA = (JSONArray) (objI.get("resources"));
			
			for(Object o: objA){
				if ( o instanceof JSONObject ) {
			    	JSONObject o1 = (JSONObject)o; 
			    	String name = (String)o1.get("name");
			    	String urlD = (String)o1.get("url");
			    	if(name.equals("Dati anno 2016")) {
			        	download(urlD, "configFile/dataset.csv");
		        	}
			 	}
			}
			
		} catch(ParseException e) {
			System.out.println(
				"Errore in in com.example.demo.service.DatabaseClass.java: "
				+ "Errore nel parsing String - JsonObject");
		} catch (IOException e) {
			System.out.println("Errore in in com.example.demo.service.DatabaseClass.java: "
				+ "Controlla la validità dell URL o Verifica la tua connessione internet");
		}
	}
	
	
	public static void download(String url, String fileName){
		try (InputStream in = URI.create(url).toURL().openStream()) {
			Files.copy(in, Paths.get(fileName), StandardCopyOption.REPLACE_EXISTING);
			records = CsvParser.csvParsing("configFile/dataset.csv");
		} catch ( IOException e) {
			//errore in scrittura
			System.out.println("Errore in in com.example.demo.service.DatabaseClass.java: "
					+ "Errore nella copia del File nella cartella configFile");
		}
	}
	
}
