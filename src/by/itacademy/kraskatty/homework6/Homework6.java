package by.itacademy.kraskatty.homework6;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Homework6 {
    public static void main(String[] args) {

        startTask2();

        startTask3();

        startTask4();

        startTask5();

        startTask6();

        startTask7();
    }

    /*2. Введите с клавиатуры строку. Найти в строке не только запятые, но и другие знаки препинания.
        Подсчитать общее их количество.*/

    public static void startTask2() {
        System.out.println("- Task 2 -");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str = in.nextLine();

        char[] charArray = str.toCharArray();
        char[] punctuation = {',', '.', ':', ';', '"', '(', ')', '?', '!', '-'};
        int count = 0;
        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < punctuation.length; j++) {
                if (charArray[i] == punctuation[j]) {
                    if (i < charArray.length - 2 && charArray[i] == charArray[i + 1] &&
                            charArray[i] == charArray[i + 2] && punctuation[j] == '.') {
                        i = i + 2; //многоточие как один знак препинания
                    }
                    count++;
                    break;
                }
            }
        }
        System.out.println("The string has " + count + " punctuation marks");
    }


    /* 3. Введите с клавиатуры текст. Подсчитать количество слов в тексте. 
    Учесть, что слова могут разделяться несколькими пробелами, в начале и конце текста также могут быть пробелы, 
    но могут и отсутствовать.
     */

    public static void startTask3() {
        System.out.println("- Task 3 -");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str = in.nextLine();

        str = str.strip(); //удаление пробелов до первого символа и после последнего, отличных от пробела
        String[] array = str.split(" +"); //формирование массива из слов
        System.out.println(array.length + " word(s) in the text");
    }

    /* 4. Введите с клавиатуры текст. Выведите на экран текст,
    составленный из последних букв всех слов из исходного текста.*/

    public static void startTask4() {
        System.out.println("- Task 4 -");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str = in.nextLine();

        str = str.strip(); //удаление пробелов до первого символа и после последнего, отличных от пробела
        str = str.replaceAll("[^а-яА-Я_0-9a-zA-Z]", " "); //удаление знаков препинания после слов

//        System.out.println(str); //проверка полученного массива слов
        String[] array = str.split(" +"); //формирование массива из слов
        String newStr = ""; //результирующий текст
        StringBuilder strBuilder = new StringBuilder(newStr);

        for (int i = 0; i < array.length; i++) {
            char[] word = array[i].toCharArray();
            strBuilder.append(word[word.length - 1]);
        }

        System.out.println(strBuilder);
    }


    /*5. Введите с клавиатуры строку. Напишите метод, выполняющий поиск в строке шестнадцатеричных чисел,
    записанных по правилам Java, с помощью регулярных выражений. Результат работы метода выведите на экран.
     */

    public static void startTask5() {
        System.out.println("- Task 5 -");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str = in.nextLine();

        Pattern p = Pattern.compile("0x[a-fA-F0-9]{1,}");
        Matcher m = p.matcher(str);

        while (m.find()) {
            System.out.println(m.group());
        }
    }

    /*6. Введите с клавиатуры строку. Напишите метод, выполняющий поиск в строке всех тегов абзацев,
    в том числе тех, у которых есть параметры, например, <p id=”p1”>, и замену их на простые теги абзацев <p>.
    Результат работы метода выведите на экран.
     */
    public static void startTask6() {
        System.out.println("- Task 6 -");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str = in.nextLine();

        System.out.println(str.replaceAll("<p{1}\\s{1}[\"a-zA-Z\\=0-9\\?]+>{1}", "<p>"));

    }

    /*7. Напишите два цикла выполняющих миллион сложений строк вида “aaabbbccc”,
    один с помощью оператора сложения и String, а другой с помощью StringBuilder и метода append.
    Сравните скорость их выполнения. Выведите сравнение на экран. System.currentTimeMillis();s
     */
    public static void startTask7() {
        String str = "aaabbbccc";
        String newStr = "aaabbbccc";

        long time1Start = System.currentTimeMillis();
        for (int count = 1; count <= 1000000; count++) {
            newStr += str;
        }
        long time1End = System.currentTimeMillis();
        long time1 = time1End - time1Start;
        System.out.println(time1);

        StringBuilder strBuilder = new StringBuilder("aaabbbccc");

        long time2Start = System.currentTimeMillis();

        for (int i = 0; i <= 1000000; i++) {
            strBuilder.append("aaabbbccc");
        }

        long time2End = System.currentTimeMillis();
        long time2 = time2End - time2Start;
        System.out.println(time2);

        if (time1 > time2) {
            System.out.println("time1 > time2 in " + time1 / time2 + "times");
        } else if (time1 < time2) {
            System.out.println("time1 < time2 in " + time2 / time1 + "times");
        } else {
            System.out.println("time1 = time2 = " + time1);
        }
    }

}