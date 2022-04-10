package za.ac.cput.factoryTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Payments;
import za.ac.cput.factory.PaymentsFactory;

import static org.junit.jupiter.api.Assertions.*;
//chulumano buhle Nkwinda
//219390983
//adp3
class PaymentsFactoryTest {

    @Test

    public  void test(){
        Payments payments = PaymentsFactory.createPayments("21551vfj" , "capitec","added","220","updated","canceled","500215");
        System.out.println(payments.toString());
        assertNotNull(payments);

    }

}