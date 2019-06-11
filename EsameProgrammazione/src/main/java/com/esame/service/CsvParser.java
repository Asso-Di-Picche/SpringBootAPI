package com.esame.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.esame.model.Record;

public class CsvParser {

	String csvFile;
	BufferedReader br = null;                                     
	String line = "";
	ArrayList<Record> records = new ArrayList<>();
		


	public CsvParser() {}

	public ArrayList<Record> csvParsing(String csvFile){
		
		try {
			
			br = new BufferedReader(new FileReader(csvFile));				
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
					
				} catch(NumberFormatException e) {
					
				} 
				
			} 
	    
	        try {
				br.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	        
			
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		return records;
	}
}
