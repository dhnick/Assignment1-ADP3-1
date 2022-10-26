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
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private static OrderService service ;

    @Autowired
    private  OrderRepository orderRepository;


    @Override
    public Order create(Order order) {
        return this.orderRepository.save(order);
    }

    @Override
    public Order read(String orderID) {
        return this.orderRepository.findById(orderID)
                .orElse(null);
    }

    @Override
    public Order update(Order order) {
        if (this.orderRepository.existsById(order.getOrderID()))
            return this.orderRepository.save(order);
        return order;
    }

    @Override
    public boolean delete(String orderID) {
        this.orderRepository.deleteById(orderID);
        if(this.orderRepository.existsById(orderID)){
            System.out.println("Order: "+orderID+" not Deleted");
            return false;
        }
        else{
            System.out.println("Order Deleted");
            return true;
        }
    }


    // List of all Orders
    @Override
    public List<Order> findAll() {
        return this.orderRepository.findAll().stream().collect(Collectors.toList());
    }




}
