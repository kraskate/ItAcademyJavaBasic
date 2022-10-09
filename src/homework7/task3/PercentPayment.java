package homework7.task3;

public class PercentPayment extends HourlyPayment {

    @Override
    public String getJobTitle() {
        return "* Менеджер продаж *";
    }

    @Override
    public String getMethodOfPayment() {
        return "- Процентная оплата от суммы продаж -";
    }

    public double pay(double salesAmount, int percent) {
        System.out.println("Сумма продаж за текущий месяц: " + salesAmount);
        salary = salesAmount * (percent / 100.0);
        return salary;
    }

}
