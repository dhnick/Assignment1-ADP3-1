package za.ac.cput.repository;

import za.ac.cput.domain.Managers;

import java.util.Set;


public interface IManagerRepository extends IRepository<Managers, String> {



    public Set<Managers> getAll();
}
