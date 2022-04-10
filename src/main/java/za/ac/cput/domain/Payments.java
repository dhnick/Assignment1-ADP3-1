package za.ac.cput.domain;



public class Payments {
    private int paymentID;
    private int customerID;
    private int paymentType;
    private int addPayment;
    private String amount;
    private int updatePayment;
    private String cancelPayment;

    public Payments() {
    }

    public Payments(PaymentsBuilder payments) {


        this.paymentID = payments.paymentID;
        this.customerID = payments.customerID;
        this.paymentType = payments.paymentType;
        this.addPayment = payments.addPayment;
        this.amount = payments.amount;
        this.updatePayment = payments.updatePayment;
        this.cancelPayment = payments.cancelPayment;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getPaymentType() {
        return paymentType;
    }

    public int getAddPayment() {
        return addPayment;
    }

    public String getAmount() {
        return amount;
    }

    public int getUpdatePayment() {
        return updatePayment;
    }

    public String getCancelPayment() {
        return cancelPayment;
    }


    @Override
    public String toString() {
        return "Payments{" +
                "paymentID=" + paymentID +
                ", customerID=" + customerID +
                ", paymentType=" + paymentType +
                ", addPayment=" + addPayment +
                ", amount='" + amount + '\'' +
                ", updatePayment=" + updatePayment +
                ", cancelPayment='" + cancelPayment + '\'' +
                '}';
    }

    public static class PaymentsBuilder {
        private int paymentID;
        private int customerID;
        private int paymentType;
        private int addPayment;
        private String amount;
        private int updatePayment;
        private String cancelPayment;

        public PaymentsBuilder setPaymentID(int paymentID) {
            this.paymentID = paymentID;
            return this;
        }

        public PaymentsBuilder setCustomerID(int customerID) {
            this.customerID = customerID;
            return this;
        }

        public PaymentsBuilder setPaymentType(int paymentType) {
            this.paymentType = paymentType;
            return this;
        }

        public PaymentsBuilder setAddPayment(int addPayment) {
            this.addPayment = addPayment;
            return this;
        }

        public PaymentsBuilder setAmount(String amount) {
            this.amount = amount;
            return this;
        }

        public PaymentsBuilder setUpdatePayment(int updatePayment) {
            this.updatePayment = updatePayment;
            return this;
        }

        public PaymentsBuilder setCancelPayment(String cancelPayment) {
            this.cancelPayment = cancelPayment;
            return this;
        }


        public Payments build() {
            return new Payments(this);
        }


        public PaymentsBuilder copy(Payments payments) {
            this.paymentID = payments.paymentID;
            this.customerID = payments.customerID;
            this.paymentType = payments.paymentType;
            this.addPayment = payments.addPayment;
            this.amount = payments.amount;
            this.updatePayment = payments.updatePayment;
            this.cancelPayment = payments.cancelPayment;

            return this;
        }
    }
}