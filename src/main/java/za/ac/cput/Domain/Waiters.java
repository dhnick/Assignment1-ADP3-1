package za.ac.cput.Domain;


import org.apache.maven.surefire.shade.org.apache.commons.lang3.builder.Builder;

public class Waiters {

    private static String StaffID;
    private String firstname;
    private String surname;
    private String ContactNumber;

    private Waiters(builder builder) {

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

    public static class builder {

        private String StaffID;
        private String firstname;
        private String surname;
        private String ContactNumber;

        public builder setStaffID(String staffID) {
            StaffID = staffID;
            return this;
        }

        public builder setFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public builder setContactNumber(String contactNumber) {
            ContactNumber = contactNumber;
            return this;
        }

        public builder copy(Waiters waiters) {

            this.StaffID = StaffID;
            this.firstname = firstname;
            this.surname = surname;
            this.ContactNumber = ContactNumber;
            {

            }


            return null;
        }

        public Waiters build() {
            return new Waiters(this);
        }
    }

}