package za.ac.cput.FactoryTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Meal;
import za.ac.cput.factory.mealFactory;

import static org.junit.jupiter.api.Assertions.*;

class mealFactoryTest {

    @Test
  public void test(){
        Meal meal = mealFactory.createMeal( "Mac and Cheese","10011", 787, false, "cooking");
                assertNotNull(meal);
}
}