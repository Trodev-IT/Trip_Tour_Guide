package com.trodev.tourtripguide;

public class ModelClass {

    public String name, shortbio ,historyhead, historybio , img;


    public ModelClass() {
    }


    public ModelClass(String name, String shortbio, String historyhead, String historybio, String img) {
        this.name = name;
        this.shortbio = shortbio;
        this.historyhead = historyhead;
        this.historybio = historybio;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortbio() {
        return shortbio;
    }

    public void setShortbio(String shortbio) {
        this.shortbio = shortbio;
    }

    public String getHistoryhead() {
        return historyhead;
    }

    public void setHistoryhead(String historyhead) {
        this.historyhead = historyhead;
    }

    public String getHistorybio() {
        return historybio;
    }

    public void setHistorybio(String historybio) {
        this.historybio = historybio;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
