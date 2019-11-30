package com.search.rest.KWIC;

import java.util.*;

public class CircularShift {
	
	
	public ArrayList<String> circular(ArrayList<String> input) {
		ArrayList<String> circular = new ArrayList<String>();
		for(int j=0;j<input.size();j++) {
			String trim = input.get(j).trim();
			circular.add(trim);
			String words[] = trim.split(" ");
			int length = words.length;
			String temp = trim;
			int k = circular.size()+length-1;
			for(int i=circular.size();i<k;i++) {
				String arr[] = temp.split(" ",2);
				circular.add(arr[1] + " " + arr[0]);
				temp = circular.get(circular.size() - 1);
			}
			
		}
		return (circular);
		
	}
	
	public void print(ArrayList<String> circular) {
		for(int i=0;i<circular.size();i++) {
			System.out.println(circular.get(i));
		}
	}
	
	public ArrayList<String> noiseRemove(ArrayList<String> circular) {
		HashSet<String> hs = new HashSet<String>();
		hs.add("of");
		hs.add("and");
		hs.add("the");
		hs.add("is");
		hs.add("a");
		hs.add("an");
		hs.add("are");
		hs.add("in");
		hs.add("on");
		hs.add("as");
		hs.add("or");
		hs.add("to");
		hs.add("was");
		hs.add("it");
		hs.add("from");
		hs.add("with");
		hs.add("thus");
		hs.add("can");
		hs.add("each");
		hs.add("before");
		hs.add("between");
		hs.add("within");
		hs.add("at");
		hs.add("be");
		hs.add("into");
		hs.add("has");
		hs.add("for");
		hs.add("such");
		hs.add("by");
		hs.add("means");
		hs.add("both");
		hs.add("any");
		hs.add("next");
		hs.add("one");
		hs.add("(");
		hs.add(")");
		hs.add("-");
		hs.add(".");
		hs.add("|");

		for(int i=0;i<circular.size();i++) {
			String s[] = circular.get(i).split(" ",2);
			if(hs.contains(s[0]))
				{
					circular.remove(i);
					i--;
				}
		}
		return(circular);
	}
	
	public void NewCircularShift(ArrayList<String> input){
		StringBuilder sb = new StringBuilder(); 
		ArrayList<String> listOfStrings = new ArrayList<>();
		
		for(String str: input){
			str = str.trim();
			List<String> words = Arrays.asList(str.split(" "));
			int wordCount = words.size();
			listOfStrings.add(str);
			for(int i=0; i<wordCount-1; i++){
				List<String> parts = Arrays.asList(str.split(" "));
				Collections.rotate(parts, parts.size()-1);
				String.join(" ", parts);
				sb.setLength(0);  

		        for (String ch : parts) { 
		            sb.append(ch);
		            sb.append(" ");
		        } 
		        // convert in string 
		        String string = sb.toString().trim();
				listOfStrings.add(string);
				str = string;
			}
		}
		print(listOfStrings);
	}
}
