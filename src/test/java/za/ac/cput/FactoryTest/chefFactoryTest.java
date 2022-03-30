package za.ac.cput.FactoryTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Chef;
import za.ac.cput.Factory.chefFactory;


import static org.junit.jupiter.api.Assertions.*;

class chefFactoryTest {
    @Test
    public void test(){
        Chef chef = chefFactory.createChef( "Sma25","Smangele", "female", 120000, "cooking");
        assertNotNull(chef);
}
}