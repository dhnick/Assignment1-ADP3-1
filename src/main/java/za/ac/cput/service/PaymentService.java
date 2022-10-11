package za.ac.cput.service;

import za.ac.cput.domain.Payments;
import za.ac.cput.domain.Tables;
import za.ac.cput.repository.PaymentsRepository;


import java.util.List;
import java.util.Optional;

public class PaymentService implements IPaymentService{
    private final PaymentsRepository repository;
    private static IPaymentService SERVICE ;

    private PaymentService() {this.repository = PaymentsRepository.getRepository();}

    public static IPaymentService getService() {
        if ( SERVICE == null)
            SERVICE = new PaymentService();
        return SERVICE;
    }

    @Override
    public Payments save(Payments payments) {
        return this.repository.create(payments);
    }

    @Override
    public Optional<Payments> read(String s) {
        return Optional.ofNullable(this.repository.read(s));
    }

    @Override
    public void delete(Payments payments) {
        this.repository.delete(String.valueOf(payments));

    }

    @Override
    public List<Payments> getAll() {
        return (List<Payments>) this.repository.getAll();
    }

    @Override
    public List<Payments> findByPaymentId(String tableID) {
        return this.repository.findPaymentId(tableID);
    }


    @Override
    public void deleteById(String id) {
        Optional<Payments> payments = read(id);
        if(payments.isPresent()){
            delete(payments.get());
        }

    }

}
