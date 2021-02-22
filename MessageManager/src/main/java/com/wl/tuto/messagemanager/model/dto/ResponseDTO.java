package com.wl.tuto.messagemanager.model.dto;

import java.util.ArrayList;

public class ResponseDTO {
    private String message_ID;
    private String status;
    private ArrayList<String> aUis;

    public String getMessage_ID() {
        return message_ID;
    }

    public void setMessage_ID(String message_ID) {
        this.message_ID = message_ID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<String> getaUis() {
        return aUis;
    }

    public void setaUis(ArrayList<String> aUis) {
        this.aUis = aUis;
    }
}
