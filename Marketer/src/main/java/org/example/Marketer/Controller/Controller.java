package org.example.Marketer.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.Marketer.Domain.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import org.example.Marketer.Service.Producer.Producer;
@Slf4j
@RestController // Establish RestController
@RequestMapping("/client") // HTTP Controller Endpoint
public class Controller 
{
    @Autowired
    private final Producer producer;
    public Controller(Producer producer)
    {
        this.producer=producer;
    }
    @PostMapping("/publishOffer") // HTTPPOST Endpoint
    public ResponseEntity<String> publishOffer(@RequestBody Offer offer) throws JsonProcessingException {
        offer.setOperationType("post");
        producer.sendMessage(offer); // Send message to kafka
        log.info("Publish request received"); // Print in Log(Terminal)
        return ResponseEntity.ok("An offer is added"); // Postman (HTTP) response
    }


    @DeleteMapping("/deleteOffer") // HTTPDelete Endpoint
    public ResponseEntity<String> deleteOffer(@RequestBody Offer offer)throws JsonProcessingException {
        offer.setOperationType("delete");
        producer.sendMessage(offer); // Send message to kafka
        log.info("delete request is received"); // Print in Log(Terminal)
        return ResponseEntity.ok("Offer is deleted "); // Postman (HTTP) Delete
    }


    @PutMapping("/updateOffer") // HTTPUpdate Endpoint
    public ResponseEntity<String> updateOffer(@RequestBody Offer offer)throws JsonProcessingException{
        offer.setOperationType("update");
        producer.sendMessage(offer); // Send message to kafka
        log.info("update request is received"); // Print in Log(Terminal)
        return ResponseEntity.ok("An offer is updated"); // Postman (HTTP) Update
    }



}
