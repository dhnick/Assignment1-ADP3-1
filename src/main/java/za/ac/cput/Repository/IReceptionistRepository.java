package za.ac.cput.Repository;

import za.ac.cput.Domain.Receptionist;

import java.util.Set;

public interface IReceptionistRepository extends IRepository<Receptionist , String>{

    public Set<Receptionist> getAll();
}
