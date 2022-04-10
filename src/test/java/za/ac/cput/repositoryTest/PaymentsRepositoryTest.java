package za.ac.cput.repositoryTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Payments;
import za.ac.cput.factory.PaymentsFactory;
import za.ac.cput.repository.PaymentsRepository;

import static org.junit.jupiter.api.Assertions.*;
//chulumano buhle Nkwinda
//219390983
//adp3
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PaymentsRepositoryTest {

    private static PaymentsRepository repository = PaymentsRepository.getRepository();
    private static Payments payments = PaymentsFactory.createPayments("42252","cash","added","R200","updated","canceled","215522");

    @Order(1)
    @Test
    void create(){
        Payments created = repository.create(payments);
        System.out.println("created"+ created);
    }
    @Order(2)
@Test
void read(){
        Payments read = repository.read(payments.getPaymentID());
        System.out.println("read"+ read);

    }
    @Order(3)
    @Test
    void update(){
        Payments updatePayments = new Payments.PaymentsBuilder()
                .copy(payments)
                .setUpdatePayment("updated payment").
                setAddPayment("added payment").
                setUpdatePayment("updated payment").
                setPaymentID("3652558").setCancelPayment("canceled payment")
                .setAmount("R2000") .setAddPayment("added").setCustomerID("218558").build();
        System.out.println("updated payment"+ updatePayments);

    }
    @Order(4)
    @Test
    void delete(){
        repository.delete(payments.getPaymentID());
        assertNotNull(repository);
    }
    @Order(5)
    @Test
    void getALl(){
        System.out.println("payments"+ repository.getAll());
    }
}