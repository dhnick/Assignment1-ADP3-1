/* IOrderRepository.java
   Entity for order
   Author: Damone Hartnick
   Student Number : 219093717
   Date: April 2022
*/

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Order;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Repository
public interface IOrderRepository extends JpaRepository<Order, String> {


    List<Order> findAll();
    List<Order> findByOrderId (String orderID);
   boolean existsByOrderId ( String orderID);


}
