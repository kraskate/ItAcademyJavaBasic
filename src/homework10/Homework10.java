package homework10;

import java.util.Objects;
import java.util.Scanner;

public class Homework10 {

    public static void main(String[] args) {

        /* 1. Написать код, который выбрасывает NullPointerException. Написать обработчик этого исключения и
        вывести на экран сообщение, которое будет содержать описание данного исключения.
         */

        System.out.println("\n***** Task 1 *****");

        try {
            method1();
        } catch (NullPointerException e) {
            System.out.println("Caught NPE: " + e);
        } finally {
            System.out.println("Finally");
        }


        /* 2. Написать собственное исключение от Exception. Сгенерировать код, который будет выбрасывать его и
        обрабатывать. Результат работы программы вывести на экран.
        */

        System.out.println("\n***** Task 2 *****");

        try {
            throw new MyException();
        } catch (MyException e) {
            System.out.println("Caught ME: " + e);
        } finally {
            System.out.println("Finally");
        }


        /* 3. Написать метод, который будет возбуждать исключение и обработать это исключение на уровне выше.
        Результат работы программы вывести на экран.
         */

        System.out.println("\n***** Task 3 *****");

        try {
            method3();
        } catch (MyException e) {
            System.out.println("Caught ME: " + e);
        } finally {
            System.out.println("Finally");
        }

    }

    public static void method1() {

        Object obj = null;
        System.out.println(obj.toString());
    }

    public static void method3() throws MyException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Guess my name: ");
        String name = sc.nextLine();

        if (Objects.equals(name, "Kate")) {
            System.out.println("You're right!");
        } else {
            throw new MyException();
        }
    }

}
