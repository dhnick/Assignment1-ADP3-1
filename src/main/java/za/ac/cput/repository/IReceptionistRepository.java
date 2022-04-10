package za.ac.cput.repository;
/*
    IReceptionistRepository.java
    Author: Jody Heideman (219307725)
    Date: 06/03/2022
 */
import za.ac.cput.domain.Receptionist;

import java.util.Set;

public interface IReceptionistRepository extends IRepository<Receptionist , String>{

    public Set<Receptionist> getAll();
}
