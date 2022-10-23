package homework12;

/*3. Создать класс поток, который создает средствами Java файл и записать в него произвольно сгенерированный массив
из 10 случайных целых чисел. Запустить 5 потоков.
 */

import java.io.*;
import java.util.Random;

public class ThreadTask3 extends Thread {

    @Override
    public void run() {
        File file = new File("D:\\java_course_basic\\ItAcademyJavaBasic2\\src\\homework12\\task3\\" + getName() + ".txt");
        file.delete();

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Random random = new Random();

        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file, true)))) {

            printWriter.print(getName() + "[] = {");

            for (int j = 0; j < 10; j++) {
                printWriter.print(random.nextInt(50));

                if (j < 9) {
                    printWriter.print(" ");
                }
            }

            printWriter.println("}");

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Look at the file - " + file.getAbsolutePath());

    }
}
