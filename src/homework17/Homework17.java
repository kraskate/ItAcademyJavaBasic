package homework17;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;

public class Homework17 {

    public static void main(String[] args) {

        /*1. Ввести с клавиатуры номер месяца текущего года. Вывести на экран все его даты в формате d::MMM::uuuu. */

        System.out.println("_____ Task 1 _____");

        Scanner scanner = new Scanner(System.in);

        int month = 0;

        //Проверка на корректность ввода
        do {
            System.out.println("Enter the number of current year's month: ");
            month = scanner.nextInt();
        } while (month < 1 || month > 12);

        LocalDate date = LocalDate.of(LocalDate.now().getYear(), month, 1); //установка первого дня указанного месяца

        int lastDayOfMonth = date.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();

        for (int i = 1; i <= lastDayOfMonth; i++) {
            System.out.println(date.format(DateTimeFormatter.ofPattern("d::MMM::uuuu")));
            date = date.plusDays(1);
        }


        /*2. От текущей даты вывести расписание всех встреч, которые происходят еженедельно в 13:00 в течение 2 месяцев.
         */

        System.out.println("\n_____ Task 2 _____");

        //встреча по средам в 13:00

        LocalDate d = LocalDate.now();

        while (d.isBefore(LocalDate.now().plusMonths(2).plusDays(1))) {
            if (d.getDayOfWeek().equals(DayOfWeek.WEDNESDAY)) {
                System.out.println(d + " - Meeting at 13:00");
            }
            d = d.plusDays(1);
        }


        /*3. От текущей даты вывести на экран дату, которая была 60 дней назад. */

        System.out.println("\n_____ Task 3 _____");

        LocalDate currentDate = LocalDate.now();

        System.out.println("Current date: " + currentDate);
        System.out.println("The date 60 days before: " + currentDate.minusDays(60));

    }
}
