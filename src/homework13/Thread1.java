package homework13;

/*Создать метод, который печатает название потока и засыпает на 2 секунды. Запустить одновременно 10 потоков.
    Реализовать механизм синхронизации, чтобы все потоки выполнились последовательно.
 */

public class Thread1 extends Thread {

    @Override
    public synchronized void run() {

        System.out.println(getName());
        try {
            this.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
