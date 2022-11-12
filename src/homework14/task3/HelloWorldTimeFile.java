package homework14.task3;

/*3. Создать задачу Callable, которая берет сообщение “Hello World” + текущее время и записывает его в файл
(append = true). Запись в файл должна производиться последовательно через синхронизированный метод. Запустить 10 задач
параллельно в пуле из 3 потоков. Вывести ход программы на экран с указанием имени потока, который выполняет работу.
 */

import java.io.*;
import java.util.Date;
import java.util.concurrent.Callable;

import static java.lang.Thread.currentThread;

public class HelloWorldTimeFile implements Callable {

    Date date = new Date();

    @Override
    public synchronized Object call() throws Exception {

        System.out.println(currentThread().getName() + " is working...");

        //создание файла

        File file = new File("src/homework14/task3/HelloWorldTime.txt");

        //запись файла

        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file, true)))) {
            printWriter.println("Hello World - " + date.toString());
        }

        return null;
    }
}
