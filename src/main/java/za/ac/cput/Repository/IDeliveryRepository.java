package za.ac.cput.Repository;

import za.ac.cput.Domain.Delivery;


import java.util.Set;

public interface IDeliveryRepository extends IRepository<Delivery, String>{

    public Set<Delivery> getAll();

}
