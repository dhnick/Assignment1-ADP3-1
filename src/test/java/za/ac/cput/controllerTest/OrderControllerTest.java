package za.ac.cput.controllerTest;

/* OrderControllerTest.java
   Author: Damone Hartnick
   Student Number : 219093717
   Date: August 2022
*/

import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import za.ac.cput.controller.OrderController;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Order;
import za.ac.cput.factory.OrderFactory;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderControllerTest {


    private static Order order1 = OrderFactory.createOrder(
                "#357951",
                "Festive Special",
                "Medium",
                5
        );

    private static Order order2 = OrderFactory.createOrder(
            "#159753",
            "House Special",
            "Large",
            8
    );

    @Autowired
    private TestRestTemplate restTemplate;
    private HttpHeaders httpHeaders = new HttpHeaders();
    private final String orderURL = "http://localhost:8080/order";

    private String username = "user";
    private String password = "password";

    @Test
    void a_save1() {
        String url = orderURL + "/save";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Order> httpEntitySave1 = new HttpEntity<>(order1, httpHeaders);
        ResponseEntity<Order> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntitySave1, Order.class);
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        order1 = responseEntity.getBody();
        System.out.println("Save Order: "+order1);
        assertEquals(order1.getOrderID(), responseEntity.getBody().getOrderID());
    }

    @Test
    void b_save2() {
        String url = orderURL + "/save";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Order> httpEntitySave2 = new HttpEntity<>(order2, httpHeaders);
        ResponseEntity<Order> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntitySave2, Order.class);
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        order2 = responseEntity.getBody();
        System.out.println("Save Order: "+order2);
        assertEquals(order2.getOrderID(), responseEntity.getBody().getOrderID());

    }

    @Test
    void c_read() {
        Order o = null;
        String url = orderURL + "/read/" +order2.getOrderID();
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Order> request = new HttpEntity<>(o, httpHeaders);
        System.out.println("Url  " + url);
        ResponseEntity<Order> responseCreate = restTemplate.postForEntity(url, request, Order.class);
        assertNotNull(order2.getOrderID(), responseCreate.getBody().getOrderID());


    }

    @Test
    void d_update() {
        Order update = new Order.Builder().copy(Optional.ofNullable(order1)).setOrderQuantity(12).build();
        String url = orderURL + "/update";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Order> httpEntity = new HttpEntity<>(update, httpHeaders);
        System.out.println("Url used to update the order: " + url);
        System.out.println("Updated order: "+ update);
        ResponseEntity<Order> responseUpdate = restTemplate.exchange(url, HttpMethod.POST, httpEntity,Order.class);
        assertNotNull(responseUpdate.getBody());

    }

    @Test
    void f_delete() {
        String url = orderURL + "/delete" + order1.getOrderID();
        System.out.println("URL" + url);
        restTemplate.delete(url);
    }

    @Test
    void g_findAll() {
        String url = orderURL + "/findAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate
                //basic config
                .withBasicAuth("user","password")
                .exchange(url, HttpMethod.GET, entity,String.class);
        System.out.println("Display All Entries");
        System.out.println(response);
        System.out.println(response.getBody());
    }



    }