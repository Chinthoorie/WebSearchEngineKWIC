package com.search.rest.KWIC;
import java.util.ArrayList;

public class Alphabetizer {
    public ArrayList<String> order(ArrayList<String> lines) {

        for ( int i = 0; i < lines.size(); i++) {
            String min = lines.get(i);
            int minIndex = i;
            for ( int j = i+1; j < lines.size(); j++) {
                if ( min.toLowerCase().trim().compareTo( lines.get(j).toLowerCase().trim() ) > 0) {
                    min = lines.get(j);
                    minIndex = j;
                }
            }
            if ( minIndex != i ) {
                String temp = lines.get(i);
                lines.set(i,min);
                lines.set(minIndex,temp);
            }
        }

        return lines;
    }
}
