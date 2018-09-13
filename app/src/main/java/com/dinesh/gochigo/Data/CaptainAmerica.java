package com.dinesh.gochigo.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CaptainAmerica {

    @SerializedName("contacts")
    @Expose
    private List<CaptainAmericaData> contacts = null;

    public List<CaptainAmericaData> getContacts() {
        return contacts;
    }

    public void setContacts(List<CaptainAmericaData> contacts) {
        this.contacts = contacts;
    }
}