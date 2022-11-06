package homework15.task3;

        /*3.Создайте простейший логгер, выводящий сообщения об ошибках в текстовый файл. Объект логгера должен быть
        создан с помощью ШП Singleton. У объекта должен быть обязательным один метод, получающий на вход текст
        сообщения об ошибке и записывающий его в файл вместе с информацией о дате и времени происшествия.
         */

import java.io.*;
import java.util.Date;

public class Logger {

    public static File logger;

    private Logger() {
    }

    static Date date = new Date();

    public static synchronized void printLogger(String textOfMistake) {

        if (logger == null) {
            logger = new File("src/homework15/task3/logger.txt");
        }

        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(logger, true)))) {
            printWriter.println(textOfMistake + " - " + date.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
