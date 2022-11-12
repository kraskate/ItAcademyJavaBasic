package homework13;

import homework13.task2.Thread1Task2;
import homework13.task2.Thread2Task2;
import homework13.task2.Thread3Task2;
import homework13.task3.Consumer;
import homework13.task3.Producer;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Homework13 {

    //Синхронизация

    public static void main(String[] args) {


    /*1. Создать метод, который печатает название потока и засыпает на 2 секунды. Запустить одновременно 10 потоков.
    Реализовать механизм синхронизации, чтобы все потоки выполнились последовательно.
     */

        System.out.println("----- Task 1 -----");

        for (int i = 0; i < 10; i++) {

            Thread1 th = new Thread1();
            th.setName("thread - " + i);
            th.start();

            try {
                th.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        /*2. Создать программу, которая реализует deadlock между тремя потоками.
         */

        System.out.println("\n----- Task 2 -----");

        Thread1Task2 t1 = new Thread1Task2();
        Thread2Task2 t2 = new Thread2Task2();
        Thread3Task2 t3 = new Thread3Task2();
        t1.start();
        t2.start();
        t3.start();



        /*3. Есть 3 производителя и 2 потребителя, все разные потоки и работают все одновременно.
        Есть очередь с 200 элементами. Производители добавляют случайное число от 1..100, а потребители берут эти числа.
        Если в очереди элементов >= 100 производители спят, если нет элементов в очереди – потребители спят.
        Если элементов стало <= 80, производители просыпаются. Все это работает до тех пор,
        пока обработанных элементов не станет 10000, только потом программа завершается.
         */


        System.out.println("\n----- Task 3 -----");

        //создание очереди из 200 элементов

        Random random = new Random();

        Queue<Integer> queue = new LinkedList<Integer>();
        int number = 0;

        while (queue.size() < 200) {
            number = random.nextInt(101);
            if (number != 0) {
                queue.add(number);
            }
        }

        //создание и открытие потоков

        AtomicInteger count = new AtomicInteger();

        while (count.get() < 10_000) {

            Producer th1 = new Producer(queue);
            Producer th2 = new Producer(queue);
            Producer th3 = new Producer(queue);

            Consumer th4 = new Consumer(queue, count);
            Consumer th5 = new Consumer(queue, count);


            th4.start();
            th5.start();

            th1.start();
            th2.start();
            th3.start();

            try {
                th1.join();
                th2.join();
                th3.join();
                th4.join();
                th5.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            count = Consumer.getCount();

        }
        System.out.println("Queue size = " + queue.size());
        System.out.println("Count = " + Consumer.getCount());
    }

}

