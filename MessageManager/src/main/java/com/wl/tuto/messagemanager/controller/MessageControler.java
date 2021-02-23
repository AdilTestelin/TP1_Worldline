package com.wl.tuto.messagemanager.controller;

import com.wl.tuto.messagemanager.model.dto.MessageDTO;
import com.wl.tuto.messagemanager.model.dto.ResponseDTO;
import com.wl.tuto.messagemanager.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/message")
@RequiredArgsConstructor
public class MessageControler {

    private final MessageService messageService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private void sendDTOMessage(@RequestBody MessageDTO msgDTO){
        this.messageService.save(msgDTO);
    }

    @GetMapping
    private ResponseEntity<ResponseDTO> getMessage(@RequestParam String id){
        ResponseDTO msgToDisplay = this.messageService.getMessageById(id);
        if(msgToDisplay != null){
            return ResponseEntity.ok(msgToDisplay);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
