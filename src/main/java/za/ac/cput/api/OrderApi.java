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
import za.ac.cput.service.IOrderService;

@Component
public class OrderApi {


    public final IOrderService orderService ;

    @Autowired
    public OrderApi (IOrderService orderService) {
        this.orderService = orderService;

    }

    public Order save ( Order order) {
        try {
            if (orderService.findByOrderId(order.getOrderID()) != null) {
                return orderService.create(order);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order ID not found , please create order first");
            }

        } catch ( IllegalArgumentException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Order ID not found , Please create order first");
        }

        }


    }

