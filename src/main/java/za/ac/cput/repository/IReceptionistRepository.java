package za.ac.cput.repository;
/*
    IReceptionistRepository.java
    Author: Jody Heideman (219307725)
    Date: 06/03/2022
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Receptionist;

import java.util.Set;
@Repository
public interface IReceptionistRepository extends JpaRepository<Receptionist , String> {

}
