package com.trodev.tourtripguide;

public class ModelRecords {

    //variables
    String id, name, bio, phone, ticket, date, addedTime, updateTime; //image,

    public ModelRecords(String id, String name, String bio, String phone, String ticket, String date, String addedTime, String updateTime) {
        this.id = id;
        this.name = name;
        this.bio = bio;
        this.phone = phone;
        this.ticket = ticket;
        this.date = date;
        this.addedTime = addedTime;
        this.updateTime = updateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddedTime() {
        return addedTime;
    }

    public void setAddedTime(String addedTime) {
        this.addedTime = addedTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
