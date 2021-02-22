package com.wl.tuto.messagemanager.model;

import com.datastax.driver.core.DataType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.ArrayList;


@Table
public class Message {

    @PrimaryKey
    private String Message_ID;

    @Column
    private String status;

    @Column
    private String message_type;

    @Column
    private String EO_ID;

    @Column
    private Integer UI_Type;

    @Column
    @CassandraType(type= DataType.Name.LIST, typeArguments= DataType.Name.VARCHAR)
    private ArrayList<String> aUis;

    public Message(String id, String status, String message_type, String EO_ID, int UI_Type, ArrayList<String> aUis) {
        this.Message_ID = id;
        this.status = "IN_PROGRESS";
        this.message_type = message_type;
        this.EO_ID = EO_ID;
        this.UI_Type = UI_Type;
        this.aUis = aUis;
    }

    public Message(){};

    public String getId() {
        return Message_ID;
    }

    public void setMessage_ID(String message_ID) {
        this.Message_ID = message_ID;
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

    public Integer getUI_Type() {
        return UI_Type;
    }

    public void setUI_Type(Integer UI_Type) {
        this.UI_Type = UI_Type;
    }

    public ArrayList<String> getaUis() {
        return aUis;
    }

    public void setaUis(ArrayList<String> aUis) {
        this.aUis = aUis;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(){
        this.status = "IN_PROGRESS";
    }

    public String toString(){
        return this.getId() + this.getMessage_type() + this.getEO_ID() +  this.getaUis() + this.getUI_Type();
    }
}
