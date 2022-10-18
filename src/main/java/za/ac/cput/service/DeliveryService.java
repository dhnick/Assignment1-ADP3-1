package za.ac.cput.service;
/*
    DeliveryService.java
    Entity for DeliveryService
    Author: Jody Heideman (219307725)
    Date: 14/08/2022
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Delivery;
import za.ac.cput.repository.IDeliveryRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DeliveryService implements IDeliveryService{
    @Autowired
      public IDeliveryRepository repository;
    private static IDeliveryService service;


    public static IDeliveryService getService() {
        if (service == null)
            service = new DeliveryService();
        return service;

    }
    @Override
    public Delivery save(Delivery delivery) {
       return repository.save(delivery);

        }

    @Override
    public Delivery read(String deliveryId) {
        return this.repository.findById(deliveryId).orElseGet(null);
    }

    @Override
    public Delivery update(Delivery deliveryId)
    {
        if(this.repository.existsById(deliveryId.getDeliveryID()))
        {
            return this.repository.save(deliveryId);
        }

        return null;
    }
    @Override
    public boolean delete(String deliveryId) {
        this.repository.deleteById(deliveryId);

        if(this.repository.existsById(deliveryId)){
            return false;
        }
        return true;
    }

    @Override
    public Set<Delivery> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}
