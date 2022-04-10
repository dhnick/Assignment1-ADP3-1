package za.ac.cput.domain;

//chulumano buhle Nkwinda
//219390983
//adp3



public class Payments {
    private String paymentID;
    private String customerID;
    private String paymentType;
    private String addPayment;
    private String amount;
    private String updatePayment;
    private String cancelPayment;



    public Payments(PaymentsBuilder payments) {


        this.paymentID = payments.paymentID;
        this.customerID = payments.customerID;
        this.paymentType = payments.paymentType;
        this.addPayment = payments.addPayment;
        this.amount = payments.amount;
        this.updatePayment = payments.updatePayment;
        this.cancelPayment = payments.cancelPayment;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public String getAddPayment() {
        return addPayment;
    }

    public String getAmount() {
        return amount;
    }

    public String getUpdatePayment() {
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
        private String paymentID;
        private String customerID;
        private String paymentType;
        private String addPayment;
        private String amount;
        private String updatePayment;
        private String cancelPayment;

        public PaymentsBuilder setPaymentID(String paymentID) {
            this.paymentID = paymentID;
            return this;
        }

        public PaymentsBuilder setCustomerID(String customerID) {
            this.customerID = customerID;
            return this;
        }

        public PaymentsBuilder setPaymentType(String paymentType) {
            this.paymentType = paymentType;
            return this;
        }

        public PaymentsBuilder setAddPayment(String addPayment) {
            this.addPayment = addPayment;
            return this;
        }

        public PaymentsBuilder setAmount(String amount) {
            this.amount = amount;
            return this;
        }

        public PaymentsBuilder setUpdatePayment(String updatePayment) {
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