package za.ac.cput.Repository;

import za.ac.cput.Domain.Meal;
import java.util.Set;

public interface IMealRepository extends IRepository<Meal, String> {

    public Set<Meal> getAll();
}
