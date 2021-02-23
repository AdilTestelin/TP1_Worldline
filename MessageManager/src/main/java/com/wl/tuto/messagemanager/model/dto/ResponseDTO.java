package com.wl.tuto.messagemanager.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {
    @JsonProperty("Message_ID")
    private String messageID;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("aUIs")
    private List<String> aUis;

}
