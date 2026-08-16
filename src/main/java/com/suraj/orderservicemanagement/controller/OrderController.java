package com.suraj.orderservicemanagement.controller;


import com.suraj.orderservicemanagement.model.Order;
import com.suraj.orderservicemanagement.repository.OrderRepository;
import com.suraj.orderservicemanagement.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order createOrder(@Valid @RequestBody Order order){
        return orderService.createOrder(order);
    }
}