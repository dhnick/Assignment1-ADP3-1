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
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.OrderFactory;
import za.ac.cput.service.OrderService;
import za.ac.cput.service.impl.OrderServiceImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/order/")
@Slf4j
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Order create(@RequestBody Order order) {
        Order newOrder = OrderFactory.createOrder(
                order.getOrderID(),
                order.getOrderDetails(),
                order.getOrderType(),
                order.getOrderQuantity());
        return orderService.create(newOrder);
    }

    @RequestMapping("/read/{orderID}")
    public Order read(@PathVariable String orderID){
        return orderService.read(orderID);
    }

    @PostMapping("/update")
    public Order update(@RequestBody Order order)
    {return orderService.update(order);}


    @DeleteMapping("/delete/{orderID}")
    public boolean delete(@PathVariable String orderID) {
        return orderService.delete(orderID);}


    @GetMapping("/findAll")
    public List<Order> findAll() {
        return orderService.findAll();


    }


}
