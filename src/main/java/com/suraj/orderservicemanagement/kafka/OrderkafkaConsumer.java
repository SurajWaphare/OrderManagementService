package com.suraj.orderservicemanagement.kafka;
import com.suraj.orderservicemanagement.event.OrderCreatedEvent;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.suraj.orderservicemanagement.event.OrderCreatedEvent;

@Component
public class OrderkafkaConsumer {

    @KafkaListener(topics = "order-created", groupId = "order-service-group")
    public void consumeOrderCreatedEvent(OrderCreatedEvent event) {
        System.out.println(
                "Received Order Event: " +
                        event.getOrderId() + ", " +
                        event.getPrice() + ", " +
                        event.getQuantity()
        );
    }
}