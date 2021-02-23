package com.wl.tuto.messagemanager.exception;

public class MessageNotFoundException extends Exception {
    public MessageNotFoundException(){
        super("Id not found");
    }
}
