package za.ac.cput.service;

/* OrderService.java
   Author: Damone Hartnick
   Student Number : 219093717
   Date: August 2022
*/

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Order;
import za.ac.cput.repository.CustomerRepository;
import za.ac.cput.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {

    private final OrderRepository repository;
    private static IOrderService SERVICE ;

    private OrderService() {this.repository = OrderRepository.getRepository();}

    public static IOrderService getService() {
        if ( SERVICE == null)
            SERVICE = new OrderService();
        return SERVICE;
    }


    @Override
    public Order save(Order order) {
        return this.repository.save(order);
    }

    @Override
    public Optional<Order> read(String s) {
        return this.repository.read(s);
    }

    @Override
    public void delete(Order order) {
        //fix error
        this.repository.delete(String.valueOf(order));


    }

    // List of all Employees
    @Override
    public List<Order> findAll() {
        return this.repository.findAll();
    }

    // Finds Order by orderID
    @Override
    public List<Order> findByOrderId(String orderID) {
        return this.repository.findByOrderId(orderID);
    }

    // Checks if staffId valid and exist
    // true = exist
    // false = doesn't exist or not valid
    @Override
    public boolean existsByOrderId(String orderID) {
        return this.repository.existsByOrderId( orderID);
    }

    @Override
    public void deleteById(String id) {
        Optional<Order> order = read(id);
              if(order.isPresent()){
                   delete(order.get());
               }

    }


}
