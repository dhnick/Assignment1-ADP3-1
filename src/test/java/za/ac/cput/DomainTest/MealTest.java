package za.ac.cput.DomainTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Meal;

import static org.junit.jupiter.api.Assertions.*;

class MealTest {

    @Test
    public void test(){

Meal meal = new Meal.Builder().setMealName("Mac and Cheese")
        .setMealCode("10011")
        .setMealPrice(787)
        .setTakeAway(false)
        .setMealStatus("cooking")
        .build();
        System.out.println(meal);
    }

}