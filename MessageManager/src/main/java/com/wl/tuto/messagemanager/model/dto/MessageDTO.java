package com.wl.tuto.messagemanager.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
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
    @NotBlank(message = "massageId cannot be blank.")
    @Pattern(regexp = "[a-zA-Z]+", message = "messageId don't suits the pattern")
    private String messageID;

    @JsonProperty("Message_Type")
    @NotBlank(message = "messageType cannot be blank")
    private String messageType;

    @JsonProperty("EO_ID")
    @NotBlank(message = "eoId cannot be blank")
    private String eoID;

    @JsonProperty("UI_Type")
    @NotNull(message = "uiType cannot be null")
    private Integer uiType;

    @JsonProperty("aUIs")
    @NotEmpty(message = "aUIs cannot be empty")
    private List<String> aUIs;

}
