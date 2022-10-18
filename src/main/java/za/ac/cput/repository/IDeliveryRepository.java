package za.ac.cput.repository;
/*
    IDeliveryRepository.java
    Author: Jody Heideman (219307725)
    Date: 06/03/2022
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Delivery;


import java.util.Set;

@Repository
public interface IDeliveryRepository extends JpaRepository<Delivery, String> {
}
