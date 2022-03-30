package za.ac.cput.Domain;

public class Builder {
    public int getManagerID() {
        return ManagerID;
    }

    public Builder setManagerID(int managerID) {
        ManagerID = managerID;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public Builder setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public Builder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public int getAge() {
        return Age;
    }

    public Builder setAge(int age) {
        Age = age;
        return this;
    }

    public int getContactNumber() {
        return ContactNumber;
    }

    public Builder setContactNumber(int contactNumber) {
        ContactNumber = contactNumber;
        return this;
    }

    private int ManagerID;
    private String firstname;
    private String surname;
    private int Age;
    private int ContactNumber;


    private Builder(Builder builder) {
        this.ManagerID = builder.ManagerID;
        this.firstname = builder.firstname;
        this.surname = builder.surname;


    }

}
