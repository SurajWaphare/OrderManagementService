package com.suraj.orderservicemanagement.service;

import com.suraj.orderservicemanagement.event.OrderCreatedEvent;
import com.suraj.orderservicemanagement.kafka.OrderkafkaProducer;
import com.suraj.orderservicemanagement.model.Order;
import com.suraj.orderservicemanagement.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    private OrderkafkaProducer orderkafkaProducer;

    public OrderServiceImpl(OrderRepository orderRepository, OrderkafkaProducer orderkafkaProducer) {
        this.orderRepository = orderRepository;
        this.orderkafkaProducer = orderkafkaProducer;
    }

    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);
    @Override
    public Order createOrder(Order order) {

//        if(order.getPrice()<1){
//            throw new IllegalArgumentException("Price Cannot be lower than 0");
//        }
//        if(order.getQuantity()<1){
//            throw new IllegalArgumentException("Quantity Cannot be less than 0");
//        }
        Order savedOrder = orderRepository.save(order);
        OrderCreatedEvent event = new OrderCreatedEvent(
                savedOrder.getId(),
                savedOrder.getPrice(),
                savedOrder.getQuantity()
        );

        orderkafkaProducer.sendOrderCreatedEvent(event);
        log.info("Creating order for Customer :{}",order.getCustomerName());
        log.info("Order Created successfully with id :" + savedOrder.getId());

        return savedOrder;
    }
}