package homework15;

import homework15.task1.SingleDate;
import homework15.task2.Director;
import homework15.task2.Person;
import homework15.task3.Logger;

import java.util.Scanner;

public class Homework15 {

    public static void main(String[] args) {

        /*1. Создайте простейший сервис с методом, который выводит на экран текущую дату. Сделайте его Singleton и
        используйте в основном теле программы.
         */

        System.out.println("----- Task 1 -----");

        SingleDate.getDate();


        /*2. Создайте класс Person с полями: имя, фамилия, год рождения. Реализуйте у этого класса паттерн Строитель.
        Введите поля с клавиатуры и заполните объект класса Person с помощью паттерна Строитель.
         */

        System.out.println("\n----- Task 2 -----");

        Director director = new Director();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Name >> ");
        String name = scanner.nextLine();
        System.out.println("Surname >> ");
        String surname = scanner.nextLine();
        int yearOfBirth = 0;
        do {
            System.out.println("Year of birth >> ");
            yearOfBirth = scanner.nextInt();
        } while (yearOfBirth <= 0);

        Person person = director.create(name, surname, yearOfBirth);

        System.out.println(person.getName() + " " + person.getSurname() + " " + person.getYearOfBirth()); //тестовый вывод


        /*3.Создайте простейший логгер, выводящий сообщения об ошибках в текстовый файл. Объект логгера должен быть
        создан с помощью ШП Singleton. У объекта должен быть обязательным один метод, получающий на вход текст
        сообщения об ошибке и записывающий его в файл вместе с информацией о дате и времени происшествия.
         */

        System.out.println("\n----- Task 3 -----");

        Logger.printLogger("General mistake");

    }


}
