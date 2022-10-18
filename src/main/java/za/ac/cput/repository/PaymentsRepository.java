package za.ac.cput.repository;

import za.ac.cput.domain.Payments;
import za.ac.cput.domain.Tables;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/* PaymentsRepository.Java
 *  Entity for Payments
 *  Author: Chulumanco Buhle Nkwindana (219390983)
 *  Date: 29 March 2022
 * */
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

    public List<Payments> findPaymentId(String paymentID) {
            return this.paymentsDB.stream().filter( g -> g.getPaymentID().equalsIgnoreCase(paymentID))
                    .collect(Collectors.toList());
        }
    }

