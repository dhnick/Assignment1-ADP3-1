package za.ac.cput.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.service.IPaymentService;
import za.ac.cput.service.ITableService;

public class PaymentsApi {
    public final IPaymentService paymentService;


    @Autowired
    public PaymentsApi ( IPaymentService paymentService){
        this.paymentService = paymentService;
    }

    public Payments save ( Payments payment) {
        try {
            if (paymentService.findByPaymentId(payment.getPaymentID()) != null)
            {
                return paymentService.save(payment);
            }

            else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Payment ID  not found , kindly create and save a payment");
            }

        } catch ( IllegalArgumentException ex ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Payment ID not found , kindly  create a table ");
        }

    }
}
