package org.example.Customer.Service.Consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.example.Customer.Domain.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.example.Customer.Service.CostumerService;
@Slf4j
@Component
public class Consumer {
    private static final String offerTopic="${topic.name}";
    private final CostumerService customerService;
    private final ObjectMapper objectMapper;
    @Autowired
    public Consumer(CostumerService customerService,ObjectMapper objectMapper){
        this.customerService= customerService;
        this.objectMapper=objectMapper;
    }
    @KafkaListener(topics = offerTopic)
    public void ConsumeMessage(String message)throws JsonProcessingException{
        log.info("message consumed{}",message);
        Offer offer = objectMapper.readValue(message,Offer.class);
        if(offer.getOperationType().equals("post")){
            customerService.persistOffer(offer);
            log.info("published offer is received from kafka{}", offer.toString());}

       else if(offer.getOperationType().equals("update")){
            customerService.updateOffer(offer);
            log.info("updated offer is received from kafka{}", offer.toString());
        }

        else if (offer.getOperationType().equals("delete")){
            customerService.deleteOffer(offer.getId());
            log.info("Deleted offer is received from kafka{}", offer.toString());
        }
    }

}
