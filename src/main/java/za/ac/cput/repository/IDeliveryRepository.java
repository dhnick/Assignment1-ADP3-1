package za.ac.cput.repository;
/*
    IDeliveryRepository.java
    Author: Jody Heideman (219307725)
    Date: 06/03/2022
 */
import za.ac.cput.domain.Delivery;


import java.util.Set;

public interface IDeliveryRepository extends IRepository<Delivery, String>{

    public Set<Delivery> getAll();

}
