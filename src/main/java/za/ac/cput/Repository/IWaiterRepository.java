package za.ac.cput.Repository;

import za.ac.cput.Domain.Waiters;

import java.util.Set;

public interface IWaiterRepository extends IRepository<Waiters, String> {

    public Set<Waiters> getAll();
}
