package com.esame.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esame.database.DatabaseClass;
import com.esame.model.Metadata;
import com.esame.model.Record;
import com.esame.service.JsonParser;
import com.esame.service.StatsService;
import com.esame.util.other.StatsCalculator;
import com.esame.model.Stats;
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
	
	@RequestMapping(value = "data", method=RequestMethod.POST)
	public ArrayList<Record> getDataWithPost(@RequestBody Object filter) throws JsonParseException, JsonMappingException, IOException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, SecurityException, ParseException{
		
		return JsonParser.JsonParserColonna(filter);
	}
	
	@RequestMapping(value = "stats", method=RequestMethod.POST)
	public Stats getStats(@RequestParam(value = "field") String column,
									  @RequestBody Object filter) throws JsonParseException, JsonMappingException, IOException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, SecurityException{
		
		
		ArrayList<Record> filteredArray = JsonParser.JsonParserColonna(filter);
		StatsCalculator sc = StatsService.instanceStatsCalculator(column, filteredArray);
		return sc.run();
	}
}
