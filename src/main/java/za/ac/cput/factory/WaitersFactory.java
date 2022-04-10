package za.ac.cput.factory;

import za.ac.cput.domain.Waiters;

public class WaitersFactory {

    public static Waiters createWaiter(String staffID, String firstname, String surname, String contactNumber) {

        if (WaitersFactory.Validation.isEmptyString(staffID)) return null;
        if (WaitersFactory.Validation.isEmptyString(firstname)
                || WaitersFactory.Validation.isEmptyString(surname)
                || WaitersFactory.Validation.isEmptyString(contactNumber))
            return null;


        return new Waiters.Builder()
                .setStaffID(staffID)
                .setFirstname(firstname)
                .setSurname(surname)
                .setContactNumber(contactNumber)
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
