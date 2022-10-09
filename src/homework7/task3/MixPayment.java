package homework7.task3;

public class MixPayment extends PercentPayment {
    @Override
    public String getJobTitle() {
        return "* Директор *";
    }

    @Override
    public String getMethodOfPayment() {
        return "- Почасовая оплата + процент от дохода - ";
    }

    public double pay(int hoursWorked, double income, int percentOfIncome) {

        salary = super.pay(hoursWorked) + super.pay(income, percentOfIncome);
        return salary;
    }
}
