package com.jmm.brsap.countries.model;

import java.util.List;

public class RegionalBloc {
	private List<String> otherNames;
	private String acronym;
	private String name;
	private List<Object> otherAcronyms;

	public List<String> getOtherNames(){
		return otherNames;
	}

	public String getAcronym(){
		return acronym;
	}

	public String getName(){
		return name;
	}

	public List<Object> getOtherAcronyms(){
		return otherAcronyms;
	}
}