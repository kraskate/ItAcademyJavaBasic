package homework15.task2;

 /*2. Создайте класс Person с полями: имя, фамилия, год рождения. Реализуйте у этого класса паттерн Строитель.
 Введите поля с клавиатуры и заполните объект класса Person с помощью паттерна Строитель.
 */

public class Director {

    private PersonBuilder creator = new PersonBuilder();

    public Person create(String name, String surname, int yearOfBirth) {

        creator.buildName(name);
        creator.buildSurname(surname);
        creator.buildYearOfBirth(yearOfBirth);

        return creator.getPerson();

    }

}
