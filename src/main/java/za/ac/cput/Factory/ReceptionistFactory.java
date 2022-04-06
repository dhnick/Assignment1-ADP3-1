package za.ac.cput.Factory;
/*
    ReceptionistFactory.java
    Entity for ReceptionistFactory
    Author: Jody Heideman (219307725)
    Date: 27/03/2022
 */
import za.ac.cput.Domain.Delivery;
import za.ac.cput.Domain.Receptionist;

public class ReceptionistFactory {

    public static Receptionist createReceptionist(int receptionistID , int receptionistTime , int numberOfPeople , String createReservation)
    {
        if(DeliveryFactory.Validation.isEmptyString(createReservation)) return null;
        if(DeliveryFactory.Validation.isEmptyInt(receptionistID) || DeliveryFactory.Validation.isEmptyInt(receptionistTime) || DeliveryFactory.Validation.isEmptyInt(numberOfPeople))
            return null;

        return new Receptionist.Builder()
                .setReceptionistID(receptionistID)
                .setReceptionistTime(receptionistTime)
                .setNumberOfPeople(numberOfPeople)
                .setCreateReservation(createReservation)
                .build();


    }
}
