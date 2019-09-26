package com.search.rest.controller;

import java.util.ArrayList;
import java.util.List;

import com.search.rest.KWIC.KwicIndex;
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

}

