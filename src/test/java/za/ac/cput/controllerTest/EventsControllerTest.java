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
import za.ac.cput.domain.Event;
import za.ac.cput.factory.EventFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EventsControllerTest {

    private static Event event1 = EventFactory
            .createEvent("548484", "Molly's Birthday Party",
                    "28 February 2022", "");

    private static Event event2 = EventFactory
            .createEvent("524353", "Lolly's Birthday Party",
                    "28 March 2022", "");


    @Autowired
    private TestRestTemplate restTemplate;
    private HttpHeaders httpHeaders = new HttpHeaders();
    private final String eventURL = "http://localhost:8080/event";

    private String username = "user";
    private String password = "password";




    @Test
    void a_save1() {
        String url = eventURL + "/save";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Event> httpEntitySave1 = new HttpEntity<>(event1, httpHeaders);
        ResponseEntity<Event> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntitySave1, Event.class);
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        event1 = responseEntity.getBody();
        System.out.println("Save Customer: "+event1);
        assertEquals(event1.getEventID(), responseEntity.getBody().getEventID());
    }

    @Test
    void b_save2() {
        String url = eventURL + "/save";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Event> httpEntitySave2 = new HttpEntity<>(event2, httpHeaders);
        ResponseEntity<Event> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntitySave2, Event.class);
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        event2 = responseEntity.getBody();
        System.out.println("Save Booking: "+event2);
        assertEquals(event2.getEventID(), responseEntity.getBody().getEventID());



    }

    @Test
    void c_read() {
        Event e = null;
        String url = eventURL + "/read/" + event2.getEventID();
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Event> request = new HttpEntity<>(e, httpHeaders);
        System.out.println("Url  " + url);
        ResponseEntity<Event> responseCreate = restTemplate.postForEntity(url, request, Event.class);
        assertNotNull(event2.getEventID(), responseCreate.getBody().getEventID());


    }

    @Test
    void d_update() {
        Event update = new Event.Builder().copy((event1)).setEventName("Molly's Birthday Party").build();
        String url = eventURL + "/update";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Event> httpEntity = new HttpEntity<>(update, httpHeaders);
        System.out.println("Url used to update the customer: " + url);
        System.out.println("Updated customer: "+ update);
        ResponseEntity<Event> responseUpdate = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Event.class);
        assertNotNull(responseUpdate.getBody());

    }

    @Test
    void f_delete() {
        String url = eventURL + "/delete" + event1.getEventID();
        System.out.println("URL" + url);
        restTemplate.delete(url);
    }

    @Test
    void g_findAll() {
        String url = eventURL + "/findAll";
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