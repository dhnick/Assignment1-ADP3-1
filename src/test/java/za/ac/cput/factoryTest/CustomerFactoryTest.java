/* CustomerFactoryTest.java
   Entity for Customer
   Author: Damone Hartnick
   Student Number : 219093717
   Date: April 2022
*/
package za.ac.cput.factoryTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerFactoryTest {

 @Test
    public void test(){
       Customer customer = CustomerFactory.createCustomer(
               "979219WD",
               "Nick",
               "Coleman",
               "ColemanN@gmail.com",
               "22 Jump Street",
               "087 877 7285");
     System.out.println(customer.toString());
       assertNotNull(customer);

     }


}
