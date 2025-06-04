package com.example.BroadcastSystem.controller;

import com.example.BroadcastSystem.model.BroadcastMessage;
import com.example.BroadcastSystem.repo.BroadcastMessageRepo;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
public class BroadcastMessageController {

    @Autowired
    private BroadcastMessageRepo broadcastMessageRepo;

    @GetMapping("/getAllMessages")
    public ResponseEntity<List<BroadcastMessage>> getAllMessages(){

        try {
            List<BroadcastMessage> messageList = new ArrayList<>();
            broadcastMessageRepo.findAll().forEach(message -> messageList.add((BroadcastMessage) message));


            if (messageList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(messageList, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

   

    @GetMapping("/getMessageById/{id}")
    public ResponseEntity<BroadcastMessage> getMessageById(@PathVariable Long id){
        Optional<com.example.BroadcastSystem.model.BroadcastMessage> broadcastMessageData = broadcastMessageRepo.findById(id);

        if (broadcastMessageData.isPresent()){
            return new ResponseEntity<>(HttpStatus.OK);
        }
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/addMessage")
    public ResponseEntity<BroadcastMessage> addMessage(@RequestBody BroadcastMessage broadcastMessage){
        BroadcastMessage savedMessage =  broadcastMessageRepo.save(broadcastMessage);
        return new ResponseEntity<>(savedMessage, HttpStatus.OK);
    }


    @DeleteMapping("/deleteMessageById/{id}")
    public ResponseEntity<HttpStatus> deleteMessageById(@PathVariable Long id){
        broadcastMessageRepo.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }



    @RestControllerAdvice
    public class GlobalExceptionHandler {

        @ExceptionHandler(IllegalArgumentException.class)
        public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

}
