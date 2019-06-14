package com.esame.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.PatternSyntaxException;

import com.esame.model.Record;

public class CsvParser {

	String csvFile;
	static BufferedReader br = null;                                     
	static String line = "";
	static int riga = 1;
	static ArrayList<Record> records = new ArrayList<>();
		


	public CsvParser() {}

	public static ArrayList<Record> csvParsing(String csvFile){
		
		try {
			
			br = new BufferedReader(new FileReader(csvFile));
			br.readLine(); // leggi la prima riga e ignorala
			
			while ((line = br.readLine()) != null) {	
				
				try {
			
			        // usa virgola e spazio come separatore
			        String[] recordCorrente = line.split(";");	
			 			        
			        // crea un oggetto di tipo Record
			        Record oggettoRecord = new Record(
			        							recordCorrente[0], 
			        							recordCorrente[1],
			        							recordCorrente[2],
												Integer.parseInt(recordCorrente[3]),
												Integer.parseInt(recordCorrente[4]),
												Integer.parseInt(recordCorrente[5]),
												Integer.parseInt(recordCorrente[6]),
												Integer.parseInt(recordCorrente[7]),
												Integer.parseInt(recordCorrente[8])						
					);
			        
			        records.add(oggettoRecord);
			        
				} catch(ArrayIndexOutOfBoundsException e) {
					System.out.println("Riga #"+riga+"  "+e.toString()
									  +" parametri inseriti. Aspettati 9");
				} catch(NumberFormatException e) {
					System.out.println("Riga #"+riga+"  "+e.toString());
				} 
				riga++;
			}
	     
			try {
				br.close();
	        } catch (IOException e) {
	        	System.out.println(e.getClass().getCanonicalName()
	    	        	+"Errore in in com.example.demo.service.ParseCsv.java: Chiusura File");
	    	        }
	       
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getClass().getCanonicalName()
		    +"Errore in com.example.demo.service.ParseCsv.java: File non trovato");
		} catch (IOException e) {
			System.out.println(e.getClass().getCanonicalName()
			+"Errore in com.example.demo.service.ParseCsv.java: Operazione di I/O interrotte");
		}
		
		return records;
	}
}
