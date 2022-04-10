package za.ac.cput.factory;

import za.ac.cput.domain.Meal;
import za.ac.cput.util.Helper;
public class mealFactory {
    //Objects
    private String mealName;
    private String mealCode;
    private double mealPrice;
    private boolean isTakeAway;
    private String mealStatus;

    public static Meal createMeal(String mealName, String mealCode, double mealPrice, boolean isTakeAway, String mealStatus){
        if (Helper.isNullorEmpty(mealName) || Helper.isNullorEmpty(mealCode) || Helper.isNullorEmpty(mealStatus)) {
            return null;
        }

        return new Meal.Builder().setMealName(mealName)
             .setMealCode(mealCode)
             .setMealPrice(mealPrice)
             .setTakeAway(isTakeAway)
             .setMealStatus(mealStatus)
             .build();

    }

}


