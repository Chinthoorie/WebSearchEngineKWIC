package com.search.rest.database;

import com.search.rest.model.Description;

import java.util.ArrayList;

public interface DescriptionDAO {

    public ArrayList<Description> getWords(String search);
}
