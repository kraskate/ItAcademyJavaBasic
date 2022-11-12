package homework15.task2;

 /*2. Создайте класс Person с полями: имя, фамилия, год рождения. Реализуйте у этого класса паттерн Строитель.
 Введите поля с клавиатуры и заполните объект класса Person с помощью паттерна Строитель.
 */

public class PersonBuilder {

    Person person = new Person();

    public Person getPerson() {
        return person;
    }

    public void buildName(String name) {
        person.setName(name);
    }

    public void buildSurname(String surname) {
        person.setSurname(surname);
    }

    public void buildYearOfBirth(int yearOfBirth) {
        person.setYearOfBirth(yearOfBirth);
    }


}
