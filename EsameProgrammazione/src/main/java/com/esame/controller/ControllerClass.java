package com.esame.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.esame.database.DatabaseClass;
import com.esame.model.Metadata;
import com.esame.model.Record;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;


@RestController
public class ControllerClass {

	@RequestMapping(value = "metadata", method=RequestMethod.GET)
	public ArrayList<Metadata> getMetadata(){
		
		return DatabaseClass.getArrayMetadata();
	}
	
	@RequestMapping(value = "data", method=RequestMethod.GET)
	public ArrayList<Record> getDataWithGet() throws JsonParseException, JsonMappingException, IOException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, SecurityException, ParseException{
		
		return DatabaseClass.getRecords();
	}
}
