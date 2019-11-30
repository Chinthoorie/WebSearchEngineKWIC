package com.search.rest.model;

public class Description {

    private int id;
    private String shiftedLine;
    private String word;

    public Description()
    {

    }

    public Description(int id, String shiftedLine) {
        super();
        this.id = id;
        this.shiftedLine = shiftedLine;
    }

    public Description(int id, String shiftedLine, String word) {
        super();
        this.id = id;
        this.shiftedLine = shiftedLine;
        this.word = word;
    }

    public Description(String word) {
        super();
        this.word = word;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getshiftedLine() {
        return shiftedLine;
    }
    public void setshiftedLine(String shiftedLine) {
        this.shiftedLine = shiftedLine;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return "Description [id=" + id + ", shiftedLine=" + shiftedLine + "]";
    }
}
