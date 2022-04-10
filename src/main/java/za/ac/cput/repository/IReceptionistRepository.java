package za.ac.cput.repository;

import za.ac.cput.domain.Receptionist;

import java.util.Set;

public interface IReceptionistRepository extends IRepository<Receptionist , String>{

    public Set<Receptionist> getAll();
}
