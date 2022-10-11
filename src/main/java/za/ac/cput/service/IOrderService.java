package za.ac.cput.service;

/* IOrderService.java
   Author: Damone Hartnick
   Student Number : 219093717
   Date: August 2022
*/

import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Order;

import java.util.List;
import java.util.Optional;

public interface IOrderService extends  IService <Order, String> {

    List<Order> findAll();
    List<Order> findByOrderId ( String orderID);


    boolean existsByOrderId( String orderID);
    void deleteById(String id);



    // check orderID valid and exist





}







