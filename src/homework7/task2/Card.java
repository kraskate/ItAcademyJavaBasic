package homework7.task2;

public abstract class Card {
    private double account;

    public abstract String getName();

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }

    public void pay(int sumForPay) {
        if (sumForPay <= this.account) {
            System.out.println("Оплата прошла успешно. Оплачено " + sumForPay);
            this.account -= sumForPay;
        } else {
            System.out.println("Недостаточно средств");
        }
    }
}
