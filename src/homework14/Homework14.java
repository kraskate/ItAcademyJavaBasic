package homework14;

import homework14.task1.FileGenerator;
import homework14.task2.NumberGenerator;
import homework14.task3.HelloWorldTimeFile;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Homework14 {

    public static void main(String[] args) {

        /*1. Создать задачу Callable, которая генерирует 10 файлов с 10 произвольными строками -> засыпает произвольно
        на 1-3 секунды, результат выполнения – коллекция имен файлов. Запустить 10 задач параллельно в пуле
        из 3 потоков. Вывести ход программы на экран с указанием имени потока, который выполняет работу.
         */

        System.out.println("===== Task 1 =====");

        ExecutorService pool1 = Executors.newFixedThreadPool(3);

        List<String> fileNames = new ArrayList<String>(); //массив для хранения имен файлов

        for (int i = 0; i < 10; i++) {
            Future<List<String>> future = pool1.submit(new FileGenerator());

            try {
                fileNames.addAll(future.get()); //формирование итогового списка
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        pool1.shutdown();

        System.out.println("The file names list:"); //вывод списка файлов

        for (String f : fileNames) {
            System.out.println(f);
        }



        /*2. Создать задачу Callable, которая генерирует коллекцию из 10 рандомных целых чисел -> засыпает произвольно
        на 1-10 секунд, результат выполнения – сумму этих чисел в виде строки. Запустить 10 задач параллельно
        в пуле из 3 потоков. Вывести ход программы на экран с указанием имени потока, который выполняет работу.
         */

        System.out.println("\n===== Task 2 =====");

        ExecutorService pool2 = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            Future<String> future = pool2.submit(new NumberGenerator());

            try {
                System.out.println("Sum " + (i + 1) + " = " + future.get()); //вывод суммы чисел коллекции
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println();
        }

        pool2.shutdown();


        /*3. Создать задачу Callable, которая берет сообщение “Hello World” + текущее время и записывает его в файл
        (append = true). Запись в файл должна производиться последовательно через синхронизированный метод.
        Запустить 10 задач параллельно в пуле из 3 потоков. Вывести ход программы на экран с указанием имени потока,
        который выполняет работу.
         */

        System.out.println("\n===== Task 3 =====");

        ExecutorService pool3 = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            pool3.submit(new HelloWorldTimeFile());
        }

        pool3.shutdown();

    }

}
