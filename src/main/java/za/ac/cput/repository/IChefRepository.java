package za.ac.cput.repository;

import za.ac.cput.domain.Chef;

import java.util.Set;

public interface IChefRepository extends IRepository<Chef, String> {

public Set<Chef> getAll();
}
