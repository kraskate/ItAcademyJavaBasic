package homework12;

        /*2. Создать класс поток, который генерирует массив случайных целых чисел из 10 элементов,
        затем находит максимальный элемент, в этом массиве, и выводит на экран в формате имя потока,
        максимальный элемент. Запустить 10 потоков.
         */

import java.util.Random;

public class ThreadTask2 implements Runnable {

    Thread th;

    public ThreadTask2() {
        th = new Thread(this);
    }

    @Override
    public void run() {
        Random random = new Random();

        int[] number = new int[10];
        int max = number[0];

        for (int i : number) {
            i = random.nextInt(20);

            if (i > max) {
                max = i;
            }

        }

        System.out.println(th.getName() + " -- max = " + max);
    }

    void start() {
        th.start();
    }

}
