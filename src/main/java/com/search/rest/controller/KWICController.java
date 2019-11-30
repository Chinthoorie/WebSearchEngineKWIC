package com.search.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.search.rest.KWIC.KwicIndex;
import com.search.rest.database.DescriptionDAO;
import com.search.rest.database.DescriptionDAOImpl;
import com.search.rest.database.URLDAOImpl;
import com.search.rest.model.Description;
import com.search.rest.model.URL;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(path = "/kwic")
public class KWICController
{

    @GetMapping(path="/alphabetizer", produces = "application/json")
    public List<ArrayList<String>> getAlphabetizeLines(@RequestParam(value="lines", required = false) String lines)
    {
        KwicIndex kwicIndex = new KwicIndex();

        return kwicIndex.IndexLines(lines);
    }


    @GetMapping(path="/search", produces = "application/json")
    public List<URL> getSearchResults(@RequestParam(value="line", required = false) String line, @RequestParam(value="keyword", required = false) String keyword)
    {
        URLDAOImpl urlDAO = new URLDAOImpl();
        ArrayList<URL> results = urlDAO.finalSearchResult(line, keyword);
//        List<String> urlResults = results.stream().map(URL::getUrl).collect(Collectors.toList());

        return results;
    }

    @GetMapping(path="/autofill", produces = "application/json")
    public List<String> getAutofillWords(@RequestParam(value="word", required = false) String word)
    {
        DescriptionDAOImpl descDAO = new DescriptionDAOImpl();
        ArrayList<Description> results = descDAO.getWords(word);
        List<String> wordResults = results.stream().map(Description::getWord).collect(Collectors.toList());

        return wordResults;
    }

}

