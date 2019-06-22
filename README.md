# Spring boot Web Service

Un Web Service è un sistema software in grado di mettersi al servizio di un Client (applicazione, sito web, Postman), comunicando tramite il protocollo HTTP. Un Web service consente quindi agli utenti che vi si collegano di usufruire delle funzioni che mette a disposizione. Con Spring Boot, è stato possibile creare questo software che lancia l'intera applicazione web, compreso il web server integrato.

Il Data-set rappresenta la provenienza dei turisti che hanno visitato la regione Lazio o le sue provincie (es. Viterbo). I turisti sono catalogati per paese di residenza (es. Italia) e regione geografica di residenza (es. Unione Europea). I dati sono registrati in Esercizi Alberghieri (arrivi e presenze), Esercizi Complementari (arrivi e presenze) e Totale Esercizi Ricettivi (arrivi e presenze).

La nostra applicazione permette di richiedere mediante API REST (GET o POST) con rotte distinte:

* Restituzione dei metadati, formato JSON, ovvero l’elenco degli attributi, alias degli stessi e tipo di dati contenuti.
* Restituzione dei dati riguardanti ogni record, formato JSON.
* Restituzione dei dati riguardanti record filtrati, formato JSON.
* Restituzione delle statistiche sui dati di uno specifico campo.
* Restituzione delle statistiche sui dati di uno specifico campo, su record filtrati.

