package com.wl.tuto.messagemanager.model.dto;

import java.util.ArrayList;

public class MessageDTO {
    private String message_id;
    private String message_type;
    private String EO_ID;
    private int UI_Type;
    private ArrayList<String> aUis;

    public String getMessage_id() {
        return message_id;
    }

    public void setMessage_id(String message_id) {
        this.message_id = message_id;
    }

    public String getMessage_type() {
        return message_type;
    }

    public void setMessage_type(String message_type) {
        this.message_type = message_type;
    }

    public String getEO_ID() {
        return EO_ID;
    }

    public void setEO_ID(String EO_ID) {
        this.EO_ID = EO_ID;
    }

    public int getUI_Type() {
        return UI_Type;
    }

    public void setUI_Type(int UI_Type) {
        this.UI_Type = UI_Type;
    }

    public ArrayList<String> getaUis() {
        return aUis;
    }

    public void setaUis(ArrayList<String> aUis) {
        this.aUis = aUis;
    }
}
