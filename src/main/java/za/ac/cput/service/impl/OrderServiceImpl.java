package za.ac.cput.service.impl;

/* OrderServiceImpl.java
   Author: Damone Hartnick
   Student Number : 219093717
   Date: August 2022
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Order;
import za.ac.cput.repository.OrderRepository;
import za.ac.cput.service.OrderService;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository)
    {this.orderRepository = orderRepository;}



    @Override
    public Order save(Order order) {
        return this.orderRepository.save(order);
    }

    @Override
    public Optional<Order> read(String s) {
        return this.orderRepository.findById(s);

    }

    @Override
    public void delete(Order order) {
        this.orderRepository.delete(order);
    }

    // Finds Order by orderID
    @Override
    public Order findByOrderId(String orderID) {
        return (Order) this.orderRepository.findByOrderId(orderID);
    }


    // List of all Orders
    @Override
    public List<Order> findAll() {
        return this.orderRepository.findAll();
    }




}
