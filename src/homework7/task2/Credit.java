package homework7.task2;

public class Credit extends CreditCard {

    @Override
    public String getName() {
        return "Кредит";
    }

    @Override
    public double sumForPay(int period, double percent) {
        sumForPay = expens / period + (expens * (percent / 100)) / 12;
        System.out.println("Ежемесчный платеж: " + sumForPay);
        return sumForPay;
    }
}
