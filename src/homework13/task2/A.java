package homework13.task2;

public class A {
    synchronized void methodA(B b) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " - A.methodA()");

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Exception at A");
        }
    }
}
