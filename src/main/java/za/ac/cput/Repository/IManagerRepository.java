package za.ac.cput.Repository;

import za.ac.cput.Domain.Managers;

import java.util.Set;


public interface IManagerRepository extends IRepository<Managers, String> {



    public Set<Managers> getAll();
}
