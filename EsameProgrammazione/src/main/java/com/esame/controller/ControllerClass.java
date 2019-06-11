package com.esame.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.esame.database.DatabaseClass;
import com.esame.model.Metadata;


@RestController
public class ControllerClass {

	@RequestMapping(value = "metadata", method=RequestMethod.GET)
	public ArrayList<Metadata> getMetadata(){
		
		return DatabaseClass.getArrayMetadata();
	}
}
