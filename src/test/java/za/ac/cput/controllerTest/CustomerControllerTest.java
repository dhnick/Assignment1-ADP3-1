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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.controller.CustomerController;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private CustomerController controller;


    @Autowired private TestRestTemplate restTemplate;

    private Customer customer;

    private String baseUrl ;

    @BeforeEach
    void setUp() {

        this.customer = CustomerFactory.createCustomer(
                "98746SA",
                "Julia",
                "Dumphy",
                "Jd56@gmail.com",
                "34 View Road, Lost City",
                "089 785 1597"
        );

        baseUrl = "http://localhost:" + this.port + "/restaurant/customer/";
    }

    @Order(1)
    @Test
    void save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Customer> response = this.restTemplate
                .postForEntity(url, this.customer,Customer.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())

        );
    }

    @Order(2)
    @Test
    void read() {
        String url = baseUrl + "read/" + this.customer.getCustomerID();
        System.out.println(url);
        ResponseEntity<Customer> response = this.restTemplate.getForEntity(url, Customer.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())


        );
    }

    @Order(3)
    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.customer.getCustomerID();
        this.restTemplate.delete(url);
    }

    @Order(4)
    @Test
    void findAll() {
        String url = baseUrl + "findAll/";
        System.out.println(url);
        ResponseEntity<Customer[]> response = this.restTemplate.getForEntity(url, Customer[].class);
        System.out.println(Arrays.asList(response.getBody()));

        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length==0)


        );
    }


}