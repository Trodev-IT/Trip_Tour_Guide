package com.trodev.tourtripguide.models;

public class ModelClass {

    public String name, shortbio ,historyhead, historybio, ticket, ticketbio, wheretogo, img;

    public ModelClass() {
    }

    public ModelClass(String name, String shortbio, String historyhead, String historybio, String ticket, String ticketbio, String wheretogo, String img) {
        this.name = name;
        this.shortbio = shortbio;
        this.historyhead = historyhead;
        this.historybio = historybio;
        this.ticket = ticket;
        this.ticketbio = ticketbio;
        this.wheretogo = wheretogo;
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

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getTicketbio() {
        return ticketbio;
    }

    public void setTicketbio(String ticketbio) {
        this.ticketbio = ticketbio;
    }

    public String getWheretogo() {
        return wheretogo;
    }

    public void setWheretogo(String wheretogo) {
        this.wheretogo = wheretogo;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
