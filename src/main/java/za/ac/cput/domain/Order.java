/* Customer.java
   Entity for Customer
   Author: Damone Hartnick
   Student Number : 219093717
   Date: April 2022
*/
package za.ac.cput.domain;

public class Order {

    private String  orderID;
    private String orderDetails;
    private String orderType ;
    private int orderQuantity;


    //insert private constructor
    private Order(Builder builder){
       this.orderID = builder.orderID;
       this.orderDetails = builder.orderDetails;
       this.orderType = builder.orderType;
       this.orderQuantity = builder.orderQuantity;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID='" + orderID + '\'' +
                ", orderDetails='" + orderDetails + '\'' +
                ", orderType='" + orderType + '\'' +
                ", orderQuantity=" + orderQuantity +
                '}';
    }


    public static class Builder {
        private String  orderID;
        private String orderDetails;
        private String orderType ;
        private int orderQuantity;

        public Builder setOrderID(String orderID) {
            this.orderID = orderID;
            return this;

        }

        public Builder setOrderDetails(String orderDetails) {
            this.orderDetails = orderDetails;
            return  this;
        }

        public Builder setOrderType(String orderType) {
            this.orderType = orderType;
            return this;

        }

        public Builder setOrderQuantity(int orderQuantity) {
            this.orderQuantity = orderQuantity;
            return this;

        }

        public Builder copy (Order order) {
            this.orderID = order.orderID;
            this.orderDetails = order.orderDetails;
            this.orderType = order.orderType;
            this.orderQuantity = order.orderQuantity;
            return this;
        }

        public Order build(){
            return new Order(this);
        }


    }


}
