package com.wl.tuto.messagemanager.service;

import com.wl.tuto.messagemanager.mapper.MessageMapper;
import com.wl.tuto.messagemanager.model.Message;
import com.wl.tuto.messagemanager.model.dto.MessageDTO;
import com.wl.tuto.messagemanager.model.dto.ResponseDTO;
import com.wl.tuto.messagemanager.repository.MessageRepository;

import java.util.Optional;

public class MessageService {
    private MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void save(Message msg){
        this.messageRepository.save(msg);
    }

    public Message toMessage(MessageDTO msgDTO){
        MessageMapper msgMapp = new MessageMapper();
        return msgMapp.messageDTOToMessage(msgDTO);
    }

    public ResponseDTO toResponseDTO(Message msg){
        MessageMapper msgMapp = new MessageMapper();
        return msgMapp.messageToResponseDTO(msg);
    }

    public Optional<Message> getMessageById(String id){
       return this.messageRepository.findById(id);
    }

}
