package com.search.rest.database;

import com.search.rest.model.URL;

import java.util.ArrayList;

public interface URLDAO {

    public ArrayList<URL> finalSearchResult(String search, String keyword);
}
