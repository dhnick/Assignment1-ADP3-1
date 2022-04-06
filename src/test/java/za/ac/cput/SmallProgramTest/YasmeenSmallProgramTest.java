package za.ac.cput.SmallProgramTest;
/* YasmeenSmallProgramTest.Java
 *  Author: Yasmeen Nel (219250553)
 *  Date: 29 March 2022
 * */
import org.junit.jupiter.api.*;
import za.ac.cput.SmallProgram.YasmeenSmallProgram;
import java.util.concurrent.TimeUnit;

/* Author Yasmeen Nel - 219250553 */

public class YasmeenSmallProgramTest {

    public YasmeenSmallProgramTest(){
    }
    private YasmeenSmallProgram student1;
    private YasmeenSmallProgram student2;
    private YasmeenSmallProgram student3;


    @BeforeAll
    public static void setUpClass() {

    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        student1 = new YasmeenSmallProgram();
        student2 = new YasmeenSmallProgram();
        student3 = student2;
    }

    @AfterEach
    public void tearDown()
    {
    }

    /**
     * Testing for object identity
     */

    @Test
    public void testIdentity() {
        Assertions.assertSame(student2,student3);
        System.out.println("testidentity has passed.");
    }

    /**
     * Testing for object equality
     */

    @Test
    public void testEquality() {
        Assertions.assertEquals(student2,student3);
        System.out.println("testEquality has passed");
    }

    /**
     * Testing for Failure
     */

    @Test
    public void testFailure(){
        Assertions.fail("This test must fail.");
    }

    /**
     * Testing timeout after 1000 milliseconds
     */
    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    void testTimeout() {
        System.out.println("Timeout has passed");
    }

    /**
     * Test for Disabling a test
     */

    @Disabled
    @Test
    public void testDisable(){
        System.out.println("This test will be disabled");
    }
}
