package za.ac.cput.domain;

/* Waiters.Java
 *  Author: Tim Davids 219296219
 *  Entity for Waiters
 *  Date: 27 March 2022
 * */


public class Waiters {

    private static String StaffID;
    private String firstname;
    private String surname;
    private String ContactNumber;

    private Waiters(Builder builder) {

        this.StaffID = builder.StaffID;
        this.firstname = builder.firstname;
        this.surname = builder.surname;
        this.ContactNumber = builder.ContactNumber;
    }



    public static String getStaffID() {
        return StaffID;
    }

    public void setStaffID(String staffID) {
        StaffID = staffID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        ContactNumber = contactNumber;
    }


    @Override
    public String toString() {
        return "Waiters{" +
                "StaffID=" + StaffID +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", ContactNumber=" + ContactNumber +
                '}';
    }

    public static class Builder {

        private String StaffID;
        private String firstname;
        private String surname;
        private String ContactNumber;

        public Builder setStaffID(String staffID) {
            StaffID = staffID;
            return this;
        }

        public Builder setFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setContactNumber(String contactNumber) {
            ContactNumber = contactNumber;
            return this;
        }

        public Builder copy(Waiters waiters) {

            this.StaffID = waiters.StaffID;
            this.firstname = waiters.firstname;
            this.surname = waiters.surname;
            this.ContactNumber = waiters.ContactNumber;

            return this;
        }

        public Waiters build() {
            return new Waiters(this);
        }
    }

}