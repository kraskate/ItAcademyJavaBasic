package homework7.task2;

public class Installment extends CreditCard {
    @Override
    public String getName() {
        return "Карта рассрочки";
    }

    @Override
    public double sumForPay(int period, double percent) {
        sumForPay = expens / period;
        return sumForPay;
    }


}
