/* CustomerRepository.java
   Entity for Customer
   Author: Damone Hartnick
   Student Number : 219093717
   Date: April 2022
*/
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Customer;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

     List<Customer> findAll();
     //Customer findByCustomerId( String customerID);

    //void deleteCustomerByCustomerID(String customerID);

    Customer update (Customer customer);
    boolean delete (String customerID);

    //Optional<Customer> findByFirstName(String firstname);




}
