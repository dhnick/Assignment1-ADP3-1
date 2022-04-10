package za.ac.cput.repository;

import za.ac.cput.domain.Waiters;

import java.util.Set;

public interface IWaiterRepository extends IRepository<Waiters, String> {

    public Set<Waiters> getAll();
}
