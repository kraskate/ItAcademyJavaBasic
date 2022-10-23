package homework11;

import homework11.task6.Person;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Homework11 {

    public static void main(String[] args) {

        Random random = new Random();

        /*1. Вывести список файлов и каталогов выбранного каталога на диске.
        Файлы и каталоги должны быть распечатаны отдельно (на экран).
         */

        System.out.println("***** Task 1 *****");
        File dir = new File("D:/Программирование");
        checkDirectoryInside(dir);
        System.out.println();


        /*2. Создать файл с текстом, прочитать, подсчитать в тексте количество знаков препинания и слов.
        Вывести результат на экран.
         */

        System.out.println("***** Task 2 *****");

        File f = new File("src/homework11/task2.txt");

        if (f.exists()) {

            FileReader fileReader = null;
            StringBuilder text = new StringBuilder();

            char[] punctuationMark = {'.', ',', ';', ':', '!', '?', '(', ')', '"'};
            int countOfPunctuationMark = 0;

            try {

                fileReader = new FileReader(f);
                BufferedReader reader = new BufferedReader(fileReader);

                int symb = reader.read();

                while (symb != -1) {

                    System.out.print((char) symb);
                    text.append((char) symb);

                    for (char a : punctuationMark) {

                        if ((char) symb == a) {
                            countOfPunctuationMark++;
                        }

                    }

                    symb = reader.read();

                }

                String newText = text.toString().strip();   //удаление пробелов в начале и в конце текста

                List<String> words = new ArrayList<>(List.of(newText.split(" +")));     //создание массива слов

                System.out.println("\n" + words.size() + " words in the text");
                System.out.println(countOfPunctuationMark + " punctuation marks in the text");

            } catch (IOException e) {
                e.printStackTrace();
            } finally {

                try {
                    if (fileReader != null) {
                        fileReader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        } else {
            System.out.println("The file not found");
        }

        System.out.println();


        /*3. Создать файл с текстом, в котором присутствуют числа. Найти все числа, вывести на экран,
        посчитать сумму, вывести на экран, убрать все повторяющиеся числа и снова вывести на экран.
         */

        System.out.println("***** Task 3 *****");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("src/homework11/task3.txt")))) {

            StringBuilder str = new StringBuilder();

            String read = "";   //чтение текста и создание объекта StringBuilder для дальнейшей работы

            while (read != null) {
                read = bufferedReader.readLine();
                str.append(read + "\n");
                System.out.println(read);
            }

            List<String> words = new ArrayList<String>(List.of(str.toString().split(" +")));
            List<String> numbers = new ArrayList<>();

            Pattern p = Pattern.compile("-?\\d+");  //выделение из текста чисел
            Matcher m = p.matcher(str.toString());

            while (m.find()) {
                numbers.add(m.group());
            }

            System.out.println("Numbers in the text: " + numbers);

            int sum = 0;    //поиск суммы чисел

            for (String element : numbers) {
                int num = Integer.parseInt(element);
                sum += num;
            }

            System.out.println("Sum of all numbers = " + sum);

            Set<String> setOfNumbers = new HashSet<>(numbers);  //список без повторений
            System.out.println("Non-repeating numbers: " + setOfNumbers);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();


        /*4. Записать с помощью Java в двоичный файл 20 случайных чисел.
        Прочитать записанный файл, вывести на экран числа и их среднее арифметическое.
         */

        System.out.println("***** Task 4 *****");

        File task4 = new File("src/homework11/task4.txt");
        task4.delete();
        try {
            task4.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream
                (new FileOutputStream(task4, true)))) {

            for (int i = 0; i < 20; i++) {
                dos.writeInt(random.nextInt(20));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (DataInputStream dis = new DataInputStream(new BufferedInputStream
                (new FileInputStream("src/homework11/task4.txt")))) {

            int data = dis.readInt();
            int sum = 0;
            double average = 0;
            int count = 0;

            while (true) {
                sum += data;
                count++;
                System.out.print(data + " ");

                try {
                    data = dis.readInt();
                } catch (EOFException e) {
                    break;
                }

            }

            average = (double) sum / count;

            System.out.println("\nAverage = " + sum + " / " + count + " = " + average);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();


        /*5. Создать цепочку из трех папок. В конечном каталоге создать 5 произвольных текстовых файлов.
        Заполнить их 10 случайными целыми числами. Содержимое файлов записать в один файл в том же каталоге.
        Создать файл, который будет содержать список файлов данного каталога.
         */

        System.out.println("***** Task 5 *****");

        File[] files = new File[5];

        for (int i = 1; i <= 5; i++) {  //создание 5 файлов с удалением предыдущих
            files[i - 1] = new File("D:\\java_course_basic\\ItAcademyJavaBasic2\\src\\homework11\\task5\\task5.1\\Task5.1.1\\" + i + ".txt");
            files[i - 1].delete();
            try {
                files[i - 1].createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        for (File element : files) {    //заполнение случайными числами

            try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(element, true)))) {

                for (int j = 0; j < 10; j++) {
                    printWriter.println(random.nextInt(100));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // создание итогового файла с удалением предыдущего
        File result = new File("D:\\java_course_basic\\ItAcademyJavaBasic2\\src\\homework11\\task5\\task5.1\\Task5.1.1\\result.txt");
        result.delete();
        try {
            result.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (PrintWriter printResult = new PrintWriter(new BufferedWriter(new FileWriter(result, true)))) {

            for (File fl : files) {
                try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fl))) {

                    String read = "";

                    while (read != null) {
                        read = bufferedReader.readLine();
                        if (read != null) {
                            printResult.print(read + " ");
                        }
                    }

                    printResult.println();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        //создание списка файлов данного каталога

        File listOfFiles = new File("D:\\java_course_basic\\ItAcademyJavaBasic2\\src\\homework11\\task5\\task5.1\\Task5.1.1\\list.txt");
        listOfFiles.delete();
        try {
            listOfFiles.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File directory = new File("D:\\java_course_basic\\ItAcademyJavaBasic2\\src\\homework11\\task5\\task5.1\\Task5.1.1");
        String[] list = directory.list();

        try (PrintWriter printList = new PrintWriter(new FileWriter(listOfFiles))) {

            for (String name : list) {
                printList.println(name);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Look at the directory " + directory.getAbsolutePath());

        System.out.println();


        /*6. Создать объект Person c полями name, surname, age. Создать два массива (имена и фамилии).
        Сгенерировать 10 объектов класса Person со случайным age и случайно выбранными именами и фамилиями
        соответствующего типа. С помощью Java создать файл, в который запишется информация о этих людях.
         */

        System.out.println("***** Task 6 *****");

        String[] name = {"Margo", "Alex", "Irena", "Olga", "Lion", "Kate", "Daria", "Vlad", "Medea", "Serge"};
        String[] surname = {"Glavdel", "Krasichenko", "Judenko", "Hurs", "Prince", "Molohovets", "Dajneko",
                "Adamtsevich", "Korol", "Snitko"};

        File randomPerson = new File("D:\\java_course_basic\\ItAcademyJavaBasic2\\src\\homework11\\task6\\randomPerson");
        randomPerson.delete();
        try {
            randomPerson.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(randomPerson, true))) {

            for (int i = 0; i < 10; i++) {
                String surnameOfPerson = surname[random.nextInt(surname.length)];
                String nameOfPerson = name[random.nextInt(name.length)];

                Person person = new Person(surnameOfPerson, nameOfPerson, random.nextInt(100));

                oos.writeObject(person);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(randomPerson))) {

//            Object o = ois.readObject();
//            Person p = null;

            Object o = null;

            for (int i = 0; i < 10; i++) {

                try {
                    o = ois.readObject();
                } catch (EOFException e) {
                    e.printStackTrace();
                    break;
                }

                Person p = null;
                if (o instanceof Person) {
                    p = (Person) o;
                }

                if (p != null) {
                    System.out.println(p);
                }

            }

//            while (true) {    //выдает ошибку
//
//                if (o instanceof Person) {
//                    p = (Person) o;
//                }
//
//                if (p != null) {
//                    System.out.println(p);
//                }
//
//                try {
//                    o = ois.readObject();
//                } catch (EOFException e) {
//                    e.printStackTrace();
//                    break;
//                }
//
//            }


//            do {      //выдает ошибку
//
//                if (o instanceof Person) {
//                    p = (Person) o;
//                }
//
//                if (p != null) {
//                    System.out.println(p);
//                }
//                try {
//                    o = ois.readObject();
//                } catch (EOFException e) {
//                    e.printStackTrace();
//                    break;
//                }
//
//            } while (o != null);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    /*1. */

    public static void checkDirectoryInside(File dir) {

        if (dir.exists() && dir.isDirectory()) {
            System.out.println("Directory " + dir.getName() + " exists");

            File[] listFiles = dir.listFiles();

            List<String> directoryInside = new ArrayList<>();   //список каталогов внутри
            List<String> fileInside = new ArrayList<>();    //список файлов внутри

            List<File> directoryForOpen = new ArrayList<File>();    //массив каталогов, которые нужно открыть и проверить

            if (listFiles != null) {

                for (File el : listFiles) {
                    if (el.isDirectory()) {
                        directoryInside.add(el.getName());
                        directoryForOpen.add(el);
                    } else {
                        fileInside.add(el.getName());
                    }
                }

                //Проходим по списку массива каталогов. Открываем каждую папку, забираем названия файлов и каталогов,
                // каталоги добавляем в массив каталогов, удаляем эту папку.
                // Массив обновляется новыми каталогами.

                while (!directoryForOpen.isEmpty()) {

                    listFiles = directoryForOpen.get(0).listFiles();

                    for (File el : listFiles) {

                        if (el.isDirectory()) {
                            directoryInside.add(el.getName());
                            directoryForOpen.add(el);

                        } else {
                            fileInside.add(el.getName());
                        }
                    }
                    directoryForOpen.remove(0);

                }

                System.out.println("Directories inside: \n" + directoryInside);
                System.out.println("Files inside: \n" + fileInside);
            }

        } else {
            System.out.println("Directory " + dir.getName() + " doesn't exist");
        }

    }


}
