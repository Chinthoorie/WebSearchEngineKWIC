package com.search.rest.model;

public class URL {

    private int id;
    private String url;
    private String desc;
    private String heading;

    public URL()
    {

    }

    public URL(String url, String desc, String heading) {
        this.url = url;
        this.desc = desc;
        this.heading = heading;
    }

    public URL(int id, String url) {
        super();
        this.id = id;
        this.url = url;
    }

    public URL(String url) {
        super();
        this.id = id;
        this.url = url;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    @Override
    public String toString() {
        return "URL [id=" + id + ", url=" + url + "]";
    }
}
