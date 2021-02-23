package com.wl.tuto.messagemanager.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.http.HttpStatus;

import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;

@AllArgsConstructor
public class ErrorDTO {

    @JsonProperty("date")
    private String timestamp;
    @JsonProperty("status")
    private int httpStatus;
    @JsonProperty("error_description")
    private String throwable;
    @JsonProperty("errors")
    private String message;

}
