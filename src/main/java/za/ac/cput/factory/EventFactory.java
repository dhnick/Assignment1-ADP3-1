package za.ac.cput.factory;
import za.ac.cput.domain.Event;
/* EventFactory.Java
 *  Entity for EventFactory
 *  Author: Yasmeen Nel (219250553)
 *  Date: 29 March 2022
 * */
public class EventFactory {
    public static Event createEvent(String eventID, String eventName, String requestedDate, String eventTheme){

        if (eventID.equals("")|| eventID == null)
            return null;
        if (eventName.equals("")|| eventName == null)
            return null;
        if (requestedDate.equals("")|| requestedDate == null)
            return null;
        if (eventTheme.equals("")|| eventTheme == null)
            return null;
        return new Event.Builder().setEventID(eventID)
                .setEventName(eventName)
                .setRequestedDate(requestedDate)
                .setEventTheme(eventTheme)
                .build();
    }
}
