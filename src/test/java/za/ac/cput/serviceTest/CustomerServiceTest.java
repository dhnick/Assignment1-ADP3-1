package za.ac.cput.serviceTest;

/* CustomerServiceTest.java
   Author: Damone Hartnick
   Student Number : 219093717
   Date: August 2022
*/

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.service.CustomerService;
import za.ac.cput.service.ICustomerService;



import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {

    @Mock
    private Customer customerRepository;

    @InjectMocks
    private ICustomerService service;

    @BeforeEach
    void setUp() {

      this.customerRepository = CustomerFactory.createCustomer(
              "213DH&",
               "Jack",
               "Jones",
               "jjones24@gmail.com",
                "22 Jump Street , RockCity",
               "069 887 4567"
      );
      this.service = CustomerService.getService();

    }

    @AfterEach
    void tearDown() {
        this.service.delete(this.customerRepository);
    }


    @Test
    void save() {
        Customer saved = this.service.save(this.customerRepository);
        assertNotNull(saved);
        assertSame(this.customerRepository, saved);
    }

    @Test
    void read() {
        Customer saved = this.service.save(this.customerRepository);
        Optional<Customer> read = this.service.read(saved.getCustomerID());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () ->assertSame(saved,read.get())

        );

    }

    @Test
    void delete() {
        Customer saved = this.service.save(this.customerRepository);
        List<Customer> customerList= this.service.findAll();
        assertEquals(1, customerList.size());
        this.service.delete(saved);
        customerList= this.service.findAll();
        assertEquals(0,customerList.size());
    }

    @Test
    void findAll() {
        this.service.save(this.customerRepository);
        List<Customer> customerList= this.service.findAll();
        assertEquals(1,customerList.size());
    }

    @Test
    void findByCustomerId() {
        this.service.findByCustomerId("213DH");
        List<Customer> customerList= this.service.findByCustomerId(customerRepository.getCustomerID());
        System.out.println(customerRepository);
        assertNotNull(customerList);
    }

    @Test
    void findCustomerFirstNameByEmail() {
        this.service.findCustomerFirstNameByEmail("jjones24@gmail.com");
        Optional<Customer> customerOptional= this.service.findCustomerFirstNameByEmail(customerRepository.getEmail());
        System.out.println(customerOptional);
        assertNotNull(customerOptional);
    }




}