/* OrderRepository.java
   Entity for order
   Author: Damone Hartnick
   Student Number : 219093717
   Date: April 2022
*/
package za.ac.cput.Repository;
import za.ac.cput.Domain.Order;
import java.util.HashSet;
import java.util.Set;

public class OrderRepository implements IOrderRepository {

    private static OrderRepository repository = null;
    private Set<Order> orderDB;


    private OrderRepository(){this.orderDB = new HashSet<>();}

    public static OrderRepository getRepository() {
        if (repository == null)
        {
            repository = new OrderRepository();
        }
        return repository;

    }

    @Override
    public Order create(Order order) {
        this.orderDB.add(order);
        return order;
    }

    @Override
    public Order read(String orderID) {
        for (Order od : orderDB){
            if (od.getOrderID().equals(orderID)){
                return od;
            }
        }
        return null;
    }

    @Override
    public Order update(Order order) {
        Order firstOrder = read(order.getOrderID());
        if (firstOrder != null){
            orderDB.remove(firstOrder);
            orderDB.add(order);
            return order;
        }
        return null;
    }



    @Override
    public void delete(String orderID) {
        Order deleteOrder = read(orderID);
        if (deleteOrder == null) {
            System.out.println("Order is null.");
        }
        orderDB.remove(deleteOrder);
        System.out.println("Order has been removed.");

    }

    @Override
    public Set<Order> getAll() {
        return orderDB;
    }


}
