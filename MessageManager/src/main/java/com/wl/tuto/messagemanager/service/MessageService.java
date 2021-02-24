package com.wl.tuto.messagemanager.service;

import com.wl.tuto.messagemanager.exception.MessageNotFoundException;
import com.wl.tuto.messagemanager.mapper.MessageMapper;
import com.wl.tuto.messagemanager.model.Message;
import com.wl.tuto.messagemanager.model.dto.MessageDTO;
import com.wl.tuto.messagemanager.model.dto.ResponseDTO;
import com.wl.tuto.messagemanager.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;


    public void save(MessageDTO msgDTO){
        if(msgDTO != null){
            Message msg = MessageMapper.messageDTOToMessage(msgDTO);
            this.messageRepository.save(msg);
        }
    }

    public ResponseDTO getMessageById(String id) throws MessageNotFoundException {
       Optional<Message> msg = this.messageRepository.findByMessageId(id);
       if(msg.isPresent()){
           return MessageMapper.messageToResponseDTO(msg.get());
       } else {
           throw new MessageNotFoundException(id);
       }
    }

}
