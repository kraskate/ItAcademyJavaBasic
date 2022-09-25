public class Homework2 {
    public static void main(String[] args) {
        //1. Создайте метод с одним целочисленным параметром. Метод должен определить,
        // является ли последняя цифра числа семеркой и вернуть boolean значение.
        int number = -96582457;
        boolean numberEnds7 = isLast7(number);
        System.out.println("1. Последняя цифра числа - 7 : " + numberEnds7);

        //2. Имеется прямоугольное отверстие размерами a и b, где a и b – целые числа.
        // Определить, можно ли его полностью закрыть круглой картонкой радиусом r (тоже целое число).
        int a = 8;
        int b = 3;
        int r = 12;
        boolean circleCovers = isCovered(a, b, r);
        System.out.println("2. Круг перекрывает отверстие : " + circleCovers);

        //3. Задать целое число в виде переменной, это число – сумма денег в рублях.
        // Вывести это число на экран, добавив к нему слово «рублей» в правильном падеже.
        int money = -142;
        String rub = correctCase(money);
        System.out.println("3. " + money + " " + rub);

        //4. Задать три числа – день, месяц, год. Вывести на экран в виде трех чисел дату следующего дня.
        int d = 28;
        int m = 2;
        int y = 1400;
        if (d < 1 || d > 31 || m < 1 || m > 12) {
            System.out.println("4. Некорректная дата");
        } else {
            String newDate = nextDay(d, m, y);
            System.out.println(newDate);
        }

        //5. Имеются два дома размерами a на b и c на d. Имеется участок размерами e на f.
        // Проверить, помещаются ли эти дома на данном участке. Стороны домов – параллельны сторонам участка,
        // в остальном размещение может быть любым.

        int aH1 = 10;
        int bH1 = 10;
        int cH2 = 5;
        int dH2 = 11;
        int eT = 15;
        int fT = 11;

        if (aH1 <= 0 || bH1 <= 0 || cH2 <= 0 || dH2 <= 0 || eT <= 0 || fT <= 0) {
            System.out.println("5. Некорректные размеры");
        } else {
            boolean enough = checkTerr(aH1, bH1, cH2, dH2, eT, fT);
            System.out.println("5. Размеры участка достаточны для размещения двух домов: " + enough);
        }

        //6. Написать метод, который выводит расписание на неделю. Задать на вход в метод порядковый номер дня недели
        // и отобразить на экране то, что запланировано на этот день.
        int dayOfWeek = 3;
        if (dayOfWeek < 1 || dayOfWeek > 7) {
            System.out.println("6. Некорректный день недели");
        } else {
            String timetableForDay = timetable(dayOfWeek);
            System.out.println("6. Расписание для " + dayOfWeek + " дня недели: \n" + timetableForDay);
        }

    }

    // МЕТОДЫ

    // Является ли последняя цифра числа семеркой
    public static boolean isLast7(int number) {
        return number % 10 == 7 || number % 10 == -7;
    }

    // Закрывает ли круг прямоугольное отверстие
    public static boolean isCovered(int width, int length, int radius) {
        if (width <= 0 || length <= 0) {
            System.out.println("2. Такого отверстия не существует");
            return false;
        } else if (radius <= 0) {
            System.out.println("2. Такого круга не существует");
            return false;
        } else {
            return (2 * radius >= Math.sqrt(width * width + length * length));

        }

    }

    // Выбор правильного падежа
    public static String correctCase(int number) {
        if (number < 0) number = -number;
        if (number % 100 >= 11 && number % 100 <= 19) {
            return "рублей";
        } else {
            switch (number % 10) {
                case 0:
                    return "рублей";
                case 1:
                    return "рубль";
                case 2:
                case 3:
                case 4:
                    return "рубля";
                default:
                    return "рублей";
            }
        }
    }

    // Определение новой даты
    public static String nextDay(int day, int month, int year) {
        String next = "4. Следующий день: ";
        String incorrect = "4. Некорректная дата";
        switch (month) {
            case 2:
                if ((day < 28) || (day == 28 && year % 4 == 0 && year % 100 != 0)) {
                    day++;
                    System.out.print(next);
                } else if ((day == 28 && year % 4 != 0) || (day == 29 && year % 4 == 0)) {
                    day = 1;
                    month++;
                    System.out.print(next);
                } else if ((day == 28) && (year % 100 == 0) && (year % 400 != 0)) {
                    day = 1;
                    month++;
                    System.out.print(next);
                } else if ((day == 28) && (year % 100 == 0) && (year % 400 == 0)) {
                    day++;
                    System.out.print(next);
                } else {
                    System.out.println(incorrect);
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (day < 30) {
                    day++;
                    System.out.print(next);
                } else if (day == 30) {
                    day = 1;
                    month++;
                    System.out.print(next);
                } else {
                    System.out.println(incorrect);
                }
                break;
            case 12:
                if (day < 31) {
                    day++;
                    System.out.print(next);
                } else if (day == 31) {
                    day = 1;
                    month = 1;
                    year++;
                    System.out.print(next);
                } else {
                    System.out.println(incorrect);
                }
                break;
            default:
                if (day < 31) {
                    day++;
                    System.out.print(next);
                } else if (day == 31) {
                    day = 1;
                    month++;
                    System.out.print(next);
                } else {
                    System.out.println(incorrect);
                }
        }
        return day + "." + month + "." + year;
    }

    // Проверка на достаточность размеров участка
    public static boolean checkTerr(int wHouse1, int lHouse1, int wHouse2, int lHouse2, int wTerr, int lTerr) {

        int maxHouse1 = Math.max(wHouse1, lHouse1);
        int maxHouse2 = Math.max(wHouse2, lHouse2);
        int minHouse1 = Math.min(wHouse1, lHouse1);
        int minHouse2 = Math.min(wHouse2, lHouse2);
        int max = Math.max(maxHouse1, maxHouse2);
        int maxTerr = Math.max(wTerr, lTerr);
        int minTerr = Math.min(wTerr, lTerr);

        return (maxTerr >= max && minTerr >= minHouse1 + minHouse2) ||
                (maxTerr >= minHouse1 + minHouse2 && minTerr >= max);
    }

    //Вывод расписания на определенный день недели
    public static String timetable(int dayOfWeek) {
        String note = "";
        switch (dayOfWeek) {
            case 1:
            case 3:
                note = "10:00 - бассейн у Риты \n17:00 - Python у Саши \n18:30 - Java у меня";
                break;
            case 2:
            case 4:
                note = "8:30 - танцы у Риты \n17:00 - бассейн у Саши";
                break;
            case 5:
                note = "19:00 - подработка";
                break;
            case 6:
                note = "12:00 - бассейн у Саши \n14:00 - шахматы у Риты";
                break;
            case 7:
                note = "10:00 - танцы у Риты \n12:00 - шахматы у Риты";
        }
        return note;
    }

}
