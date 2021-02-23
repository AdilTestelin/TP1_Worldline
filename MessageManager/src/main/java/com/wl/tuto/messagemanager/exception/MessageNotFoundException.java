package com.wl.tuto.messagemanager.exception;

public class MessageNotFoundException extends Exception {
    public MessageNotFoundException(){
        super("Message id not found in database");
    }
}
