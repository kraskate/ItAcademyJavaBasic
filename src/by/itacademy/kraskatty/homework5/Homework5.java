package by.itacademy.kraskatty.homework5;

import groovy.json.JsonOutput;

import java.util.Scanner;

public class Homework5 {

    public static void main(String[] args) {

    /*1. Создать класс описывающие промежуток времени. Сам промежуток в классе должен задаваться тремя свойствами:
    секундами, минутами, часами. Сделать методы для получения полного количества секунд в объекте,
    сравнения двух объектов (метод должен работать аналогично compareTo в строках).
    Создать два конструктора:  получающий общее количество секунд получающий часы, минуты и секунды по отдельности.
    Сделать метод для вывода данных. Прочее на ваше усмотрение.
     */

        System.out.println("- Task 1 -");
        int hour1 = 2;
        int minute1 = 25;
        int second1 = 36;
        int second2 = 8736;

        Time t1 = new Time(hour1, minute1, second1); //создаем два объекта
        Time t2 = new Time(second2);

        if (minute1 > 0 || hour1 > 0) { //переводим время объекта в секунды
            t1.setSec(t1.changeToSec(hour1, minute1, second1));
            t1.setMin(0);
            t1.setHour(0);
        }

        t1.compareTime(t2); //сравниваем два объекта

        System.out.print("Time 1: ");
        t1.printTime();
        System.out.print("Time 2: ");
        t2.printTime();

        /*2. Создать класс описывающие Банкомат. Набор купюр, находящихся в банкомате, должен задаваться тремя свойствами:
    количеством купюр номиналом 20, 50, 100. Сделать методы для добавления денег в банкомат.
    Сделать метод, снимающий деньги.
    С клавиатуры передается сумма денег. На экран – булевское значение (операция удалась или нет).
    При снятии денег метод должен выводить на экран каким количеством купюр и какого номинала выдается сумма.
    Создать конструктор с тремя параметрами – количеством купюр. Прочее – на ваше усмотрение.*/
        Scanner in = new Scanner(System.in);

        System.out.println("- Task 2 - ");

        Atm bank = new Atm(15, 30, 20);

        bank.addBanknote(2, 3, 7); //добавление в банкомат купюр

        System.out.print("Enter the sum: ");
        int sum = in.nextInt();

        if (sum == 0) {
            System.out.println("You don't need money");
        } else {
            System.out.println("The operation success: " + bank.isSuccess(sum));
        }

    }
}
