/* OrderRepository.java
   Entity for order
   Author: Damone Hartnick
   Student Number : 219093717
   Date: April 2022
*/

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Order;

import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<Order, String> {


    List<Order> findAll();

    Order update (Order order);
    boolean delete (String orderID);





}
