package za.ac.cput.FactoryTest;
/*
    ReceptionistFactoryTest.java
    Test for ReceptionistFactory class
    Author: Jody Heideman (219307725)
    Date: 27/03/2022
 */
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Delivery;
import za.ac.cput.Domain.Receptionist;
import za.ac.cput.Factory.DeliveryFactory;
import za.ac.cput.Factory.ReceptionistFactory;

import static org.junit.jupiter.api.Assertions.*;

class ReceptionistFactoryTest {

    @Test
    public void test(){

        Receptionist receptionist = ReceptionistFactory.createReceptionist(21930,1900,5,"Table 5 booked for family of 5 at 19:00");
        assertNotNull(receptionist);
        System.out.println(receptionist.toString());
    }
}