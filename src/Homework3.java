public class Homework3 {
    public static void main(String[] args) {

        //1. Вычислить факториал целых чисел от 0 до 10 с помощью цикла while для каждого.
        System.out.println("Task 1");
        findFactorial();

        //2. Вычислить произведение чисел от 1 до 25 с помощью цикла do while.
        System.out.println("Task 2");
        multiplication();

        //3. Посчитать сумму цифр числа 7893823445 с помощью цикла do while.
        System.out.println("Task 3");
        multiplOfDigits();

        //4. Найти среди чисел от 50 до 70 второе простое число (число называют простым,
        // если оно делится без остатка только на 1 и себя) и завершить цикл с использованием break.

        System.out.println("Task 4");
        findSecondPrime();

        //5. Для целых чисел, которые делятся на 7 в диапазоне от 1 до 100, вывести на экран строку “Hope!”.
        System.out.println("Task 5");
        hopeFor7();

        //6. Задать произвольное целое число и вывести его в бухгалтерском формате, то есть, начиная справа,
        // каждые три позиции отделяются пробелом. Например, число 20023143 должно быть выведено как 20 023 143.
        System.out.println("Task 6");
        accountFormat();
    }


    //1. Вычислить факториал целых чисел от 0 до 10 с помощью цикла while для каждого.
    public static void findFactorial() {
        int number = 0;
        int i = 0;
        while (number <= 10) {
            int mult = 1;
            while (i <= number) {
                mult *= i;
                i++;
            }
            System.out.println(number + "! = " + mult);
            number++;
            mult = 1;
            i = 1;
        }
    }

    //2. Вычислить произведение чисел от 1 до 25 с помощью цикла do while.
    public static void multiplication() {
        int i = 1;
        long mult = 1;
        do {
            mult *= i;
            i++;
        }
        while (i <= 9);
        System.out.println(mult);
    }

    //3. Посчитать сумму цифр числа 7893823445 с помощью цикла do while.
    public static void multiplOfDigits() {
        long number = 78938223445L;
        int mult = 1;
        do {
            mult *= number % 10;
            number /= 10;
        } while (number != 0);
        System.out.println("The multiplication of gigits = " + mult);
    }

    //4. Найти среди чисел от 50 до 70 второе простое число (число называют простым,
    // если оно делится без остатка только на 1 и себя) и завершить цикл с использованием break.
    public static void findSecondPrime() {
        int number = 50;
        int count = 0;
        while (number <= 70) {
            for (int i = 2; i <= number - 1; i++) {
                if (number % i == 0) {
                    break;
                }
                if (i == number - 1 && number % i != 0) {
                    count++;
                    System.out.println(count + " prime number is " + number);
                }
            }
            number++;
            if (count == 2) break;
        }
    }

    //5. Для целых чисел, которые делятся на 7 в диапазоне от 1 до 100, вывести на экран строку “Hope!”.
    public static void hopeFor7() {
        for (int i = 1; i <= 100; i++) {
            if (i % 7 == 0) {
                System.out.println(i + " - Hope!");
            }
        }
    }

    //6. Задать произвольное целое число и вывести его в бухгалтерском формате, то есть, начиная справа,
    // каждые три позиции отделяются пробелом. Например, число 20023143 должно быть выведено как 20 023 143.
    public static void accountFormat() {
        // Проверяем на отрицательность числа. Если число отрицательное, выводим "минус" и переводим число в разряд
        // положительных.
        long number = -6500398435786641137L;
        if (number < 0) {
            System.out.print("-");
            number = -number;
        }
        if (number == 0) System.out.println(number);
        // Считаем количество цифр (разрядов) в числе
        int countOfDigits = 0;
        long temp = number;
        while (temp != 0) {
            countOfDigits++;
            temp /= 10;
        }
        int space = 0;
        int firstSpace = countOfDigits % 3; //определяем после какого разряда должен стоять первый пробел
        long digit;

        while (number > 0) {
            digit = number / (long) Math.pow(10, (countOfDigits - 1)); //определяем очередную цифру слева направо
            System.out.print(digit);
            space++;
            if (space == firstSpace) System.out.print(" "); // первый пробел
            if (space == firstSpace + 3) {   //последующие пробелы
                System.out.print(" ");
                space = firstSpace;
            }
            number -= digit * (long) Math.pow(10, countOfDigits - 1);  //уменьшаем число, чтобы находить последующие цифры
            countOfDigits--;
        }

    }

}


