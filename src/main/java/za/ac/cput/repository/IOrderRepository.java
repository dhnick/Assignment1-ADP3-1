/* IOrderRepository.java
   Entity for order
   Author: Damone Hartnick
   Student Number : 219093717
   Date: April 2022
*/

package za.ac.cput.repository;

import za.ac.cput.domain.Order;

import java.util.Set;

public interface IOrderRepository extends IRepository<Order, String> {

   public Set<Order> getAll();
}
