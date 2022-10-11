package za.ac.cput.service;

import za.ac.cput.domain.Payments;
import za.ac.cput.domain.Tables;

import java.util.List;

public interface IPaymentService extends IService<Payments, String>{
    List<Payments> getAll();
    List<Payments> findByPaymentId (String paymentID);
    void deleteById(String id);}

