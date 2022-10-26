package za.ac.cput.controllerTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Bookings;
import za.ac.cput.factory.BookingsFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookingsControllerTest {

    private static Bookings booking1 = BookingsFactory
            .createBooking("55555",
                    "Melissa Anniversary",
                    "25 May 2022",
                    "Vanilla cake",
                    "Recent Package");

    private static Bookings booking2 = BookingsFactory
            .createBooking("555444",
                    "Nel Birthday",
                    "20 May 2022",
                    "Chocolate cake",
                    "Recent Package");


    @Autowired
    private TestRestTemplate restTemplate;
    private HttpHeaders httpHeaders = new HttpHeaders();
    private final String bookingsURL = "http://localhost:8080/bookings";

    private String username = "user";
    private String password = "password";




    @Test
    void a_save1() {
        String url = bookingsURL + "/save";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Bookings> httpEntitySave1 = new HttpEntity<>(booking1, httpHeaders);
        ResponseEntity<Bookings> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntitySave1, Bookings.class);
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        booking1 = responseEntity.getBody();
        System.out.println("Save Customer: "+booking1);
        assertEquals(booking1.getBookingID(), responseEntity.getBody().getBookingID());
    }

    @Test
    void b_save2() {
        String url = bookingsURL + "/save";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Bookings> httpEntitySave2 = new HttpEntity<>(booking2, httpHeaders);
        ResponseEntity<Bookings> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntitySave2, Bookings.class);
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        booking2 = responseEntity.getBody();
        System.out.println("Save Booking: "+booking2);
        assertEquals(booking2.getBookingID(), responseEntity.getBody().getBookingID());



    }

    @Test
    void c_read() {
        Bookings b = null;
        String url = bookingsURL + "/read/" + booking2.getBookingID();
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Bookings> request = new HttpEntity<>(b, httpHeaders);
        System.out.println("Url  " + url);
        ResponseEntity<Bookings> responseCreate = restTemplate.postForEntity(url, request, Bookings.class);
        assertNotNull(booking2.getBookingID(), responseCreate.getBody().getBookingID());


    }

    @Test
    void d_update() {
        Bookings update = new Bookings.Builder().copy((booking1)).setBookingDescription("Melissa Anniversary").build();
        String url = bookingsURL + "/update";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Bookings> httpEntity = new HttpEntity<>(update, httpHeaders);
        System.out.println("Url used to update the customer: " + url);
        System.out.println("Updated customer: "+ update);
        ResponseEntity<Bookings> responseUpdate = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Bookings.class);
        assertNotNull(responseUpdate.getBody());

    }

    @Test
    void f_delete() {
        String url = bookingsURL + "/delete" + booking1.getBookingID();
        System.out.println("URL" + url);
        restTemplate.delete(url);
    }

    @Test
    void g_findAll() {
        String url = bookingsURL + "/findAll";
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