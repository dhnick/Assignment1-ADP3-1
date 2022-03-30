package za.ac.cput.FactoryTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Customer;
import za.ac.cput.Factory.CustomerFactory;

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
               "0843999111");
     System.out.println(customer.toString());
       assertNotNull(customer);

     }


}
