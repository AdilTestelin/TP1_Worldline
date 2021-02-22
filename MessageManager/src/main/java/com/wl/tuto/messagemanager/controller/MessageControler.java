package com.wl.tuto.messagemanager.controller;

import com.wl.tuto.messagemanager.mapper.MessageMapper;
import com.wl.tuto.messagemanager.model.Message;
import com.wl.tuto.messagemanager.model.dto.MessageDTO;
import com.wl.tuto.messagemanager.model.dto.ResponseDTO;
import com.wl.tuto.messagemanager.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class MessageControler {

    private MessageService messageService;

    public MessageControler(MessageService messageService){
        this.messageService = messageService;
    }

    @PostMapping("v1/message")
    private ResponseEntity<Message> sendDTOMessage(@RequestBody MessageDTO msgDTO){
        Message msg = this.messageService.toMessage(msgDTO);
        return ResponseEntity.ok(this.messageService.save(msg));
    }

    @GetMapping("v1/message")
    private ResponseEntity<ResponseDTO> getMessage(@RequestParam String id){
        Message msgToSearch = this.messageService.getMessageById(id);
        ResponseDTO msgToDisplay = this.messageService.toResponseDTO(msgToSearch);
        return ResponseEntity.ok(msgToDisplay);
    }
}
