package za.ac.cput.controllerTest;

/* OrderControllerTest.java
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
import za.ac.cput.controller.OrderController;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Order;
import za.ac.cput.factory.OrderFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private OrderController controller;


    @Autowired
    private TestRestTemplate restTemplate;
    private Order order;
    private String baseUrl ;



    @BeforeEach
    void setUp() {

        this.order = OrderFactory.createOrder(
                "9672324DHW",
                "Festive Special",
                "Medium",
                5
        );

        baseUrl = "http://localhost:" + this.port + "/restaurant/order/";
    }



    @Test
    void save() {
        String url = baseUrl + "save/";
        System.out.println(url);
        ResponseEntity<Order> response = this.restTemplate
                .postForEntity(url, this.order,Order.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())

        );
    }

    @Test
    void read() {
        String url = baseUrl + "read/" + this.order.getOrderID();
        System.out.println(url);
        ResponseEntity<Order> response = this.restTemplate.getForEntity(url, Order.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())


        );
    }

    @Test
    void delete() {
            String url = baseUrl + "delete/" + this.order.getOrderID();
            this.restTemplate.delete(url);
    }

    @Test
    void findAll() {
        String url = baseUrl + "findAll/";
        System.out.println(url);
        ResponseEntity<Order> response =
                this.restTemplate.getForEntity(url, Order.class);
        System.out.println(Arrays.asList(response.getBody()));

        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode())
               // () -> assertTrue(response.getBody().length==0)


        );
    }


}