package za.ac.cput.factory;

import za.ac.cput.domain.Payments;
import za.ac.cput.util.Helper2;

import java.util.UUID;
//chulumano buhle Nkwinda
//219390983
//adp3
public class PaymentsFactory {
    public static Payments createPayments(String customerID, String paymentType, String  addPayment, String amount, String updatePayment, String cancelPayment, String paymentID){
        if(Helper2.isNotEmpty(paymentID)|| Helper2.isNotEmpty(customerID)||Helper2.isNotEmpty(paymentType)||Helper2.isNotEmpty(addPayment)||Helper2.isNotEmpty(amount)||Helper2.isNotEmpty(updatePayment)||Helper2.isNotEmpty(cancelPayment) )
            return null;



        return new Payments.PaymentsBuilder()

                .setPaymentID(paymentID)
                .setCustomerID(customerID)
                .setPaymentType(paymentType)
                .setAddPayment(addPayment)
                .setAmount(amount)
                .setUpdatePayment(updatePayment)
                .setCancelPayment(cancelPayment)
                .build();
    }
}
