package com.search.rest.database;


import com.search.rest.model.IndexEntry;

import java.util.ArrayList;

public interface IndexEntryDAO {

	
	public int insertIntoIndexEntry(IndexEntry indexEntry);
	
	public ArrayList<IndexEntry> getDataLinesFromRef(int refNum);
	
	public ArrayList<Integer> getRefrencekeys(String searchWords, String keyword);
	
	//TODO - Get main_Ref from 
}
