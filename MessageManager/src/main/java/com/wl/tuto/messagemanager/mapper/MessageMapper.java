package com.wl.tuto.messagemanager.mapper;

import com.wl.tuto.messagemanager.model.Message;
import com.wl.tuto.messagemanager.model.dto.MessageDTO;
import com.wl.tuto.messagemanager.model.dto.ResponseDTO;
import lombok.experimental.UtilityClass;


@UtilityClass
public class MessageMapper {

    public Message messageDTOToMessage(MessageDTO msgDTO){
        return Message.builder()
                .messageId(msgDTO.getMessageID())
                .messageType(msgDTO.getMessageType())
                .aUis(msgDTO.getAUIs())
                .eoId(msgDTO.getEoID())
                .status("IN_PROGRESS")
                .uiType(msgDTO.getUiType())
                .build();
    }

    public ResponseDTO messageToResponseDTO(Message msg){
        return ResponseDTO.builder()
                .aUis(msg.getAUis())
                .messageID(msg.getMessageId())
                .status(msg.getStatus())
                .build();
    }
}
