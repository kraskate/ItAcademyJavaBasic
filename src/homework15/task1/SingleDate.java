package homework15.task1;

        /*1. Создайте простейший сервис с методом, который выводит на экран текущую дату. Сделайте его Singleton и
        используйте в основном теле программы.
         */

import java.util.Date;

public class SingleDate {

    private static Date date;

    SingleDate() {
    }

    public static synchronized void getDate() {

        if (date == null) {
            date = new Date();
        }

        System.out.println("Date = " + date.toString());
    }
}
