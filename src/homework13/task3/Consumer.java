package homework13.task3;

/*3. Есть 3 производителя и 2 потребителя, все разные потоки и работают все одновременно.
        Есть очередь с 200 элементами. Производители добавляют случайное число от 1..100, а потребители берут эти числа.
        Если в очереди элементов >= 100 производители спят, если нет элементов в очереди – потребители спят.
        Если элементов стало <= 80, производители просыпаются. Все это работает до тех пор,
        пока обработанных элементов не станет 10000, только потом программа завершается.
         */


import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;


public class Consumer extends Thread {


    Queue<Integer> q;
    static AtomicInteger count;

    public static AtomicInteger getCount() {
        return count;
    }

    public Consumer(Queue q, AtomicInteger count) {
        this.q = q;
        this.count = count;
    }

    public synchronized void run() {

        synchronized (q) {

            if (q.size() > 0) {

                q.remove();
                count.getAndIncrement();

            } else {

                try {
                    this.wait(); //потребители ждут
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }

    }
}

