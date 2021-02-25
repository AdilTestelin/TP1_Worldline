package com.wl.tuto.messagemanager.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class MessageDTO {

    @JsonProperty("Message_ID")
    @NotBlank(message = "messageId cannot be blank.")
    @Pattern(regexp = "\\w+", message = "messageId don't suits the pattern")
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
