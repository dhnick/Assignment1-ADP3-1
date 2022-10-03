package za.ac.cput.controller;

/*
Damone Hartnick 219093717
OrderController.java
Date : August 2022
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Order;
import za.ac.cput.service.IOrderService;
import za.ac.cput.service.OrderService;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("restaurant/order/")
@Slf4j
public class OrderController {

    private final IOrderService iOrderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.iOrderService = orderService;
    }


    @PostMapping("save")
    public ResponseEntity<Order> save(@Valid @RequestBody Order order){
        log.info("Save request: {}", order);
        Order saved = iOrderService.save(order);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("read/{orderID}")
    public ResponseEntity<Order> read(@PathVariable String orderID){
        Order order = this.iOrderService.read(orderID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
        return ResponseEntity.ok(order);
    }

    @DeleteMapping("delete/{orderID}")
    public ResponseEntity<Void> delete(@PathVariable String id)
    {
        log.info("Delete request: {}", id);
        this.iOrderService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("findAll")
    public ResponseEntity<List<Order>> findAll(){
        List<Order> orderList = this.iOrderService.findAll();
        return ResponseEntity.ok(orderList);
    }

    @GetMapping("findByOrderId")
    public ResponseEntity<List<Order>> findByOrderId(@PathVariable String orderID){
        log.info(" Find request: {}" , orderID);
        List<Order> orderList = this.iOrderService.findByOrderId(orderID);
        return ResponseEntity.ok(orderList);

    }




}
