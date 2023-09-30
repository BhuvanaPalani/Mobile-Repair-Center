public class Payment {
    public int paymentId;
    public int repairJobId;
    public int amount;
    public String method;
    public String paymentStatus;

    public Payment(int paymentId, int repairJobId, int amount, String method, String paymentStatus) {
        this.paymentId = paymentId;
        this.repairJobId = repairJobId;
        this.amount = amount;
        this.method = method;
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", repairJobId=" + repairJobId +
                ", amount=" + amount +
                ", method='" + method + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                '}';
    }
}


