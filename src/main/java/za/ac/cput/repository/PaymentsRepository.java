package za.ac.cput.repository;

import za.ac.cput.domain.Payments;

import java.util.HashSet;
import java.util.Set;
//chulumano buhle Nkwinda
//219390983
//adp3
public class PaymentsRepository implements IPaymentsRepository{

    private static PaymentsRepository repository = null;
    private Set<Payments> paymentsDB = null;

    private PaymentsRepository(){
        paymentsDB = new HashSet<Payments>();
    }
    public static PaymentsRepository getRepository(){
        if (repository== null){
          repository = new PaymentsRepository();
        }
        return repository;

    }


    @Override
    public Payments create(Payments payments) {
        this.paymentsDB.add(payments);
        return payments;
    }

    @Override
    public Payments read(String paymentID) {
        for(Payments p : paymentsDB){
            if((p.getPaymentID().equals(paymentID))){
                return p;
            }
        }
        return null;

    }

    @Override
    public Payments update(Payments payments) {
        Payments payments1 = (Payments) read(payments.getPaymentID());
        if(payments != null){
            paymentsDB.remove(payments1);
            paymentsDB.add(payments);
            return payments;
        }
        return null;
    }

    @Override
    public void delete(String paymentID) {
        Object deletePayments = read(paymentID);
        if (deletePayments != null){
            System.out.println("null");
        }
        paymentsDB.remove(deletePayments);
        System.out.println("REMOVED");
    }
    @Override
    public Set<Payments> getAll() {
        return paymentsDB;
    }
}
