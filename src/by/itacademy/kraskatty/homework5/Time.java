package by.itacademy.kraskatty.homework5;
public class Time {

    private Integer sec; //свойства класса
    private int min;
    private int h;

    public Time(int hour, int minute, int second) { //конструктор, получающий часы, минуты, секунды
        h = hour;
        min = minute;
        sec = second;
    }

    public Time(int second) { //конструктор, получающий секунды
        sec = second;
    }

    public int getSec() {
        return sec;
    }

    public void setSec(int s) {
        sec = s;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int m) {
        min = m;
    }

    public int getHour() {
        return h;
    }

    public void setHour(int h) {
        this.h = h;
    }

    public int changeToSec(int hour, int min, int sec) { //метод для получения полного количества секунд
        sec += min * 60 + hour * 3600;
        return sec;
    }

    public void compareTime(Time t2) { //метод для сравнения двух объектов
        switch (this.sec.compareTo(t2.sec)) {
            case -1:
                System.out.println("Time 2 > Time 1");
                break;
            case 0:
                System.out.println("Time 1 = Time 2");
                break;
            default:
                System.out.println("Time 1 > Time 2");
        }
    }

    public void printTime() { //метод для вывода данных
        System.out.println(sec + " sec");
    }
}
