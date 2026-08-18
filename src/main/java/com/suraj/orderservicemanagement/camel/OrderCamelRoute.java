package com.suraj.orderservicemanagement.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class OrderCamelRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("direct:order-created")
                .routeId("order-created-route")
                .log("1.Camel Received order event :${body}")
                .to("kafka:order_created?brokers=localhost:9092")
                .log("2. Camel sent message to kafka topic order_created");
    }
}
