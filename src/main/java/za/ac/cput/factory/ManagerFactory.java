package za.ac.cput.factory;

/* ManagersFactory.Java
 *  Author: Tim Davids 219296219
 *  Entity for ManagerFactory
 *  Date: 27 March 2022
 * */

import za.ac.cput.domain.Managers;

public class ManagerFactory {

    public static Managers createManager(String ManagerID, String firstname, String surname, String Age, String ContactNumber) {

        if (ManagerFactory.Validation.isEmptyString(ManagerID)) return null;
        if (ManagerFactory.Validation.isEmptyString(firstname)
                || ManagerFactory.Validation.isEmptyString(surname)
                || ManagerFactory.Validation.isEmptyString(Age)
                || ManagerFactory.Validation.isEmptyString(ContactNumber))
            return null;


        return new Managers.Builder()
                .setManagerID(ManagerID)
                .setFirstname(firstname)
                .setSurname(surname)
                .setAge(Age)
                .setContactNumber(ContactNumber)
                .build();

    }

    public static class Validation {

        public static boolean isEmptyString(String s) {
            return s == null || s.equals("") || s.isEmpty() || s.equalsIgnoreCase("null");

        }

        public static boolean isEmptyInt(int i) {
            return i == 0;
        }


    }

}
