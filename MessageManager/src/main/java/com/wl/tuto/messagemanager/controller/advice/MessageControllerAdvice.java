package com.wl.tuto.messagemanager.controller.advice;

import com.wl.tuto.messagemanager.exception.MessageNotFoundException;
import com.wl.tuto.messagemanager.model.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;


@RestControllerAdvice
public class MessageControllerAdvice {

    public static final String MESSAGE_NOT_FOUND = "MESSAGE_NOT_FOUND";
    public static final String MESSAGE_NOT_VALID = "MESSAGE_NOT_VALID";

    @ExceptionHandler({MessageNotFoundException.class})
    private ResponseEntity<ErrorDTO> handleMessageNotFoundException(MessageNotFoundException e){
        List<String> details = new ArrayList<>();
        details.add(e.getMessage());
        ErrorDTO er = new ErrorDTO(
                ErrorDTO.getDate(),
                HttpStatus.NOT_FOUND.value(),
                MESSAGE_NOT_FOUND,
                details);
        return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    private ResponseEntity<ErrorDTO> handleHttpMessageNotReadableException(HttpMessageNotReadableException e){
        List<String> details = new ArrayList<>();
        details.add(e.getMessage());
        ErrorDTO er = new ErrorDTO(
                ErrorDTO.getDate(),
                HttpStatus.BAD_REQUEST.value(),
                MESSAGE_NOT_VALID,
                details);

        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
     private ResponseEntity<ErrorDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        List<String> details = new ArrayList<>();
        for (ObjectError error : e.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }
         ErrorDTO er = new ErrorDTO(
                 ErrorDTO.getDate(),
                 HttpStatus.BAD_REQUEST.value(),
                 MESSAGE_NOT_VALID,
                 details);

         return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
     }
    }
