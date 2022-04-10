package za.ac.cput.repository;
/*
    DeliveryRepository.java
    Entity for DeliveryRepository
    Author: Jody Heideman (219307725)
    Date: 06/03/2022
 */

import za.ac.cput.domain.Delivery;

import java.util.HashSet;
import java.util.Set;

public class DeliveryRepository implements IDeliveryRepository{

    private static DeliveryRepository repository = null;
    private Set<Delivery> deliveryDB = null;

    private DeliveryRepository(){
        deliveryDB = new HashSet<Delivery>();
    }

    public static DeliveryRepository getRepository() {
        if (repository == null)
            repository = new DeliveryRepository();
        return repository;

    }

    @Override
    public Delivery create(Delivery delivery) {
        boolean success = deliveryDB.add(delivery);
        if(!success)
            return null;
        return delivery;
    }

    @Override
    public Delivery read(String deliveryID) {
        for (Delivery d : deliveryDB) {
            if (d.getDeliveryID() == deliveryID) {
                return d;

            }
        }

        return null;
    }

    @Override
    public Delivery update(Delivery delivery) {
        Delivery oldDelivery = read(delivery.getDeliveryID());
        if(oldDelivery !=null){
            deliveryDB.remove(oldDelivery);
            deliveryDB.add(delivery);
            return delivery;
        }
        return null;
    }

    @Override
    public void delete(String deliveryID) {
        Delivery deliveryToDelete = read(deliveryID);
        if(deliveryToDelete == null){
            System.out.println("Delivery is null ");
        }else{
            deliveryDB.remove(deliveryToDelete);
            System.out.println("Delivery deleted ");
        }

    }

    @Override
    public Set<Delivery> getAll() {
        return deliveryDB;
    }
}
