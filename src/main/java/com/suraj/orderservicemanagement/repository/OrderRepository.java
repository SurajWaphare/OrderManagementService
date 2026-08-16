package com.suraj.orderservicemanagement.repository;

import com.suraj.orderservicemanagement.model.Order;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

@Registered
public interface OrderRepository extends JpaRepository <Order,Long>{

}