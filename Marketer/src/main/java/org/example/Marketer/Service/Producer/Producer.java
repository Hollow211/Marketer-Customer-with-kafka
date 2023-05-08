package org.example.Marketer.Service.Producer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.example.Marketer.Domain.Offer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service // Label its a microservice
public class Producer 
{
    @Value("${topic.name}") // Kafka Topic name = topic.offer
    private String offerTopic; // name of the topic
    private final ObjectMapper objectMapper; // Transform from json to offer and vice versa
    private final KafkaTemplate<String,String>kafkaTemplate; // Kafka API
    @Autowired
    public Producer(ObjectMapper objectMapper , KafkaTemplate<String,String>kafkaTemplate)
    {
        this.objectMapper=objectMapper;
        this.kafkaTemplate=kafkaTemplate;
    } // constructor
    public void sendMessage(Offer offer)throws JsonProcessingException
    {
        String offerAsMessage = objectMapper.writeValueAsString(offer);
        kafkaTemplate.send(offerTopic,offerAsMessage);
        log.info("offer produced{}",offerAsMessage);

    }

}
