package za.ac.cput.DomainTest;
/*
    ReceptionistTest.java
    Test for Receptionist
    Author: Jody Heideman (219307725)
    Date: 27/03/2022
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Receptionist;


class ReceptionistTest {

    @Test
    public void Test(){

        Receptionist receptionist = new Receptionist.Builder()
                .setReceptionistID("481592637")
                .setReceptionistTime(1900)
                .setNumberOfPeople(5)
                .setCreateReservation("Table 5 booked for family of 5 at 19:00")
                .build();

        Receptionist receptionist1 = new Receptionist.Builder()
                .setReceptionistID("748159263")

                .build();

        System.out.println(receptionist.toString());
        System.out.println(receptionist1.toString());


    }

}