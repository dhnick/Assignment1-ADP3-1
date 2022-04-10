package za.ac.cput.factory;

import za.ac.cput.domain.Payments;

import java.util.UUID;

public class PaymentsFactory {
    public static Payments build(int customerID, int paymentType, int addPayment, String amount, int updatePayment, String cancelPayment, int paymentID){
        if(customerID<0||paymentType<0||addPayment<0||updatePayment<=0||amount.isEmpty()||cancelPayment.isEmpty()){
            return null;
        }

        String tableID= UUID.randomUUID().toString();
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
