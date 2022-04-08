/* IOrderRepository.java
   Entity for order
   Author: Damone Hartnick
   Student Number : 219093717
   Date: April 2022
*/

package za.ac.cput.Repository;

import za.ac.cput.Domain.Order;

import java.util.Set;

public interface IOrderRepository extends IRepository<Order, String> {

   public Set<Order> getAll();
}
