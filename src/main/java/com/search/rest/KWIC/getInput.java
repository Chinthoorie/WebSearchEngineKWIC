package com.search.rest.KWIC;

import java.util.ArrayList;
import java.util.Arrays;


public class getInput {
	private String input;
	
	public ArrayList<String> InputLines(String inputFromUI){
		this.input = inputFromUI.trim().toLowerCase().replaceAll(" +", " ");;
		ArrayList<String> sentenceList = new ArrayList<String>();

		sentenceList.addAll(Arrays.asList(input.split(",")));
	    
		return sentenceList;
	}
	
}
