package com.suraj.orderservicemanagement.service;

import com.suraj.orderservicemanagement.model.Order;
import com.suraj.orderservicemanagement.repository.OrderRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);
    @Override
    public Order createOrder(Order order) {

        if(order.getPrice()<1){
            throw new IllegalArgumentException("Price Cannot be lower than 0");
        }
        if(order.getQuantity()<1){
            throw new IllegalArgumentException("Quantity Cannot be less than 0");
        }
        Order savedOrder = orderRepository.save(order);
        log.info("Order Created successfully with id :",savedOrder.getId());
        return savedOrder;
    }
}