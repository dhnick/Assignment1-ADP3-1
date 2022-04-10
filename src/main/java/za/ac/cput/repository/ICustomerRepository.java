/* ICustomerRepository.java
   Entity for Customer
   Author: Damone Hartnick
   Student Number : 219093717
   Date: April 2022
*/
package za.ac.cput.repository;

import za.ac.cput.domain.Customer;

import java.util.Set;

public interface ICustomerRepository extends IRepository<Customer, String>{
    // CRUD
    public Set<Customer> getAll();


}
