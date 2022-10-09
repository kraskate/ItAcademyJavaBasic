package homework7.task3;

public abstract class Payment {
    private double rate;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public abstract String getJobTitle();

    public abstract String getMethodOfPayment();


}
