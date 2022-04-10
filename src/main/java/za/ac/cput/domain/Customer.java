/* Customer.java
   Entity for Customer
   Author: Damone Hartnick
   Student Number : 219093717
   Date: April 2022
*/
package za.ac.cput.domain;

public class Customer {
    private String customerID;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String contactNumber;

    //Insert private constructor
    private Customer(Builder builder){
        this.customerID = builder.customerID;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.address = builder.address;
        this.contactNumber = builder.contactNumber;

    }


    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID='" + customerID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }

    public static class Builder {
        private String customerID;
        private String firstName;
        private String lastName;
        private String email;
        private String address;
        private String contactNumber;

        public Builder setCustomerID(String customerID) {
            this.customerID = customerID;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }


    public Builder copy (Customer customer){
            this.customerID = customer.customerID;
            this.firstName = customer.firstName;
            this.lastName = customer.lastName;
            this.email = customer.email;
            this.address = customer.address;
            this.contactNumber = customer.contactNumber;
            return this;
    }

            public Customer build(){
             return new Customer(this);

            }

    }
}
