package org.example.Customer.Controller;
import org.example.Customer.Domain.Offer;
import org.example.Customer.Service.*;

import lombok.extern.slf4j.Slf4j;
import org.example.Customer.entity.OffersDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/client")


public class Controller {
    private final CostumerService costumerService;
    @Autowired
    public Controller(CostumerService costumerService){
        this.costumerService=costumerService;
    }
    @GetMapping("/getAllOffers")
    public ResponseEntity<List<OffersDB>> getAllOffers(){
        log.info("get all offers request received");
        return  new ResponseEntity<>(costumerService.getAllOffers(), HttpStatus.OK);
    }

    @GetMapping("/retrieveOffer/{id}")
    public OffersDB retrieveOffer(@PathVariable("id") long id){
        log.info("request of retrieving an offer is received");
        return costumerService.retrieveOffer(id);
    }



}
