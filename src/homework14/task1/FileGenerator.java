package homework14.task1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

/*1. Создать задачу Callable, которая генерирует 10 файлов с 10 произвольными строками -> засыпает произвольно
на 1-3 секунды, результат выполнения – коллекция имен файлов. Запустить 10 задач параллельно в пуле из 3 потоков.
Вывести ход программы на экран с указанием имени потока, который выполняет работу.
 */

public class FileGenerator implements Callable<List<String>> {

    Random random = new Random();
    List<String> names = new ArrayList<String>();
    static AtomicInteger count = new AtomicInteger();

    @Override
    public List<String> call() throws Exception {

        System.out.println(currentThread().getName() + " is working...");

        File[] file = new File[10];

        //создание 10 файлов с удалением ранее созданных

        for (int i = 0; i < 10; i++) {

            file[i] = new File("src/homework14/task1/" +
                    currentThread().getName() + "-file" + count.getAndIncrement() + ".txt");
            file[i].delete();
            file[i].createNewFile();
        }

        //заполнение файлов 10 строками

        for (File f : file) {

            try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(f, true)))) {

                for (int i = 0; i < 10; i++) {

                    printWriter.println("THREAD: " + currentThread().getName() + " - FILE " + f.getName() + " STRING #" + i);

                }
            }

            names.add(f.getName()); //добавление имени файла в список данного потока
        }

        //сон на 1-3 секунды

        sleep((long) (Math.random() * 2000 + 1000));

        return names;
    }
}
