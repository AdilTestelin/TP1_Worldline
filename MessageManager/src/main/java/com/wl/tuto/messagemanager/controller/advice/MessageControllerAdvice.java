package com.wl.tuto.messagemanager.controller.advice;

import com.wl.tuto.messagemanager.exception.MessageNotFoundException;
import com.wl.tuto.messagemanager.model.dto.ErrorDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@RestControllerAdvice
public class MessageControllerAdvice {

    @ExceptionHandler({MessageNotFoundException.class})
    @ResponseBody
    private ResponseEntity<Object> handleMessageNotFoundException(MessageNotFoundException e){
        ErrorDTO er = new ErrorDTO(
                "xxx",
                HttpStatus.NOT_FOUND.value(),
                e.getClass().getSimpleName(),
                e.getMessage());

        return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseBody
    private ResponseEntity<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException e){
        ErrorDTO er = new ErrorDTO(
                "xxx",
                HttpStatus.BAD_REQUEST.value(),
                e.getClass().getSimpleName(),
                e.getMessage());

        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
    }

    /** private static String dateFormatter(){
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");


    } **/

    @ExceptionHandler({MethodArgumentNotValidException.class})
     private ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
         ErrorDTO er = new ErrorDTO(
                 "xxx",
                 HttpStatus.BAD_REQUEST.value(),
                 e.getClass().getSimpleName(),
                 e.getMessage());

         return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
     }
    }
