package homework13.task2;

public class B {
    synchronized void methodB(C c) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " - B.methodB()");

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Exception at B");
        }
    }

}
