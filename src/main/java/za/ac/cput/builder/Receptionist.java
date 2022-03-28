package za.ac.cput.builder;
/*
    Receptionist.java
    Entity for Receptionist
    Author: Jody Heideman (219307725)
    Date: 27/03/2022
 */

public class Receptionist {

    private int receptionistID;
    private int receptionistTime;
    private int numberOfPeople;
    private String createReservation;

    private Receptionist(){}
    private Receptionist(Builder builder){

        this.receptionistID = builder.receptionistID;
        this.receptionistTime = builder.receptionistTime;
        this.numberOfPeople = builder.numberOfPeople;
        this.createReservation = builder.createReservation;

    }

    public int getReceptionistID() {
        return receptionistID;
    }

    public void setReceptionistID(int receptionistID) {
        this.receptionistID = receptionistID;
    }

    public int getReceptionistTime() {
        return receptionistTime;
    }

    public void setReceptionistTime(int receptionistTime) {
        this.receptionistTime = receptionistTime;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getCreateReservation() {
        return createReservation;
    }

    public void setCreateReservation(String createReservation) {
        this.createReservation = createReservation;
    }

    @Override
    public String toString() {
        return "Receptionist{ " +
                "receptionistID = " + receptionistID +
                ", receptionistTime = " + receptionistTime +
                ", numberOfPeople = " + numberOfPeople +
                ", createReservation = '" + createReservation + '\'' +
                '}';
    }

    public static class Builder{
        private int receptionistID;
        private int receptionistTime;
        private int numberOfPeople;
        private String createReservation;

        public Builder setReceptionistID(int receptionistID){
            this.receptionistID= receptionistID;
            return this;
        }

        public Builder setReceptionistTime(int receptionistTime){
            this.receptionistTime = receptionistTime;return this;
        }

        public Builder setNumberOfPeople(int numberOfPeople){
            this.numberOfPeople = numberOfPeople;
            return this;
        }

        public Builder setCreateReservation(String createReservation){
            this.createReservation = createReservation;
            return this;
        }

        public Builder copy(Receptionist receptionist){
            this.receptionistID = receptionistID;
            this.receptionistTime = receptionistTime;
            this.numberOfPeople = numberOfPeople;
            this.createReservation = createReservation;
            return this;

        }

        public Receptionist build(){
            return new Receptionist(this);
        }
    }
}
