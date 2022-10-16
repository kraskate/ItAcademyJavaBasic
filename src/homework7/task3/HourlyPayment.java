package homework7.task3;

public class HourlyPayment extends Payment {
    protected int workDaysInMonth;
    protected double salary;

    public void setWorkDaysInMonth(int workDaysInMonth) {
        this.workDaysInMonth = workDaysInMonth;
    }

    @Override
    public String getJobTitle() {
        return "* Рабочий *";
    }

    @Override
    public String getMethodOfPayment() {
        return "- Почасовая оплата -";
    }

    public double pay(int hoursWorked) {
        System.out.println("Ставка: " + getRate() + "\n" + hoursWorked + " рабочих часов в текущем месяце");
        salary = (getRate() / workDaysInMonth / 8) * hoursWorked;
        return salary;
    }

}
