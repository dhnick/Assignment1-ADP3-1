package za.ac.cput.Repository;

import za.ac.cput.Domain.Chef;

import java.util.Set;

public interface IChefRepository extends IRepository<Chef, String> {

public Set<Chef> getAll();
}
