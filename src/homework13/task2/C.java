package homework13.task2;

import homework13.task2.A;

public class C {
    synchronized void methodC(A a) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " - C.methodC()");

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Exception at C");
        }

    }

}
