package com.wl.tuto.messagemanager.exception;

public class MessageNotFoundException extends Exception {
    public MessageNotFoundException(String messageId){
        super("Messageid '" + messageId + "' not found in database");
    }
}
