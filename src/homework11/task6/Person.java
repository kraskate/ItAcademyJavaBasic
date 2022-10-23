package homework11.task6;

import java.io.Serializable;

public class Person implements Serializable {

    private String surname;
    private String name;
    private int age;

    public Person(String surname, String name, int age) {
        this.surname = surname;
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return surname + " " + name + " - " + age + " age old";
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

}
