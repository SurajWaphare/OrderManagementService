package com.suraj.orderservicemanagement.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String customerName;
    private String product;
    @Positive(message = "Quantity Must be at least 1")
    private int quantity;
    @Positive(message = "Price should not be lesser than 1")
    private double price;


}
