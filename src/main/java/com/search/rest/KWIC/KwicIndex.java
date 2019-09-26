package com.search.rest.KWIC;

import java.util.ArrayList;
import java.util.List;

public class KwicIndex {

    public List<ArrayList<String>> IndexLines(String lines) {
        getInput getIn = new getInput();

        //Objects
        CircularShift cs = new CircularShift();
        Alphabetizer alpha = new Alphabetizer();


        ArrayList<String> inputArray = getIn.InputLines(lines);
        ArrayList<String> csArray = new ArrayList<String>();
        ArrayList<String> noiseArray = new ArrayList<String>();
        ArrayList<String> outputArray = new ArrayList<String>();

        List<ArrayList<String>> outputList = new ArrayList();

        csArray = cs.circular(inputArray);
        ArrayList<String> csList = new ArrayList<>();
        outputList.add(csList);
        System.out.println("########################## CS array ############################################");
        for ( int i = 0; i < csArray.size(); i++ ) {
            csList.add(csArray.get(i));
            System.out.println(csArray.get(i));
        }

        noiseArray = cs.noiseRemove(csArray);
        ArrayList<String> noiseList = new ArrayList<>();
        outputList.add(noiseList);
        System.out.println("########################## noise remove array ############################################");
        for ( int i = 0; i < noiseArray.size(); i++ ) {
            noiseList.add(noiseArray.get(i));
            System.out.println(noiseArray.get(i));
        }

        outputArray = alpha.order(noiseArray);
        outputList.add(outputArray);
        System.out.println("########################## sorted array ############################################");
        for ( int i = 0; i < outputArray.size(); i++ ) {
            System.out.println(outputArray.get(i));
        }

        System.out.println("######################################################################");

        return outputList;
    }
}
