package za.ac.cput.service;
/*
    IDeliveryService.java
    Entity for IDeliveryService
    Author: Jody Heideman (219307725)
    Date: 14/08/2022
*/

import za.ac.cput.domain.Delivery;

import java.util.List;

public interface IDeliveryService extends IService<Delivery, String>{

    List<Delivery> getAll();
}
