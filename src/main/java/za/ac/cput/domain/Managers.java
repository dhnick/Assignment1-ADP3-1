package za.ac.cput.domain;

public class Managers {
    private static String ManagerID;
    private String firstname;
    private String surname;
    private String Age;
    private String ContactNumber;

    private Managers(Builder builder) {
        this.ManagerID = builder.ManagerID;
        this.firstname = builder.firstname;
        this.surname = builder.surname;
        this.Age = builder.Age;
        this.ContactNumber = builder.ContactNumber;

    }


    public static String getManagerID() {
        return ManagerID;
    }

    public void setManagerID(String managerID) {
        ManagerID = managerID;
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

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        ContactNumber = contactNumber;
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















