package za.ac.cput.domain;
/* Event.Java
*  Entity for Event
*  Author: Yasmeen Nel (219250553)
*  Date: 29 March 2022
* */
public class Event {
    //Entity Attributes
    private String eventID;
    private String eventName;
    private String requestedDate;
    private String eventTheme;

   //Private Constructors
    private Event (){

    }
    private Event(Event.Builder builder){
        this.eventID = builder.eventID;
        this.eventName = builder.eventName;
        this.requestedDate = builder.requestedDate;
        this.eventTheme = builder.eventTheme;
    }

    //Getters
    public String getEventID() {
        return eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public String getRequestedDate() {
        return requestedDate;
    }

    public String getEventTheme() {
        return eventTheme;
    }
    //Setters

    public Event setEventID(String eventID) {
        this.eventID = eventID;
        return this;
    }

    public Event setEventName(String eventName) {
        this.eventName = eventName;
        return this;
    }

    public Event setRequestedDate(String requestedDate) {
        this.requestedDate = requestedDate;
        return this;
    }

    public Event setEventTheme(String eventTheme) {
        this.eventTheme = eventTheme;
        return this;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventID=" + eventID +
                ", eventName='" + eventName + '\'' +
                ", requestedDate='" + requestedDate + '\'' +
                ", eventTheme='" + eventTheme + '\'' +
                '}';
    }

    // Builders Class for Events
    public static class Builder{
        private String eventID;
        private String eventName;
        private String requestedDate;
        private String eventTheme;

        //Setters for Builders class
        public Builder setEventID(String eventID) {
            this.eventID = eventID;
            return this;
        }

        public Builder setEventName(String eventName) {
            this.eventName = eventName;
            return this;
        }

        public Builder setRequestedDate(String requestedDate) {
            this.requestedDate = requestedDate;
            return this;
        }

        public Builder setEventTheme(String eventTheme) {
            this.eventTheme = eventTheme;
            return this;
        }

        public Builder copy (Event event){
            this.eventID = event.eventID;
            this.eventName = event.eventName;
            this.requestedDate = event.eventName;
            this.eventTheme = event.eventTheme;
            return this;
    }
        public Event build(){
            return new Event(this);
        }
    }
}
