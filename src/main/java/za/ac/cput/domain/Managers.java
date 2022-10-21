package za.ac.cput.domain;

/* Managers.Java
 *  Author: Tim Davids 219296219
 *  Entity for Manager
 *  Date: 27 March 2022
 * */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Managers implements Serializable {

    @NotNull
    @Id
    private String ManagerID;
    private String firstname;
    private String surname;
    private String Age;
    private String ContactNumber;

    protected Managers(){}

    private Managers(Builder builder) {
        this.ManagerID = builder.ManagerID;
        this.firstname = builder.firstname;
        this.surname = builder.surname;
        this.Age = builder.Age;
        this.ContactNumber = builder.ContactNumber;

    }


    public String getManagerID() {
        return ManagerID;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getAge() {
        return Age;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    @Override
    public String toString() {
        return "Managers{" +
                "ManagerID=" + ManagerID +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", Age=" + Age +
                ", ContactNumber=" + ContactNumber +
                '}';
    }


    public static class Builder {
        private String ManagerID;
        private String firstname;
        private String surname;
        private String Age;
        private String ContactNumber;

        public Builder setManagerID(String ManagerID) {
            this.ManagerID = ManagerID;
            return this;
        }


        public Builder setFirstname(java.lang.String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Builder setSurname(java.lang.String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setAge(String age) {
            Age = age;
            return this;
        }

        public Builder setContactNumber(String contactNumber) {
            ContactNumber = contactNumber;
            return this;
        }


        public Builder copy(Managers manager) {

            this.ManagerID = manager.ManagerID;
            this.firstname = manager.firstname;
            this.surname = manager.surname;
            this.Age = manager.Age;
            this.ContactNumber = manager.ContactNumber;

            return this;
        }

        public Managers build() {

            return new Managers(this);
        }
    }

}















