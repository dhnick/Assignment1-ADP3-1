package za.ac.cput.builder;
/*
    Delivery.java
    Entity for Delivery
    Author: Jody Heideman (219307725)
    Date: 27/03/2022
 */

public class Delivery {

    private int deliveryID;
    private String deliveryMethod;
    private String deliveryAddress;
    private String deliveryTime;

    private Delivery(Builder builder){

        this.deliveryID = builder.deliveryID;
        this.deliveryMethod = builder.deliveryMethod;;
        this.deliveryAddress = builder.deliveryAddress;
        this.deliveryTime = builder.deliveryTime;

    }

    public int getDeliveryID() {
        return deliveryID;
    }

    public void setDeliveryID(int deliveryID) {
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

        private int deliveryID;
        private String deliveryMethod;
        private String deliveryAddress;
        private String deliveryTime;

        public Builder setDeliveryID(int deliveryID){
            this.deliveryID = deliveryID;
            return this;
        }

        public Builder setDeliveryMethod(String deliveryAddress){
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
