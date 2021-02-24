package com.wl.tuto.messagemanager.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;

@AllArgsConstructor
@Builder
public class ErrorDTO {

    @JsonProperty("date")
    private String timestamp;
    @JsonProperty("status")
    private int httpStatus;
    @JsonProperty("error_description")
    private String error_description;
    @JsonProperty("errors")
    private List<String> message;


    public static String getDate(){
        Instant now = Instant.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.from(ZoneOffset.UTC));
        return dateFormat.format(now);
    }
}
