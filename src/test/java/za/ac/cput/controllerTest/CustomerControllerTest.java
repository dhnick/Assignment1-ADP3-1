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


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class CustomerControllerTest {

    private static Customer customer1 = CustomerFactory
            .createCustomer("159753IR",
            "Irma",
            "Roche",
            "IR2@gmail.com",
            "2225 Rose Street BlueRock",
            "087 789 1475");

    private static Customer customer2 = CustomerFactory
            .createCustomer("#8529631",
            "Josh",
            "Newman",
            "NewmanJ21@gmail.com",
            "192 View Road Rock City",
            "072 596 3241");


    @Autowired
    private TestRestTemplate restTemplate;
    private HttpHeaders httpHeaders = new HttpHeaders();
    private final String customerURL = "http://localhost:8080/customer";

    private String username = "user";
    private String password = "password";




    @Test
    void a_save1() {
        String url = customerURL + "/save";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Customer> httpEntitySave1 = new HttpEntity<>(customer1, httpHeaders);
        ResponseEntity<Customer> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntitySave1, Customer.class);
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        customer1 = responseEntity.getBody();
        System.out.println("Save Customer: "+customer1);
        assertEquals(customer1.getCustomerID(), responseEntity.getBody().getCustomerID());
    }

    @Test
    void b_save2() {
        String url = customerURL + "/save";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Customer> httpEntitySave2 = new HttpEntity<>(customer2, httpHeaders);
        ResponseEntity<Customer> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntitySave2, Customer.class);
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        customer2 = responseEntity.getBody();
        System.out.println("Save Customer: "+customer2);
        assertEquals(customer2.getCustomerID(), responseEntity.getBody().getCustomerID());



    }

    @Test
    void c_read() {
        Customer c = null;
        String url = customerURL + "/read/" +customer2.getCustomerID();
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Customer> request = new HttpEntity<>(c, httpHeaders);
        System.out.println("Url  " + url);
        ResponseEntity<Customer> responseCreate = restTemplate.postForEntity(url, request, Customer.class);
        assertNotNull(customer2.getCustomerID(), responseCreate.getBody().getCustomerID());


    }

    @Test
    void d_update() {
        Customer update = new Customer.Builder().copy((customer1)).setFirstName("Dave").build();
        String url = customerURL + "/update";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Customer> httpEntity = new HttpEntity<>(update, httpHeaders);
        System.out.println("Url used to update the customer: " + url);
        System.out.println("Updated customer: "+ update);
        ResponseEntity<Customer> responseUpdate = restTemplate.exchange(url, HttpMethod.POST, httpEntity,Customer.class);
        assertNotNull(responseUpdate.getBody());

    }

    @Test
    void f_delete() {
        String url = customerURL + "/delete" + customer1.getCustomerID();
        System.out.println("URL" + url);
        restTemplate.delete(url);
    }

    @Test
    void g_findAll() {
        String url = customerURL + "/findAll";
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