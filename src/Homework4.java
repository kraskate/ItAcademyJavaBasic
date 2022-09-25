import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;

public class Homework4 {
    public static void main(String[] args) {

        //1. Создайте переменную для массива из 10 элементов.
        // Заполните его произвольными значениями целочисленного типа и выведите последний элемент массива на экран.
        System.out.println(" - Task 1");
        int countOfElements1 = 10;
        lastElement(countOfElements1);

        //2. Создайте переменную для массива из 10 элементов (другим способом).
        // Выведите на экран элементы, стоящие на четных позициях (индексы).
        System.out.println(" - Task 2");
        int[] array = {156, -659, 45, 8746, 0, -598, -52, 74, 6, 871};
        showOddPositions(array);

        //3. Создайте переменную для массива из 10 элементов. Заполните его произвольными значениями
        // целочисленного типа. Найдите максимальный элемент и выведите его индекс.
        System.out.println(" - Task 3");
        int countOfElements3 = 10;
        indexOfMaxElement(countOfElements3);

        //4. Создайте переменную для массива из 10 элементов. Заполните его произвольными значениями целочисленного типа.
        // Определите сумму элементов массива, расположенных между минимальным и максимальным значениями (не включая).
        // Если значений максимальных и минимальных несколько, то необходимо взять максимальное значение разницы
        // индексов между максимальным и минимальным значениями.
        System.out.println(" - Task 4");
        int countOfElements4 = 10;
        sumMinMax(countOfElements4);

        //5. Создайте переменную для массива из 10 элементов. Заполните его произвольными значениями
        // целочисленного типа. Выведите на экран, переверните и снова выведите на экран
        // (при переворачивании нежелательно создавать еще один массив).
        System.out.println(" - Task 5");
        int countOfElements5 = 10;
        coup(countOfElements5);

        //6. Создать двухмерный квадратный массив и заполнить его «бабочкой», то есть таким образом:
        //1 1 1 1 1
        //0 1 1 1 0
        //0 0 1 0 0
        //0 1 1 1 0
        //1 1 1 1 1
        System.out.println(" - Task 6");
        int m = 5;
        butterfly(m);

    }

    public static void lastElement(int n) {
        Random rand = new Random();
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt();
        }
        System.out.println("array[" + (n - 1) + "] = " + array[n - 1]);
    }

    public static void showOddPositions(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) System.out.println("a[" + i + "] = " + array[i]);
        }
    }

    public static void indexOfMaxElement(int n) {
        Random rand = new Random();
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt();
        }
//        System.out.println(Arrays.toString(array));
        int index = 0;
        int max = array[index];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                index = i;
            }
        }
        System.out.println("The index of the maxim element is " + index);
    }

    public static void sumMinMax(int n) {
        Random rand = new Random();
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(10);
        }
//        System.out.println(Arrays.toString(array));

        int indexMin = 0;
        int minElement = array[indexMin];
        int indexMax = 0;
        int maxElement = array[indexMax];
        int tempDistance = 0;

        // Находим макс и мин элементы
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minElement) {
                minElement = array[i];
            }
        }
        for (int j = 1; j < array.length; j++) {
            if (array[j] > maxElement) {
                maxElement = array[j];
            }
        }

        // Находим максимальное количество элементов между максимальным и минимальным.
        for (int k = 0; k < array.length; k++) {
            if (array[k] == minElement) {
                for (int l = 0; l < array.length; l++) {
                    if (array[l] == maxElement) {
                        if (tempDistance < Math.abs(l - k)) {
                            indexMin = k;
                            indexMax = l;
                            tempDistance = Math.abs(l - k);
                        }
                    }
                }
            }
        }

//        System.out.println("min = a[" + indexMin + "] = " + minElement);
//        System.out.println(("max = a[" + indexMax + "] = " + maxElement));

        //Находим сумму элементов между макс и мин
        int sum = 0;
        if (indexMax > indexMin) {
            for (int j = indexMin + 1; j < indexMax; j++) {
                sum += array[j];
            }
        } else {
            for (int j = indexMax + 1; j < indexMin; j++) {
                sum += array[j];
            }
        }
        System.out.println("Sum = " + sum);
    }

    public static void coup(int n) {
        Random rand = new Random();
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(10);
        }
        System.out.println(Arrays.toString(array));
        int temp;
        int j = 0;
        for (int i = array.length - 1; i > 0; i--) {
            if (j < i) {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                j++;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void butterfly(int a) {
        int[][] array = new int[a][a];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i < array.length / 2) {
                    if (j >= i && j < array.length - i) array[i][j] = 1;
                } else if (i >= array.length / 2) {
                    if (j >= (array.length - 1) - i && j <= i) array[i][j] = 1;
                } else if (i == j) array[i][j] = 1;
            }
        }

        for (int m = 0; m < array.length; m++) {
            for (int n = 0; n < array[m].length; n++) {
                System.out.print(array[m][n]);
            }
            System.out.println();
        }
    }
}


