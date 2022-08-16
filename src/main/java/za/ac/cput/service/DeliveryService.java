package za.ac.cput.service;
/*
    DeliveryService.java
    Entity for DeliveryService
    Author: Jody Heideman (219307725)
    Date: 14/08/2022
*/

import za.ac.cput.domain.Delivery;
import za.ac.cput.repository.DeliveryRepository;

import java.util.List;
import java.util.Optional;

public class DeliveryService implements IDeliveryService{

    private final DeliveryRepository repository;
    private static IDeliveryService service;


    private DeliveryService(){
        this.repository = DeliveryRepository.getRepository();
    }

    public static IDeliveryService getService() {
        if (service == null)
            service = new DeliveryService();
        return service;

    }

    public Delivery save(Delivery delivery) {
       return this.repository.save(delivery);
        }


    public Optional<Delivery> read(String s) {
        return this.repository.read(s);
    }

    public void delete(Delivery delivery) {
        this.repository.delete(delivery);
    }


    public List<Delivery> getAll() {
        return this.repository.getAll();
    }
}
