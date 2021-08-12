package shippingqueryservice.shippingqueryservice.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import shippingqueryservice.shippingqueryservice.domain.CheckoutEvent;

@Service
public class KafkaSender {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendCartCheckout(String topic, CheckoutEvent message){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String resultAsString = objectMapper.writeValueAsString(message);
            kafkaTemplate.send(topic, resultAsString);
        } catch(Exception ex) {}
    }

    public void logToKafka(String message) {
        kafkaTemplate.send("webstore-log", message);
    }
}
