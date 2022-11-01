package homework13.task3;

/*3. Есть 3 производителя и 2 потребителя, все разные потоки и работают все одновременно.
        Есть очередь с 200 элементами. Производители добавляют случайное число от 1..100, а потребители берут эти числа.
        Если в очереди элементов >= 100 производители спят, если нет элементов в очереди – потребители спят.
        Если элементов стало <= 80, производители просыпаются. Все это работает до тех пор,
        пока обработанных элементов не станет 10000, только потом программа завершается.
         */

import java.util.*;

public class Producer extends Thread {

    Random random = new Random();

    Queue<Integer> q;

    int num = 0;


    public Producer(Queue q) {
        this.q = q;
    }

    public synchronized void run() {

        synchronized (q) {

            if (q.size() <= 80) {

                while (q.size() < 100) {

                    num = random.nextInt(101);

                    if (num != 0) {
                        q.offer(num);
                    }
                }
            }

            if (q.size() > 0) {
                q.notifyAll(); //потребители просыпаются
            }
        }
    }
}

