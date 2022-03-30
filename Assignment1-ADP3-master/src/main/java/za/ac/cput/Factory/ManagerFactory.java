package za.ac.cput.Factory;

import za.ac.cput.Domain.Managers;

public class ManagerFactory {

    public static Managers createManager(String firstname,String surname) {
        return new Managers.Builder().firstname(firstname)
                .setsurname(surname)
                .build();

    }


}
