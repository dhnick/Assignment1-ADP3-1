package za.ac.cput.Domain;

public class Waiters {
    private int StaffID;
    private String firstname;

    public int getStaffID() {
        return StaffID;
    }

    public void setStaffID(int staffID) {
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

    public int getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(int contactNumber) {
        ContactNumber = contactNumber;
    }

    private String surname;
    private int ContactNumber;



    public Waiters(int StaffID, String firstname, String surname, int ContactNumber){

        this.StaffID = StaffID;
        this.firstname = firstname;
        this.surname = surname;
        this.ContactNumber = ContactNumber;


    }

    }

