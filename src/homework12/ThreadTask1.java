package homework12;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreadTask1 extends Thread {

//    Thread th;

//    public ThreadTask1() {
//        th = new Thread();
//    }

    @Override
    public void run() {

        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            numbers.add(random.nextInt(20));
        }

        System.out.println(getName() + " : " + numbers);

        int sum = 0;
        double average;

        for (Integer e : numbers) {
            sum += e;
        }

        average = (double) sum / numbers.size();

        System.out.println(getName() + " - average = " + average);

    }

}
