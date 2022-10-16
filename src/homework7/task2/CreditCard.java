package homework7.task2;

public abstract class CreditCard extends Card {
    @Override
    public String getName() {
        return "Кредитная карта";
    }

    public double expens;
    public double sumForPay;

    public double calculateExpences(int expens) {
        return this.expens += expens;
    }

    public abstract double sumForPay(int period, double percent);
}
