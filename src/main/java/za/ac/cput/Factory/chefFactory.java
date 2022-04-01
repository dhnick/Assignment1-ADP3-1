package za.ac.cput.Factory;

import za.ac.cput.Domain.Chef;
import za.ac.cput.util.Helper;

public class chefFactory {

    private String chefID;
    private String chefName;
    private String chefGender;
    private int chefSalary;
    private String mealStatus;

    public static Chef createChef(String chefID, String chefName, String chefGender, int chefSalary, String mealStatus){
        if (Helper.isNullorEmpty(chefID) || Helper.isNullorEmpty(chefName) || Helper.isNullorEmpty(chefGender) || Helper.isNullorEmpty(mealStatus))
            return null;
        return new Chef.Builder().setChefID(chefID)
                .setChefName(chefName)
                .setChefGender(chefGender)
                .setChefSalary(chefSalary)
                .setMealStatus(mealStatus)
                .build();

    }
}
