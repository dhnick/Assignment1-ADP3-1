package za.ac.cput.factoryTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Chef;
import za.ac.cput.factory.chefFactory;


import static org.junit.jupiter.api.Assertions.*;

class chefFactoryTest {
    @Test
    public void test(){
        Chef chef = chefFactory.createChef( "Sma25","Smangele", "female", 120000, "cooking");
        assertNotNull(chef);
}
}