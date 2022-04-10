package za.ac.cput.repository;
/* MealRepository.java
 * Author: Smangele Witness Mabaso (220047154)
 * Date: 6 April 2022
 */

import za.ac.cput.domain.Meal;
import java.util.HashSet;
import java.util.Set;

public class MealRepository implements IMealRepository{
    private static MealRepository repository = null;
    private Set<Meal> MealDB = null;

    private MealRepository() {
        MealDB = new HashSet<Meal>();
    }

    private static MealRepository getRepository() {
        if (repository == null){
            repository = new MealRepository();
        }
        return repository;
    }

    @Override
    public Meal create(Meal meal) {
        boolean success = MealDB.add(meal);
        if (!success)
            return null;
        return meal;
    }

    @Override
    public Meal read(String mealCode) {
        for (Meal e : MealDB){
            if (e.getMealCode().equals(mealCode))
                return e;
        }
        return  null;
    }

    @Override
    public Meal update(Meal meal) {
        Meal firstCustomer = read(meal.getMealCode());
        if (firstCustomer != null) {
            MealDB.remove(firstCustomer);
            MealDB.add(meal);
            return meal;
        }
        return null;
    }

    @Override
    public void delete(String mealCode) {
        Meal deleteMeal = read(mealCode);
        if (deleteMeal == null) {
            System.out.println("Meal is null");
        }
        MealDB.remove(deleteMeal);
        System.out.println("Meal successfully removed!");
    }

    @Override
    public Set<Meal> getAll() {
        return null;
    }
}