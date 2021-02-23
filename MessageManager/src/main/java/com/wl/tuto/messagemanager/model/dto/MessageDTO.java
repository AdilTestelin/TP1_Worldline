package com.wl.tuto.messagemanager.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class MessageDTO {

    @JsonProperty("Message_ID")
    @NotEmpty
    @Pattern(regexp = "[a-zA-Z]+[0-9]*")
    private String messageID;

    @JsonProperty("Message_Type")
    @NotEmpty
    @Pattern(regexp = "[a-zA-Z]+[0-9]*")
    private String messageType;

    @JsonProperty("EO_ID")
    @NotEmpty
    @Pattern(regexp = "[a-zA-Z]+[0-9]*")
    private String eoID;

    @JsonProperty("UI_Type")
    @NotNull
    private int uiType;

    @JsonProperty("aUIs")
    @NotEmpty
    private List<String> aUIs;

}
