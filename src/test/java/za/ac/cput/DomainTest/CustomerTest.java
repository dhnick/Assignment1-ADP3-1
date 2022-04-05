/* CustomerTest.java
   Entity for Customer
   Author: Damone Hartnick
   Student Number : 219093717
   Date: April 2022
*/
package za.ac.cput.DomainTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Customer;

public class CustomerTest {

    @Test
    public void test(){

        Customer customer1 = new Customer.Builder()
                .setCustomerID("458DW")
                .setFirstName("Dave")
                .setLastName("Hill")
                .setAddress("22 Rose Street")
                .setEmail("215053517@mycput.ac.za")
                .setContactNumber("084 322 9199")
                .build();

        Customer newCustomer = new Customer.Builder()
                .setFirstName("Michelle")
                .setLastName("Brown")
                .setContactNumber("062 321 4213")
                .build();

        System.out.println(customer1);
        System.out.println(newCustomer);
    }






}
