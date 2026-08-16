package com.suraj.orderservicemanagement.service;

import com.suraj.orderservicemanagement.repository.OrderRepository;
import com.suraj.orderservicemanagement.model.Order;
import com.suraj.orderservicemanagement.model.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)//Enables Mockito in your Junit 5 test
public class OrderServiceImplTest {
    @Mock//creates Fake object
    private OrderRepository orderRepository;

    @InjectMocks//in which class it will create fake object or above class
    private OrderServiceImpl orderService;

    @Test
    void createOrder(){
        Order order = new Order();
        order.setId(2);
        order.setCustomerName("SURAJ");
        order.setPrice(15000);
        order.setQuantity(1);
        order.setProduct("Mobile Phone");

        when(orderRepository.save(order)).thenReturn(order);
        //Order actualOrder = when(orderRepository.save(order)).thenReturn(order);

        Order result = orderService.createOrder(order);
        assertNotNull(result);

        assertEquals("Mobile Phone",result.getProduct());

    }
}
