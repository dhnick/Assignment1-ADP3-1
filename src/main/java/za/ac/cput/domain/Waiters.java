package za.ac.cput.domain;

/* Waiters.Java
 *  Author: Tim Davids 219296219
 *  Entity for Waiters
 *  Date: 27 March 2022
 * */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Waiters implements Serializable {

    @NotNull
    @Id
    private String StaffID;
    private String firstname;
    private String surname;
    private String ContactNumber;

    protected Waiters(){}

    private Waiters(Builder builder) {

        this.StaffID = builder.StaffID;
        this.firstname = builder.firstname;
        this.surname = builder.surname;
        this.ContactNumber = builder.ContactNumber;
    }



    public String getStaffID() {
        return StaffID;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getContactNumber() {
        return ContactNumber;
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