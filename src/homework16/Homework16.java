package homework16;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Homework16 {

    public static void main(String[] args) {

    /*1. Напишите программу, которая для всех четных значений длиной от 1 до 20 дюймов:
    - печатает на экран значения в дюймах;
    - переводит значения в сантиметры;
    - печатает на экран сумму в сантиметрах.
     */

        System.out.println("----- Task 1 -----");

        IntStream stream1 = IntStream.range(1, 21).filter(value -> value % 2 == 0);
        int[] stream = stream1.toArray();

        double sum = 0;

        for (int e : stream) {
            System.out.println(e + " inch = " + e * 2.54 + " cm");
            sum += e * 2.54;
        }

        System.out.println("Sum = " + sum + " cm");


        /*2. Создайте класс Person с полями name, surname, age. Сгенерируйте группу из 100 человек в возрасте
        от 15 до 30. Напишите ОДНУ НЕПРЕРЫВНУЮ цепочку stream вызовов, которая:
 выбирает объекты, возраст которых меньше 21;
 распечатывает их на экран;
 сортирует по фамилии, а потом по имени (использовать thenComparing у объекта Comparator);
 берет 4 первых объекта;
 формирует коллекцию из фамилий объектов;
 агрегирует все в коллекцию.
          */

        System.out.println("\n----- Task 2 -----");

        Random random = new Random();

        List<Person> personArray = new ArrayList<Person>();

        for (int i = 0; i < 100; i++) {
            personArray.add(new Person("Name" + random.nextInt(100),
                    "Surname" + random.nextInt(100), (int) (Math.random() * 15 + 15)));
        }

        List<String> stream2 = personArray.stream()
                .filter(person -> person.getAge() < 21)
                .peek(person -> System.out.println(person.getName() + " " + person.getSurname() + " - " +
                        person.getAge() + " years old"))
                .sorted(Comparator.comparing(Person::getSurname).thenComparing(Person::getName))
                .limit(4)
                .map(Person::getSurname)
                .collect(Collectors.toList());

        System.out.println(stream2);


        /*3. Сгенерируйте List коллекцию целых чисел из n элементов от minValue до maxValue. Определить, содержатся ли
        в данной коллекции числа, которые делятся и на 3, и на 5 с помощью stream.
         */

        System.out.println("\n----- Task 3 -----");

        List<Integer> list = new ArrayList<Integer>();

        int minValue = 10;
        int maxValue = 35;

        for (int i = minValue; i <= maxValue; i++) {
            list.add(i);
        }

        boolean stream3 = list.stream()
                .anyMatch(element -> element % 3 == 0 && element % 5 == 0);

        System.out.println(stream3);

    }
}
