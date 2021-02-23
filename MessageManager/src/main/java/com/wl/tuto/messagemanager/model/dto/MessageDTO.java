package com.wl.tuto.messagemanager.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class MessageDTO {
    @JsonProperty("Message_ID")
    private String messageID;
    @JsonProperty("Message_Type")
    private String messageType;
    @JsonProperty("EO_ID")
    private String eoID;
    @JsonProperty("UI_Type")
    private int uiType;
    @JsonProperty("aUIs")
    private List<String> aUIs;


}
