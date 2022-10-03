/* OrderRepository.java
   Entity for order
   Author: Damone Hartnick
   Student Number : 219093717
   Date: April 2022
*/
package za.ac.cput.repository;
import za.ac.cput.domain.Order;

import java.util.*;
import java.util.stream.Collectors;

public class OrderRepository {

    private List<Order> orderList;
    private static OrderRepository ORDER_REPOSITORY;



    private OrderRepository(){this.orderList = new ArrayList<>();}

    public static OrderRepository getRepository() {
        if (ORDER_REPOSITORY == null)
        {
            ORDER_REPOSITORY = new OrderRepository();
        }
        return ORDER_REPOSITORY;

    }


    public Order save (Order order) {
        Optional<Order> read = read(order.getOrderID());
        if ( read.isPresent()){
            delete(String.valueOf(read.get()));  //fix error
        }
        this.orderList.add(order);
        return order;
    }


    public Optional <Order> read( String orderID) {
       return this.orderList.stream().filter(g -> g.getOrderID().equalsIgnoreCase(orderID))
               .findFirst();
    }


    public void delete(String order) {
       this.orderList.remove(order);

    }


   public List<Order> findAll() {return this.orderList;}

    public List<Order> findByOrderId ( String orderID) {
        return this.orderList.stream().filter( g -> g.getOrderID().equalsIgnoreCase(orderID))
                .collect(Collectors.toList());
    }

   public boolean existsByOrderId ( String orderID) { return existsByOrderId(orderID);}


}
