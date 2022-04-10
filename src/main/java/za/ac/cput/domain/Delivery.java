package za.ac.cput.domain;
/*
    Delivery.java
    Entity for Delivery
    Author: Jody Heideman (219307725)
    Date: 27/03/2022
 */

public class Delivery {

    private String deliveryID;
    private String deliveryMethod;
    private String deliveryAddress;
    private String deliveryTime;

    private Delivery(Builder builder){

        this.deliveryID = builder.deliveryID;
        this.deliveryMethod = builder.deliveryMethod;;
        this.deliveryAddress = builder.deliveryAddress;
        this.deliveryTime = builder.deliveryTime;

    }

    public String getDeliveryID() {
        return deliveryID;
    }

    public void setDeliveryID(String deliveryID) {
        this.deliveryID = deliveryID;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "deliveryID = " + deliveryID +
                ", deliveryMethod = '" + deliveryMethod + '\'' +
                ", deliveryAddress = '" + deliveryAddress + '\'' +
                ", deliveryTime = '" + deliveryTime + '\'' +
                '}';
    }

    public static class Builder{

        private String deliveryID;
        private String deliveryMethod;
        private String deliveryAddress;
        private String deliveryTime;

        public Builder setDeliveryID(String deliveryID){
            this.deliveryID = deliveryID;
            return this;
        }

        public Builder setDeliveryMethod(String deliveryMethod){
            this.deliveryMethod = deliveryMethod;
            return this;
        }

        public Builder setDeliveryAddress(String deliveryAddress){
            this.deliveryAddress = deliveryAddress;
            return this;

        }

        public Builder setDeliveryTime(String deliveryTime){
            this.deliveryTime = deliveryTime;
            return this;
        }

        public Builder copy(Delivery delivery){

            this.deliveryID = deliveryID;
            this.deliveryMethod = deliveryMethod;
            this.deliveryAddress = deliveryAddress;
            this.deliveryTime = deliveryTime;
            return this;


        }
        public Delivery build(){
            return new Delivery(this);
        }

    }
}
