package com.search.rest.response;

import java.io.Serializable;
import java.util.ArrayList;

public class Output implements Serializable {
    ArrayList<String> csArray;
    ArrayList<String> sortedArray;
    ArrayList<String> outputArray;

    public Output(ArrayList<String> csArray, ArrayList<String> sortedArray, ArrayList<String> outputArray) {
        this.csArray = csArray;
        this.sortedArray = sortedArray;
        this.outputArray = outputArray;
    }

    @Override
    public String toString() {
        return "{ csArray:" + csArray + ", sortedArray:" + sortedArray + ", outputArray:" + outputArray + "}";
    }
}
