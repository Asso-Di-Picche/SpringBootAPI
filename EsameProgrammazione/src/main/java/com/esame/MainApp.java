package com.esame;

import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.esame.database.DatabaseClass;

/** All'avvio effettua il download del dataset e avvia l'applicazione Spring.
 * @author Marco Sebastianelli
 * @author Cristian Vitali
*/

@SpringBootApplication
public class MainApp {

		public static void main(String[] args) {
			DatabaseClass.downloadCsv("https://www.dati.gov.it/api/3/action/package_show?id=fd5e0f99-f778-4ccc-8c19-2a9fbfa59b6c");
			SpringApplication.run(MainApp.class, args);
		}
}
