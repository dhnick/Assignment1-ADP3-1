package za.ac.cput.api;

/*
Damone Hartnick
OrderApi.java
Student Number 219093717
Date : August 2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Order;
import za.ac.cput.service.impl.OrderServiceImpl;

@Component
public class OrderApi {


    public final OrderServiceImpl orderService ;

    @Autowired
    public OrderApi (OrderServiceImpl orderService) {
        this.orderService = orderService;

    }

    public Order save ( Order order) {
        this.orderService.read(order.getOrderID())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order ID not found"));
        return this.orderService.save(order);
    }


    }

