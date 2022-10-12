package homework8;

import java.util.Objects;
import java.util.Scanner;

public class Homework8 {

    public static void main(String[] args) {

        /*1. Создать enum, который описывает сезоны года. Добавить поле description в этот enum.
        Добавить поле countOfDays в этот enum. Вывести на экран все константы сезоны года.
        */

        System.out.println("----- Task 1 -----");

        Seasons[] season = Seasons.values();

        for (Seasons element : season) {
            System.out.println(element + ": " + element.getDescription() + "; " + element.getCountOfDays() + " days");
        }

        /*2. Написать метод, который выводит следующий сезон от заданного во входном параметре.
        Входной параметр ввести с клавиатуры.
         */

        System.out.println("\n----- Task 2 -----");

        Seasons[] seasonOfYear = Seasons.values();
        int number = 0;

        do {
            System.out.println("Enter the season number from 1 to 4: ");
            Scanner sc = new Scanner(System.in);

            number = sc.nextInt();

            if (number > 0 && number <= 4) {

                if (number < 4) {
                    System.out.println("The next season is: " + seasonOfYear[number]);
                } else {
                    System.out.println("The next season is: " + seasonOfYear[0]);
                }

            } else {
                System.out.println("Incorrect number. There are 4 seasons of year");
            }

        } while (number < 1 || number > 4); //исключаем некорректный ввод


        /*3. Написать метод, который в зависимости от сезона выводит на экран сумму дней в этом сезоне.
        Входной параметр ввести с клавиатуры.*/

        System.out.println("\n----- Task 3 -----");

        Scanner in = new Scanner(System.in);

        String name = "";

        while (!Objects.equals(name, "WINTER") && !Objects.equals(name, "SPRING") &&
                !Objects.equals(name, "SUMMER") && !Objects.equals(name, "AUTUMN")) {

            System.out.println("Enter the season name (using CapsLock and Eng): ");
            name = in.nextLine();

        }

        Seasons nameOfSeason = Seasons.valueOf(name);

        System.out.println("There are " + nameOfSeason.getCountOfDays() + " days in " + name);


        /*4. Создать классы Car и Motorcycle, которые наследуются от общего класса Vehicle.
        Создать поле name в классе Vehicle и проинициализировать его через конструктора.
        Создать generic класс Garage, который может хранить только объекты типа наследуемого от Vehicle.
        Создать 2 объекта класса Garage (все поля ввести с клавиатуры) и вывести на экран
        имя хранимого транспортного средства.*/

        System.out.println("\n----- Task 4 -----");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the name for Car: ");
        Car obj1 = new Car(sc.nextLine());

        System.out.println("Enter the name for Motorcycle: ");
        Motorcycle obj2 = new Motorcycle(sc.nextLine());

        Garage<Car> vehicle1 = new Garage<>(obj1);
        Garage<Motorcycle> vehicle2 = new Garage<>(obj2);

        System.out.println("The name is " + vehicle1.transport.getName());
        System.out.println("The name is " + vehicle2.transport.getName());

    }

}
