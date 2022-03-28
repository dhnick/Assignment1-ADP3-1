package za.ac.cput.smallprogram;

/*
    ArraySearchingTest.java
    Test for ArraySearching class
    Author: Jody Heideman (219307725)
    Date: 27/03/2022
 */

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class ArraySearchingTest
{
    private int[] evenNumbersArray = {2 , 4 , 6 , 8};
    ArraySearching max , min , sum;

    @Test
    public void testMax()
    {
        max  = new ArraySearching();

        int result = max.findMax(evenNumbersArray);

        assertEquals(8 , result);

    }
    @Test
    public void testMin(){

        min = new ArraySearching();
        int result = min.findMin(evenNumbersArray);

        assertEquals(2 , result);

    }
    @Test
    public void testSum(){
        sum = new ArraySearching();
        int result = sum.findSum(evenNumbersArray);
        assertEquals(20 , result);
    }
    }
