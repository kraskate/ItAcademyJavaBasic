package homework7;

import homework7.task1.Fridge;
import homework7.task1.Kettle;
import homework7.task1.WashingMachine;
import homework7.task2.*;
import homework7.task3.HourlyPayment;
import homework7.task3.MixPayment;
import homework7.task3.PercentPayment;

import java.sql.SQLOutput;

public class Homework7 {
    public static void main(String[] args) {

        /*1. Создать цепочку наследования (минимум 3 звена) классов, описывающих бытовую технику.
        Создать несколько объектов описанных классов, часть из них включить в розетку.
        Иерархия должна иметь хотя бы три уровня. */

        System.out.println("------Task 1------");

        Fridge fridge = new Fridge(0.4, 0.65);
        System.out.println(fridge.getname());
        fridge.plugIn();
        fridge.calculateCurrent();
        fridge.printState();

        WashingMachine washingMachine = new WashingMachine(1.2, 0.75);
        System.out.println(washingMachine.getname());
        washingMachine.unPlag();
        washingMachine.calculateCurrent();
        washingMachine.printState();

        Kettle kettle = new Kettle(2.1, 0.98);
        System.out.println(kettle.getname());
        kettle.plugIn();
        kettle.calculateCurrent();
        kettle.printState();

        System.out.println();

        /*2. Создать цепочку наследования (минимум 3 звена) классов, описывающих банковские карточки.
        Иерархия должна иметь хотя бы три уровня.*/

        System.out.println("------Task 2------");

        Salary salary = new Salary();
        System.out.println(salary.getName());
        salary.setAccount(100);
        System.out.println("На счете: " + salary.getAccount());
        salary.addSum(300);
        System.out.println("На счете после пополнения: " + salary.getAccount());
        salary.pay(240);
        System.out.println("На счете после оплаты: " + salary.getAccount());
        System.out.println();

        Installment installment = new Installment();
        System.out.println(installment.getName());
        installment.setAccount(100);
        System.out.println("На счете:  " + installment.getAccount());
        installment.expens = 400;
        System.out.println("Сумма расходов: " + installment.calculateExpences(200));
        System.out.println("Ежемесячный платеж: " + installment.sumForPay(6, 0));
        System.out.println();

        Credit credit = new Credit();
        System.out.println(credit.getName());
        credit.expens = 500;
        System.out.println("Сумма расходов: " + credit.calculateExpences(700));
        credit.sumForPay(12, 10);
        System.out.println();

        Accumulation accumulation = new Accumulation();
        System.out.println(accumulation.getName());
        accumulation.setAccount(100);
        System.out.println("На счете: " + accumulation.getAccount());
        accumulation.addSum(300, 10);
        accumulation.getAccount();
        System.out.println();

        /*3. Создать цепочку наследования (минимум 3 звена) классов, описывающих должностную структуру на заводе.
        Реализовать методы по начислению зарплаты в зависимости от должности (почасовая, процентная, смешанная).
        Иерархия должна иметь хотя бы три уровня.
         */

        System.out.println("------Task 3------");

        HourlyPayment hourlyPayment = new HourlyPayment();
        hourlyPayment.setRate(1000);
        System.out.println(hourlyPayment.getJobTitle() + "\n" + hourlyPayment.getMethodOfPayment());
        hourlyPayment.setWorkDaysInMonth(20);
        System.out.println("Зарплата = " + hourlyPayment.pay(160));
        System.out.println();

        PercentPayment percentPayment = new PercentPayment();
        System.out.println(percentPayment.getJobTitle() + "\n" + percentPayment.getMethodOfPayment());
        System.out.println("Зарплата = " + percentPayment.pay(1700, 30));
        System.out.println();

        MixPayment mixPayment = new MixPayment();
        System.out.println(mixPayment.getJobTitle() + "\n" + mixPayment.getMethodOfPayment());
        mixPayment.setRate(2100);
        mixPayment.setWorkDaysInMonth(20);
        System.out.println("Зарплата = " + mixPayment.pay(160, 1100000, 1));
    }
}