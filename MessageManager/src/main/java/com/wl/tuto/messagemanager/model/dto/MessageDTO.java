package com.wl.tuto.messagemanager.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class MessageDTO {

    @JsonProperty("Message_ID")
    @NotEmpty
    private String messageID;

    @JsonProperty("Message_Type")
    @NotEmpty
    private String messageType;

    @JsonProperty("EO_ID")
    @NotEmpty
    private String eoID;

    @JsonProperty("UI_Type")
    @NotNull
    private int uiType;

    @JsonProperty("aUIs")
    @NotEmpty
    private List<String> aUIs;

}
