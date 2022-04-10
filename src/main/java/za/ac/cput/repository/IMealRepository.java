package za.ac.cput.repository;

import za.ac.cput.domain.Meal;
import java.util.Set;

public interface IMealRepository extends IRepository<Meal, String> {

    public Set<Meal> getAll();
}
