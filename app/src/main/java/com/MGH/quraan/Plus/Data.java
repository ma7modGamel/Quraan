package com.MGH.quraan.Plus;

public class Data
{
   private String link;
   private String name;
   private String linkPdf;

    public Data(String name,String link, String linkPdf) {
        this.link = link;
        this.name = name;
        this.linkPdf = linkPdf;


    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLinkPdf() {
        return linkPdf;
    }

    public void setLinkPdf(String linkPdf) {
        this.linkPdf = linkPdf;
    }
}