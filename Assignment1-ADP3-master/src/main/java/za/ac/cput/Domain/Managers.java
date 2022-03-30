package za.ac.cput.Domain;

public class Managers {
    public static boolean String;
    private int ManagerID;

    public int getManagerID() {
        return ManagerID;
    }

    public void setManagerID(int managerID) {
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

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(int contactNumber) {
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

    private String firstname;
    private String surname;
    private int Age;
    private int ContactNumber;

    public Managers() {
    }

    public Managers(String firstname, String surname) {
        this.firstname = firstname;
        this.surname = surname;
    }

    public Managers(int ManagerID, String firstname, String surname) {

        this.ManagerID = ManagerID;
        this.firstname = firstname;
        this.surname = surname;


        }


    public static class Builder {
    }
}



