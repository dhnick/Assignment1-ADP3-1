package za.ac.cput.controllerTest;

/* CustomerControllerTest.java
   Author: Damone Hartnick
   Student Number : 219093717
   Date: August 2022
*/

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import za.ac.cput.controller.CustomerController;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;



import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerControllerTest {


    @LocalServerPort
    private int port;

    @Autowired
    private CustomerController controller;

    @Autowired
    private TestRestTemplate restTemplate;
    private Customer customer;
    private  String baseUrl ;

    @BeforeEach
    public void setUp() {
       // assertNotNull(controller);
        this.customer = CustomerFactory.createCustomer("159753IR",
                "Irma",
                "Roche",
                "IR2@gmail.com",
                "2225 Rose Street BlueRock",
                "087 789 1475");

        this.baseUrl = "http://localhost:"+ this.port +"/restaurant/customer/";
    }

    @Order(1)
    @Test
    void save() {
        String url = baseUrl + "save/";
        System.out.println(url);
        ResponseEntity<Customer> response = this.restTemplate
                .postForEntity(url,this.customer,Customer.class);
        System.out.println(response);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()->assertNotNull(response.getBody())
        );
    }

    @Order(2)
    @Test
    void read() {
        String url = baseUrl + "read/"+ this.customer.getCustomerID();
        System.out.println(url);
        ResponseEntity<Customer> response = this.restTemplate.getForEntity(url,Customer.class);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Order(3)
    @Test
    void deleteCustomerByCustomerID() {
        String url = baseUrl + "delete/"+ this.customer.getCustomerID();
        this.restTemplate.delete(url);
    }


    @Test
    void findAll() {
        String url = baseUrl + "all" ;
        System.out.println(url);
        ResponseEntity<Customer> response =
                this.restTemplate.getForEntity(url,Customer.class);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode())
        );
    }


}