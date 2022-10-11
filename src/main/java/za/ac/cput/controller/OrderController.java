package za.ac.cput.controller;

/*
Damone Hartnick 219093717
OrderController.java
Date : August 2022
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Order;
import za.ac.cput.service.OrderService;
import za.ac.cput.service.impl.OrderServiceImpl;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("restaurant/order/")
@Slf4j
public class OrderController {

    private final OrderServiceImpl orderService;

    @Autowired
    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @PostMapping("save")
    public ResponseEntity<Order> save(@Valid @RequestBody Order order) {
        return ResponseEntity.ok
                (this.orderService.save(order));
    }

    @GetMapping("read/{type}")
    public ResponseEntity<Order> read(@PathVariable String orderID) {
        Order read = this.orderService.findByOrderId(orderID);
        return ResponseEntity.ok(read);
    }

    @GetMapping("all")
    public ResponseEntity<List<Order>> findAll() {
        List<Order> orders = this.orderService.findAll();
        return ResponseEntity.ok(orders);
    }

}
