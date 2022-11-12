package homework14.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

/*2. Создать задачу Callable, которая генерирует коллекцию из 10 рандомных целых чисел -> засыпает произвольно
на 1-10 секунд, результат выполнения – сумму этих чисел в виде строки. Запустить 10 задач параллельно в пуле из
3 потоков. Вывести ход программы на экран с указанием имени потока, который выполняет работу.
*/

public class NumberGenerator implements Callable<String> {

    Random random = new Random();


    @Override
    public String call() throws Exception {

        System.out.println(currentThread().getName() + " is working...");

        List<Integer> numberCollection = new ArrayList<Integer>();
        Integer sum = 0;

        //заполнение коллекции числами

        for (int i = 0; i < 10; i++) {
            int number = random.nextInt(100);
            numberCollection.add(number);
            sum += number;
        }

//        System.out.println(currentThread().getName()); //тест
//        System.out.println(numberCollection);
//        System.out.println("Sum = " + sum);

        sleep((long) Math.random() * 9000 + 1000); //засыпает произвольно на 1-10 секунд

        return sum.toString();
    }
}
