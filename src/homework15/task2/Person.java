package homework15.task2;

 /*2. Создайте класс Person с полями: имя, фамилия, год рождения. Реализуйте у этого класса паттерн Строитель.
 Введите поля с клавиатуры и заполните объект класса Person с помощью паттерна Строитель.
 */

public class Person {

    private String name;
    private String surname;
    private int yearOfBirth;

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

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
}
