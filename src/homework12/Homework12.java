package homework12;

public class Homework12 {

    //Thread

    public static void main(String[] args) {

        Thread currentThread = new Thread();

    /*1. Создать 10 потоков, каждый из которых вычисляет среднее арифметическое коллекции из 10 случайных целых чисел
    и выводит на экран.
    */

        System.out.println("_____ Task 1 _____");

        for (int i = 0; i < 10; i++) {

            String name = "thread " + i;
            ThreadTask1 thread = new ThreadTask1();
            thread.setName(name);
            thread.start();

        }

        System.out.println();


        /*2. Создать класс поток, который генерирует массив случайных целых чисел из 10 элементов,
        затем находит максимальный элемент, в этом массиве, и выводит на экран в формате имя потока,
        максимальный элемент. Запустить 10 потоков.
         */

        try {
            currentThread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n_____ Task 2 _____");

        for (int i = 0; i < 10; i++) {

            ThreadTask2 thread = new ThreadTask2();
            thread.start();

        }

        System.out.println();


        /*3. Создать класс поток, который создает средствами Java файл и записать в него произвольно сгенерированный
        массив из 10 случайных целых чисел. Запустить 5 потоков.
         */

        try {
            currentThread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n_____ Task 3 _____");

        for (int i = 0; i < 5; i++) {
            ThreadTask3 thread = new ThreadTask3();
            thread.setName("thread-" + i);
            thread.start();
        }

        System.out.println();

    }
}
