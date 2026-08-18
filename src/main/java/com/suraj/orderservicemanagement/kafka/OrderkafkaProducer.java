package com.suraj.orderservicemanagement.kafka;

import com.suraj.orderservicemanagement.event.OrderCreatedEvent;
import org.apache.camel.ProducerTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class OrderkafkaProducer {
    //private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;
    private final ProducerTemplate producerTemplate;

    public OrderkafkaProducer(ProducerTemplate producerTemplate) {
        this.producerTemplate = producerTemplate;
    }

    public void sendOrderCreatedEvent(OrderCreatedEvent message){
        //kafkaTemplate.send("order-created",message);
        producerTemplate.sendBody("direct:order-created",message);
    }
}
