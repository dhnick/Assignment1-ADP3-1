package za.ac.cput.DomainTest;
/*  EvenTest.Java
 *  Test Entity for Event
 *  Author: Yasmeen Nel (219250553)
 *  Date: 29 March 2022
 * */
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Event;

class EventTest {
    @Test
    public void test(){
        Event event1 = new Event.Builder().setEventID("1525")
                .setEventName("Gilda's Celebratory supper")
                .setRequestedDate("17 March 2022")
                .setEventTheme("Black and White")
                .build();
        Event newEvent = new Event.Builder().setEventName("Jorge's Birthday")
                        .setRequestedDate("19 March 2022")
                        .build();
        System.out.println(event1);
        System.out.println(newEvent);
    }

}