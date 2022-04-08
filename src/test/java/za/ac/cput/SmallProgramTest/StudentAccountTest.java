/* StudentAccountTest.java
   Author Damone Hartnick(219093717)
   Date: April 2022
 */
package za.ac.cput.SmallProgramTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.SmallProgram.StudentAccount;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertSame;

public class StudentAccountTest {
    private StudentAccount x;
    private StudentAccount y;
    private StudentAccount z;

    public StudentAccountTest() {
    }


    @BeforeEach
    public void setUp() {

        x = new StudentAccount();
        y = new StudentAccount();
        x = y;

    }

    //Object Equality

    @Test
    public void testEquality() {
        assertEquals(y,x);
    }

    //Object Identity
    @Test
    public void testIdentity() {

        assertSame(x, y);
    }



    //Failing Test
    @Test
    public void failingTest() {
        fail("fail test");
        assertSame(x,y);

    }

    //test timeout pass
    //@Test
    //@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    public void testTimeout() {
        for (int i = 0; i <= 10; i++) {
            System.out.println("Pass");
        }
    }

    //Disable method
    @Disabled("Do not run in lower environment")
    @Test
    public void testOnDev() {
        System.setProperty("ENV", "DEV");
        //Assumptions.assumeFalse("DEV".equals(System.getProperty("ENV")));
    }







}
