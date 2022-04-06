package za.ac.cput.DomainTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Chef;
import za.ac.cput.Domain.Meal;

import static org.junit.jupiter.api.Assertions.*;

class ChefTest {

    @Test
    public void test(){

    Chef chef = new Chef.Builder().setChefID("Sma25")
            .setChefName("Smangele")
            .setChefGender("Female")
            .setChefSalary(12000)
            .setMealStatus("Cooking")
            .build();
    System.out.println(chef);
    }


}