note: [come effettuare richieste.](https://github.com/CriVitali/EsameProgrammazione#eseguire-richieste)

<img src="https://aangrw.db.files.1drv.com/y4mEhRW6T5TB0O0Mho701IYnQXQdDOJF2mQIUPNw_R71E2z5FatOYllR78DkHytWX_s-z2WZ69ykeVfNwLCduu1MFWid4BNliwPp9FYPhB1qqdcoyDOqG2T03lKZzPiVdvYNbpL37gHcxiQJ5Eux9jGGmxijLTeBb1gtI7e4VUQezMYX_q2GLxltMmZADDv3Nse?width=1633&height=961&cropmode=none" width="500"/>



## Come iniziare 

### Download 

Usando l'ide eclipse si possono seguire i seguenti passi:
- aprire eclipse, nella Show view premere il pulsante "clone a Git Repository".
- nella finestra che appare, incollare URL di questa repository nella casella URI e procedere.
- recarsi nel clone della repository che apparirà, tasto destro quindi Import Project (verificare che sia importato come progetto Maven) e procedere.
- a questo punto potete provare ad eseguire il codice, selezionando "nome_Progetto" tasto destro, "Run as" e quindi "Sprign boot App".

In alternativa su linux senza l'utilizzo del ide eclipse si puo scaricare il file Zip ed estrarlo, da terminale recarsi nella directory, digitare il comando `mvn clean install` se il BUILD avrà suceccesso, all'interno del progetto nella directory target si troveranno i file compilati. Per eseguire il programma `java -jar target/nomeProgettoCompilato.jar` (oppure `mvn spring-boot:run`).

Ora l'aplicazione Web Service sarà attiva e in ascolto alla porta http://localhost:8080.

### Eseguire richieste

Per eseguire le richieste GET o POST si può installare un API testing, (ad esempio: Postman). 
La seguente tabella mostra le richieste possibili. 



|    TIPO        |rotta                          |descrizione                                |
|----------------|-------------------------------|-------------------------------------------|
|GET             |/metadata                      |restituisce gli alias utilizzati           |
|GET             |/data                          |restituisce l'intero dataset               |
|GET             |/stats?field="nome"      |restituisce una statistica sul "nome" specificato fatta sull'intero dataset.     |
|POST            |/data                          |restituisce i record che rispettano i filtri specificati nel body della richiesta                                     |
|POST            |/stats?field="nome"      |restituisce una statistica sul "nome" specificato basandosi sui record che rispettano i filtri specificati nel body della richiesta |



La segunete tabella mostra i filtri disponibili


| Nome operatore | Descrizione                                |Esempio                                     |
|----------------|--------------------------------------------|--------------------------------------------|
|Greater         |maggiore (valido per campi numerici)        |{"EsAlbArr":{"Greater":100000}}            |
|Less            |minore (valido per campi numerici)          |{"EsAlbArr":{"Less":100000}}               |
|Included        |compreso tra  (valido per campi numerici)   |{"EsAlbArr":{"Included":[100,5000]}}      |     
|NotIncluded     |non compreso tra  (valido per campi numerici) |{"EsAlbArr":{"NotIncluded":[100,5000]}} |
|In              |trova una corrispondeza con i valori dell'array (valido per stringhe)|	{"ProvDest":{"In":["Roma"]}}|
|Nin             |non trova una corrispondeza con i valori dell'array (valido per stringhe)|	{"ProvDest":{"Nin":["Roma","Viterbo"]}}|



Inoltre è possibile combinare più filtri, per fare questo, è sufficiente specificare il modo in cui si vogliono combinare i fitlri utilizzati: **and** oppure **or** prima dell'operatore, utilizzando il comando *"type"*. Ad esempio il filtraggio seguente selezionarà i record che hanno EsAlbPres compreso tra 10 e 1000 ma abbiano anche nel campo ProvDest Roma:                                                                                                               

`{
	"EsAlbPres":{"Included":[10,1000]},
	"ProvDest":{"type":"and","In":["Roma"]}    
}`

note: è possibile inserire un filtro per ogni campo contemporaneamente, concatenati nel modo desiderato(**and/or**).

## Sviluppo

### Package
<img src="https://rppelg.db.files.1drv.com/y4maciwzZJ9nH7Wm3HyjkPmrMvktnQiSU_ZemRVRfVzy35kYy5nyRCbNHqaa7B1BK6j7XstmwmpAYtRUrq_O5tk_lr4_lHnS-Vme5Jd9YRFyqcRXg9MfWf6QY_V1Aj7GfpBennaT41-Iwh6-qyvZXxTuhc7bH3A2QWC-IlQx0YUONN_uM-ph9E3E602rsTip20u?width=1683&height=939&cropmode=none" width="800"/>

### Classi
* **Package com.esame.controller**
<img src="https://aamxpq.db.files.1drv.com/y4m5bzw69D848mwxyKNJbZbIHmgWUlc1G1_rJj6LWa_-CJR87ObrwRQBoB274o_s0VbOcn2QALib_DG8VUR6oZzCBGJ0yeyGgpf5k34tEIeonaKBNqrrGVYwTw7-67Xz0RdqD7uImtcw-Sn_jPYWEJ5_TFJePlxl889h6xv0AQHWfYTBvFMVI-vBtWkFJObKSZn?width=933&height=437&cropmode=none" width="400"/>

* **Package com.esame.database**
<img src="https://rp8yxa.db.files.1drv.com/y4mnruecugcm6RTLVwPqrmBuSukU7a0KmlxIGyiSebWmlQ4_1Q8oZeoV_SpPWaadXkkkppIwjNLzDMY6hOzRtJy6KD6wPz84LPtj7rSOVig7U15BYreqCTpmOSV6g_FbZiz0F6uwUC8M8enVCMDIPViwtVwn00DrX8VPSWc6Mx9Dv7lGnbeEwiAhzXimALGPZyP?width=821&height=396&cropmode=none" width="400"/>

* **Package com.esame.model**
<img src="https://aan8ma.db.files.1drv.com/y4mst12CQranENvifwfmvWa4ncDGn63NjpFMfOqQSHoaHnAzgMRSasV5wmJ4TMG2VXTde6XGPzg9skXnnuTVc3mXzUHqlWHeRhzQfVN1ToyebtJOcreboYFDytJVeJ4zTW8BL5OKSppuW1FurY-bZgF3i5_-GIwMiZbSmvduMyjtVqOXtSxkOSyCkA1yMf-exX7?width=1827&height=937&cropmode=none" width="1000"/>

* **Package com.esame.service**
<img src="https://rp9orq.db.files.1drv.com/y4mlQ7vBw8uVCWRk2IapGMC2I1dLY5ZgVqw0eYcWPdgwqpf0gKrmeTwCrDmuypZcIcbXjfMJKp8KH-4dPML_xgf0a2QsEwEJnOOF9YPmEMiJGEd8H8N4eOdlDLTWh4qUT-1HEAN_0ABvOJ9ArAPxuc3Irsi4rAPvJheE6c0-8j9GhT4OZCuMv_Na6EjVkECuN7k?width=1993&height=881&cropmode=none" width="1000"/>

* **Package com.esame.exception**
<img src="https://aaoygq.db.files.1drv.com/y4mAsvRthPQ5MgTsGJ-XYvf58M80wunSVoPNPTyWqQm3rFPVaLrLDA8qCRz7T_h2Lj2VTKpqdQLGf3l6N3MkUCC7v2OfHrzzPsYcD5TFWc418nrdTQEvc52pkM6qdSz4Wy0Niyi7gSm7VjoNc9DSG1exJaxdEl9QzCWZJdcRQAJ_Far-r_ygLYSgAt2pJ9RqY2D?width=1605&height=897&cropmode=none" width="1000"/>

* **Package com.esame.util.filter**
<img src="https://aannjg.db.files.1drv.com/y4mRe4nkI2sZHTfzoUOhl5VQzbQCNTQzkehgM3jzCfuIXKwbyFJ3_HQkmp6OSAGOiDQWWsHvz6mvT0AkAKCihxnMrimR3yjGKMlxYQAsK9XKRdGRKHGg5PQ3N5ry3w_jehwrbFi-hjckttqFHt_zkUs9bx0Iw2_LKSQZY2D4TEP9lF_fKH8pJe-c3RfCUuHUJQm?width=2191&height=927&cropmode=none" width="1000"/>

* **Package com.esame.util.statistics**
<img src="https://aaphuw.db.files.1drv.com/y4mRjse4Z7iBHx3XFvqaEHepcsuecehoiYqbgD1_J7f11scOMKPk7cryrGDn6I7ZhdkOnTjW-BKSUyPMl3ejWLUoqa8pQc8kkF-TH6KgFj5MfZg8bfZfF48Y-QpxxT-g-iG-fLFHfQ_Sq20CAiQN20ANwoSfxj71-PGxtm3n2osNiywIStxMPmStpQfcOyO-gyT?width=1727&height=837&cropmode=none" width="1000"/>


### Chiamate

* **Chiamata GET /metadata**
ControllerClass esegue una chiamata tramite il metodo `getArrayMetadata`, il quale inizializza un ArrayList di metadata e lo restituisce. ControllerClass trasforma quest ultimo in Json e lo ritorna al client.
<img src="https://rpqn0a.db.files.1drv.com/y4mkdQHH_Pa33tVJuMamcWrvjIjrXnrRZVW0xQ9mGEJyXwnD_3q-sIDR5AOVWyu1jvLzTLHZFAq8x3hJWBUUgxCQHVI6KiMOMFZvJEve0KDmmGp8tJx4yat-iDa1-l0RgrCK1NvHRJFpHsNA76rTKROeFBnReGhmgTeOrE6hruyr1At0_sXHdUf1KDT-940q3Ue?width=1950&height=407&cropmode=none" width="1000"/>

* **Chiamata GET /data**
ControllerClass esegue una chiamata tramite il metodo `getRecords`, il quale restituisce l'intero ArrayList di Record. ControllerClass trasforma quest ultimo in Json e lo ritorna al client.
<img src="https://rp8dug.db.files.1drv.com/y4mbH1IgQ_orEo7XdkN503RzT0b-r4DAnOLFlmZzzoZQpqnQMIiLre9d4b_WW-dfBJEKDrm0tY0LovdwqtAVDP7pVt8JOeKEZ2Z-kDsZAfsaecyxaOuCDX1paW5P5rAxP19vTI7wIbkfNm9N2WaqPhquJvBY2Hxvc9kzDk4l1Y3_KyMel0t1yIFzoi2wpHxVcHF?width=1894&height=391&cropmode=none" width="1000"/>

* **Chiamata POST /data**
ControllerClass esegue una chiamata tramite `jsonParserColumn` alla classe JsonParser, che insieme a `jsonParserOperator` effetueranno il parsing del body ricevuto in modo ciclico. Estrapolate le informazioni relative al filtraggio richiesto, verranno utilizzate da `instanceFilter` per istanziare nuovi oggetti filtro prendedoli della classi contenute nel package com.esame.util.filter. A questo punto tramite `runFilter` si potrà eseguire il filtraggio e restituire a ControllerClass l'Arraylist di Record filtrato da consegnare al Client in formato Json. 
<img src="https://aaoddw.db.files.1drv.com/y4mwkin2INnRgju0sxyVK0HJtkbNBEyC8jhb4p7mCstWce3Nn1WqeWR2I73_GYlyMYxx2Ke5jsURAdKonsHU6TR4iIvoIB2tPFIhQTFDhdikZcTkT6HYKx47yAsDzPujeiUFo-LbRxwpyNlQ9zNz3H7iqM9MfTEZTNRt6fcRPzCABahPQzkr0gcv8RQd4f7p-jA?width=1920&height=644&cropmode=none" width="1000"/>

* **Chiamata GET /stats?field="nome"**
L'arrayList di Record sul quale fare il calcolo delle statisctiche viene ottenuto nel modo spiegato nella richiesta *GET /data*.
Viene passato il nome del campo su cui si desidera effettuare la statistica a `instanceStatsCalculator`, il quale instanzia l'oggetto `StasCalculator` corretto dalle classi contenute nel package com.esame.util.statistics.
Quest'ultimo tramite il metodo `run` eseguirà il calocolo statistico che verrà incapsulato come oggetto stats, e restituito in formato Json al client
<img src="https://rpq8cg.db.files.1drv.com/y4mqN_XoixpKzN2XSjgqCpET4UC0nZyeijxp7cN1ECPoJZJcNMsKXh1_uanj2Q_oTSN_cSiY0KmlYp51ltFvw5et3g7Bo1sQOKHagwd7odz0amXwz9_ghYZGr7xYyViC1CnqEdkOetP4RZHAntaWdpG5BfpIYBksOrWFsHE7W-ner0NZ8cyUWz2Vj6Ffc79Ajza?width=1902&height=587&cropmode=none" width="1000"/>

* **Chiamata POST /stats?field="nome"**
L'arrayList di Record sul quale calcolare le statisctiche viene ottenuto nel modo spiegato nella richiesta *POST /data*.
Il calcolo statistico viene eseguito come spiegato nella richiesta *GET /stats?field="nome"*
<img src="https://rp85ow.db.files.1drv.com/y4m7xIPFBfoBq4XEhcwG1jFk31GgrW9wpRnrzkVkDOPuN-gp-HQASwJwpkceTeAInI6UbkIuKP7nlKddclBxIQI0cpg8Tqp_GlGvxwoIe8UP31IsU4RrjpHVcDxRXNoYESYcJaAWHeL6ijlJEwiSpKDmhMpeZVmzevg4TkTCQKB7g4e2iE_a7S2JTHEwhSimaWt?width=1922&height=860&cropmode=none" width="1000"/>


## Softwere utilizzati

* [Eclipse](https://www.eclipse.org/) - ambiente di sviluppo integrato
* [Spring Boot](https://spring.io/projects/spring-boot) - framework per  sviluppo applicazioni Java
* [Maven](https://maven.apache.org/) - strumento di gestione di progetti

## Autori

* **Marco Sebastianelli** - [GitHub](https://github.com/marcoseba)
* **Cristian Vitali** - [GitHub](https://github.com/CriVitali)
