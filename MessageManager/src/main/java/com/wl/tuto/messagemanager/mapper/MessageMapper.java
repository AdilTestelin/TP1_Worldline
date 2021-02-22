package com.wl.tuto.messagemanager.mapper;
import com.wl.tuto.messagemanager.model.*;
import com.wl.tuto.messagemanager.model.dto.*;


public class MessageMapper {

    public Message messageDTOToMessage(MessageDTO msgDTO){
        Message msg = new Message();
        msg.setMessage_ID(msgDTO.getMessage_id());
        msg.setMessage_type(Message.getStatus());
        msg.setaUis(msgDTO.getaUis());
        msg.setUI_Type(msgDTO.getUI_Type());
        msg.setEO_ID(msgDTO.getEO_ID());
        return msg;
    }

    public ResponseDTO messageToResponseDTO(Message msg){
        ResponseDTO respDTO = new ResponseDTO();
        respDTO.setMessage_ID(msg.getId());
        respDTO.setStatus(Message.getStatus());
        respDTO.setaUis(msg.getaUis());
        return respDTO;
    }
}
