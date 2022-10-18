package za.ac.cput.repository;
/*
    DeliveryRepository.java
    Entity for DeliveryRepository
    Author: Jody Heideman (219307725)
    Date: 06/03/2022
 */

import za.ac.cput.domain.Delivery;

import java.util.*;

public class DeliveryRepository {

    private final List<Delivery> deliveryList;
    private static DeliveryRepository repository;


    private DeliveryRepository(){
        this.deliveryList = new ArrayList<>();
    }

    public static DeliveryRepository getRepository() {
        if (repository == null)
            repository = new DeliveryRepository();
        return repository;

    }

    public Delivery save(Delivery delivery) {

        Optional<Delivery> read = read(delivery.getDeliveryID());
        if(read.isPresent()){
            delete(read.get());
        }
        this.deliveryList.add(delivery);
        return delivery;
    }

    public Optional<Delivery> read(String deliveryID) {
        return this.deliveryList.stream().filter(c-> c.getDeliveryID().equalsIgnoreCase(deliveryID))
                .findFirst();
    }

    public void delete(Delivery delivery) {
        this.deliveryList.remove(delivery);
    }


    public List<Delivery> getAll() {
        return this.deliveryList;
    }
}
