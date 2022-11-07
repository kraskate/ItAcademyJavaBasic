package homework16;

        /*2. Создайте класс Person с полями name, surname, age. Сгенерируйте группу из 100 человек в возрасте
        от 15 до 30. Напишите ОДНУ НЕПРЕРЫВНУЮ цепочку stream вызовов, которая:
 выбирает объекты, возраст которых меньше 21;
 распечатывает их на экран;
 сортирует по фамилии, а потом по имени (использовать thenComparing у объекта Comparator);
 берет 4 первых объекта;
 формирует коллекцию из фамилий объектов;
 агрегирует все в коллекцию.
          */

public class Person {

    String name;
    String surname;
    int age;

    public Person() {
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
