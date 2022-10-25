package homework9;

import java.util.*;

public class Homework9 {

    public static void main(String[] args) {

        /* 1. Создать список оценок учеников с помощью ArrayList, заполнить случайными оценками.
        Удалить неудовлетворительные оценки из списка.
         */

        System.out.println("\n***** Task 1 *****");

        List<Integer> markList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 25; i++) {
            markList.add(random.nextInt(11));
        }

        System.out.println("Mark list: " + markList);

        for (int i = 0; i < markList.size(); i++) {
            if (markList.get(i) < 5) {
                markList.remove(i);
                i--;
            }
        }

        System.out.println("New mark list: " + markList);


        /* 2. Создать коллекцию, заполнить ее случайными целыми числами. Удалить повторяющиеся числа.
        Результат - коллекция без повторов.
        */

        System.out.println("\n***** Task 2 *****");

        List<Integer> randomList = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            randomList.add(rand.nextInt(20));
        }

        System.out.println("Random list: " + randomList);

        Set<Integer> setList = new HashSet<>(randomList);

        System.out.println("Set list: " + setList);


        /* 3. Создать список оценок учеников с помощью ArrayList, заполнить случайными оценками.
        Найти самую высокую оценку с использованием итератора.
         */

        System.out.println("\n***** Task 3 *****");

        List<Integer> marks = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < 25; i++) {
            marks.add(r.nextInt(11));
        }

        System.out.println("All marks: " + marks);

        Set<Integer> setMarks = new HashSet<>(marks);
        System.out.println("Set of marks: " + setMarks);

        Iterator<Integer> iterator = setMarks.iterator();

        int maxMark = iterator.next();

        while (iterator.hasNext()) {

            int temp = iterator.next();

            if (temp > maxMark) {
                maxMark = temp;
            }

        }

        System.out.println("Max mark = " + maxMark);


        /* 4. Ввести текст с клавиатуры. Для текста создать Map, где ключом будет слово,
        а значение – количество повторений этого слова в тексте.
         */

        System.out.println("\n***** Task 4 *****");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text...");
        String text = sc.nextLine();

        text = text.strip(); //удаление пробелов в начале и в конце текста
        text = text.toLowerCase(); //приведение к нижнему регистру
        text = text.replaceAll("[.+;,!?:\"()]", ""); //удаление знаков препинания и других символов

        System.out.println("Formatted text: \n" + text);

        List<String> words = new ArrayList<>(List.of(text.split(" +"))); //создание массива слов
        System.out.println("Array of words: \n" + words);

        Set<String> keys = new HashSet<>(words);
        System.out.println("Keys from words: \n" + keys);

        Map<String, Integer> map = new HashMap<>();

        Iterator<String> iter = keys.iterator();
        String keyForMap;
        int count;

        while (iter.hasNext()) {

            keyForMap = iter.next();
            count = 0;

            for (String word : words) {
                if (word.equals(keyForMap)) {
                    count++;
                }
            }

            map.put(keyForMap, count);
        }

        System.out.println("Map: \n" + map);

    }

}
