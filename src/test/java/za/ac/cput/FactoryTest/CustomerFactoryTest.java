/* CustomerFactoryTest.java
   Entity for Customer
   Author: Damone Hartnick
   Student Number : 219093717
   Date: April 2022
*/
package za.ac.cput.FactoryTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerFactoryTest {

 @Test
    public void test(){
       Customer customer = CustomerFactory.createCustomer(
               "25G",
               "Damone",
               "Hartnick",
               "219093717@mycput.ac.za",
               "22 Jump Street",
               "087 877 7285");
     System.out.println(customer.toString());
       assertNotNull(customer);

     }


}
