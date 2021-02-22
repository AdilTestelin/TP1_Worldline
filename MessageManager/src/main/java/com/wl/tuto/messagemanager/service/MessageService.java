package com.wl.tuto.messagemanager.service;

import com.wl.tuto.messagemanager.mapper.MessageMapper;
import com.wl.tuto.messagemanager.model.Message;
import com.wl.tuto.messagemanager.model.dto.MessageDTO;
import com.wl.tuto.messagemanager.model.dto.ResponseDTO;
import com.wl.tuto.messagemanager.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


@Service
public class MessageService {
    private MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message save(Message msg){
        return this.messageRepository.save(msg);
    }

    public Message toMessage(MessageDTO msgDTO){
        MessageMapper msgMapp = new MessageMapper();
        return msgMapp.messageDTOToMessage(msgDTO);
    }

    public ResponseDTO toResponseDTO(Message msg){
        MessageMapper msgMapp = new MessageMapper();
        return msgMapp.messageToResponseDTO(msg);
    }

    public Message getMessageById(String id){
       return this.messageRepository.findById(id).orElseThrow(() -> new RuntimeException("Pas de chance"));
    }

    public MessageDTO createMessageDTO(String message_id, String message_type, String EO_ID, int UI_Type, ArrayList<String> aUis){
        MessageDTO msgDTO = new MessageDTO();
        msgDTO.setMessage_id(message_id);
        msgDTO.setMessage_type(message_type);
        msgDTO.setEO_ID(EO_ID);
        msgDTO.setUI_Type(UI_Type);
        msgDTO.setaUis(aUis);

        return msgDTO;
    }

}
