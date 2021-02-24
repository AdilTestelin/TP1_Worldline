package com.wl.tuto.messagemanager.controller;

import com.wl.tuto.messagemanager.exception.MessageNotFoundException;
import com.wl.tuto.messagemanager.model.dto.MessageDTO;
import com.wl.tuto.messagemanager.model.dto.ResponseDTO;
import com.wl.tuto.messagemanager.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/v1/message")
@RequiredArgsConstructor
public class MessageControler {

    private final MessageService messageService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private void sendDTOMessage(@Valid @RequestBody MessageDTO msgDTO){
        this.messageService.save(msgDTO);
    }

    @GetMapping
    private ResponseEntity<ResponseDTO> getMessage(@RequestParam String id) throws MessageNotFoundException { // Faire un trycatch
            try {
                ResponseDTO msgToDisplay = this.messageService.getMessageById(id);
                return ResponseEntity.ok(msgToDisplay);
            } catch (MessageNotFoundException e) {
                throw new MessageNotFoundException(id);
            }
    }
}
