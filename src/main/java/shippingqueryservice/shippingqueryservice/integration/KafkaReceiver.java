package shippingqueryservice.shippingqueryservice.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.kafka.annotation.KafkaListener;
import shippingqueryservice.shippingqueryservice.domain.ProductAddedEvent;
import shippingqueryservice.shippingqueryservice.domain.ProductRemovedEvent;
import shippingqueryservice.shippingqueryservice.domain.ProductUpdatedEvent;
import shippingqueryservice.shippingqueryservice.service.ShoppingCartService;

@Service
public class KafkaReceiver {
    @Autowired
    private ShoppingCartService service;

    @KafkaListener(topics = {"product-added"})
    public void receiveAdd(@Payload String message) {
        System.out.println("Receiver received product added message = " + message);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ProductAddedEvent event = objectMapper.readValue(message, ProductAddedEvent.class);
            service.addToCart(event);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @KafkaListener(topics = {"product-updated"})
    public void receiveUpdate(@Payload String message) {
        System.out.println("Receiver received product updated message = "+ message);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ProductUpdatedEvent event = objectMapper.readValue(message, ProductUpdatedEvent.class);
            service.updateFromCart(event);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @KafkaListener(topics = {"product-removed"})
    public void receiveRemove(@Payload String message) {
        System.out.println("Receiver received product removed message = "+ message);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ProductRemovedEvent event = objectMapper.readValue(message, ProductRemovedEvent.class);
            service.removeFromCart(event);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}

