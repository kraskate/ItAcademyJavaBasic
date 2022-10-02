public class Homework3 {
    public static void main(String[] args) {

        //1. Вычислить факториал целых чисел от 0 до 10 с помощью цикла while для каждого.
        System.out.println("Task 1");
        int at1 = 0;
        int bt1 = 10;
        findFactorial(at1, bt1);

        //2. Вычислить произведение чисел от 1 до 25 с помощью цикла do while.
        System.out.println("Task 2");
        int at2 = 1;
        int bt2 = 25;
        multiplication(at2, bt2);

        //3. Посчитать сумму цифр числа 7893823445 с помощью цикла do while.
        System.out.println("Task 3");
        long at3 = 78938223445L;
        multiplOfDigits(at3);

        //4. Найти среди чисел от 50 до 70 второе простое число (число называют простым,
        // если оно делится без остатка только на 1 и себя) и завершить цикл с использованием break.

        System.out.println("Task 4");
        int at4 = 50;
        int bt4 = 70;
        findSecondPrime(at4, bt4);

        //5. Для целых чисел, которые делятся на 7 в диапазоне от 1 до 100, вывести на экран строку “Hope!”.
        System.out.println("Task 5");
        int at5 = 1;
        int bt5 = 100;
        int ct5 = 7;
        hopeFor7(at5, bt5, ct5);
//
        //6. Задать произвольное целое число и вывести его в бухгалтерском формате, то есть, начиная справа,
        // каждые три позиции отделяются пробелом. Например, число 20023143 должно быть выведено как 20 023 143.
        System.out.println("Task 6");
        long at6 = -1000000000L;
        accountFormat(at6);
    }


    //1. Вычислить факториал целых чисел от 0 до 10 с помощью цикла while для каждого.
    public static void findFactorial(int number, int toNumber) {
        int i = 1;
        while (number <= toNumber) {
            int mult = 1;
            if (number == 0) {
                mult = 1;
            }
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
    public static void multiplication(int i, int toNumber) {
        long mult = 1;
        do {
            mult *= i;
            i++;
        }
        while (i <= toNumber);
        System.out.println(mult);
    }

    //3. Посчитать сумму цифр числа 7893823445 с помощью цикла do while.
    public static void multiplOfDigits(long number) {
        int mult = 1;
        do {
            mult *= number % 10;
            number /= 10;
        } while (number != 0);
        System.out.println("The multiplication of gigits = " + mult);
    }

    //4. Найти среди чисел от 50 до 70 второе простое число (число называют простым,
    // если оно делится без остатка только на 1 и себя) и завершить цикл с использованием break.
    public static void findSecondPrime(int number, int toNumber) {
        int count = 0;
        while (number <= toNumber) {
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
    public static void hopeFor7(int fromNumber, int toNumber, int x) {
        for (int i = fromNumber; i <= toNumber; i++) {
            if (i % x == 0) {
                System.out.println(i + " - Hope!");
            }
        }
    }

    //6. Задать произвольное целое число и вывести его в бухгалтерском формате, то есть, начиная справа,
    // каждые три позиции отделяются пробелом. Например, число 20023143 должно быть выведено как 20 023 143.
    public static void accountFormat(long number) {
        // Проверяем на отрицательность числа. Если число отрицательное, выводим "минус" и переводим число в разряд
        // положительных.
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

        for(int i = countOfDigits; i > 0; i--){
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
